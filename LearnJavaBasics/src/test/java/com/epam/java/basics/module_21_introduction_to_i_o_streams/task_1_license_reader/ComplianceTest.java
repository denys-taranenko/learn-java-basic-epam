package com.epam.java.basics.module_21_introduction_to_i_o_streams.task_1_license_reader;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeArchives;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeJars;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.core.importer.ImportOptions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spoon.Launcher;
import spoon.reflect.code.CtTry;
import spoon.reflect.code.CtTryWithResource;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.path.CtRole;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.CompositeFilter;
import spoon.reflect.visitor.filter.FilteringOperator;
import spoon.reflect.visitor.filter.TypeFilter;

@DisplayName("Test for non-functional requirements")
public class ComplianceTest {

    private static final Set<String> ALLOWED_PACKAGES = Set.of(
            "java.lang",
            "java.util",
            "java.io",
            "java.time",
            "java.time.format",
            "edu.epam.fop.io"
    );

    private static final Set<Class<?>> ALLOWED_CLASSES = Set.of(
            File.class,
            IOException.class,
            FileWriter.class,
            FileReader.class,
            BufferedWriter.class,
            BufferedReader.class
    );

    @Test
    void shouldHaveAccessOnlyToBufferedIO() {
        final Set<Class<?>> foundClasses = ConcurrentHashMap.newKeySet();
        classes().should().onlyAccessClassesThat(new DescribedPredicate<>("are allowed by task requirements") {
                    @Override
                    public boolean apply(JavaClass input) {
                        return ALLOWED_PACKAGES.stream().anyMatch(input.getPackageName()::equals) && (
                                !input.getPackageName().equals("java.io") ||
                                        ALLOWED_CLASSES.stream()
                                                .filter(input::isAssignableFrom)
                                                .peek(foundClasses::add)
                                                .findAny().isPresent()
                        );
                    }
                })
                .because("LicenseReader must use only buffered writer/reader for IO interactions")
                .check(new ClassFileImporter().importClasspath(
                                new ImportOptions()
                                        .with(new DoNotIncludeTests())
                                        .with(new DoNotIncludeJars())
                                        .with(new DoNotIncludeArchives())
                        )
                );
        if (!foundClasses.contains(BufferedWriter.class)) {
            throw new AssertionError("Write IO operations must be buffered");
        }
        if (!foundClasses.contains(BufferedReader.class)) {
            throw new AssertionError("Read IO operations must be buffered");
        }
    }

    @Test
    @SuppressWarnings({"varargs"})
    void shouldUseTryWithResources() {
        var spoon = new Launcher();
        spoon.addInputResource("src/main/java/com/epam/java/basics/module_21_introduction_to_i_o_streams/task_1_license_reader");
        spoon.buildModel();
        var factory = spoon.getFactory();
        var model = spoon.getModel();

        assertTrue(model
                .getElements(new CompositeFilter<>(FilteringOperator.SUBSTRACTION,
                        new TypeFilter<>(CtTry.class),
                        new TypeFilter<>(CtTryWithResource.class)))
                .isEmpty(), "No try without resources must be used");

        assertFalse(model
                .getElements(new TypeFilter<>(CtTryWithResource.class))
                .isEmpty(), "try-with-resources must be used to work with IO");

        var invalidRefs = model.getElements(new CompositeFilter<>(FilteringOperator.INTERSECTION,
                        new TypeFilter<>(CtTypeReference.class),
                        ref -> !ref.isPrimitive() && ref.getTypeDeclaration() != null,
                        ref -> ref.isSubtypeOf(factory.Class().createReference(AutoCloseable.class)),
                        ref -> ref.getPackage().equals(factory.Package().createReference("java.io"))
                )).stream()
                .filter(ref -> ref.getParent(el -> el.getRoleInParent() == CtRole.TRY_RESOURCE) == null)
                .toList();
        if (invalidRefs.isEmpty()) {
            return;
        }
        var msg = invalidRefs.stream()
                .filter(ref -> ref.getPackage().isImplicit())
                .map(this::toErrorCodeReference)
                .collect(Collectors.joining("\n".repeat(3)));
        throw new AssertionError("Found usages of IO streams outside of try-with-resources:\n" + msg);
    }

    private String toErrorCodeReference(CtElement element) {
        var pos = element.getPosition();
        return String.format("%s.java:%d", pos.getCompilationUnit().getMainType().getQualifiedName(), pos.getLine());
    }
}
