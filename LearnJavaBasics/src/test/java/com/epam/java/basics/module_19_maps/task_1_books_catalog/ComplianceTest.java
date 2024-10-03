package com.epam.java.basics.module_19_maps.task_1_books_catalog;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtLambda;
import spoon.reflect.declaration.*;
import spoon.reflect.path.CtRole;
import spoon.reflect.visitor.Filter;
import spoon.reflect.visitor.filter.TypeFilter;

import java.util.*;
import java.util.stream.Collectors;

import static com.tngtech.archunit.base.DescribedPredicate.describe;
import static com.tngtech.archunit.core.domain.JavaCall.Predicates.target;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AnalyzeClasses(packages = "com.epam.java.basics.module_19_maps.task_1_books_catalog", importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeArchives.class,
        ImportOption.DoNotIncludeJars.class
})
public class ComplianceTest {

    static CtModel ctModel;

    static String toPattern(List<String> strings) {
        return strings.stream()
                .map(s -> s.replace(".", "\\."))
                .map(s -> s.replace("*", ".*"))
                .collect(Collectors.joining(".+$)||(^", "(^", ".+$)"));
    }

    @BeforeAll
    static void init() {
        SpoonAPI spoon = new Launcher();
        spoon.addInputResource("src/main/java");
        ctModel = spoon.buildModel();
    }

    @ArchTest
    ArchRule ruleStreams = noClasses()
            .should()
            .callMethodWhere(target(describe("Methods Collection#stream() should not be used",
                    target -> target.getName().equals("stream") &&
                            target.getOwner().isAssignableTo(Collection.class) &&
                            target.getParameterTypes().isEmpty()
            )));

    @ArchTest
    ArchRule ruleSort = noClasses()
            .should()
            .callMethodWhere(target(describe("There is no adequate reason to use Collection#sort(), " +
                            "use sorting containers instead.",
                    target -> "sort".equals(target.getName()) && (
                            target.getOwner().isAssignableTo(Collection.class) ||
                                    target.getOwner().isAssignableTo(Arrays.class)
                    )
            )));

    DescribedPredicate<JavaClass> haveNameBookCatalog = new DescribedPredicate<>("have name BookCatalog") {
        @Override
        public boolean apply(JavaClass javaClass) {
            return javaClass.getName().equals(BooksCatalog.class.getName());
        }
    };

    ArchCondition<JavaClass> condition = new ArchCondition<>("not add additional fields.") {
        @Override
        public void check(JavaClass item, ConditionEvents events) {
            item.getFields().forEach(f -> {
                if (!(f.getName().equals("catalog") || f.getName().equals("EOL"))) {
                    events.add(SimpleConditionEvent.violated(item, "Violated: " + f));
                }
            });
        }
    };

    @ArchTest
    ArchRule noAdditionalFields = classes().that(haveNameBookCatalog).should(condition);

    @ArchTest // no Iterable, List, Set, Map
    ArchRule ruleNoClassesShouldImplementAnyInterface = noClasses().should().implement(new DescribedPredicate<>("") {
        @Override
        public boolean apply(JavaClass javaClass) {
            return !javaClass.getInterfaces().isEmpty();
        }
    });

    @Test
    void testNoMoreFieldsInImpl() {
        List<CtField<?>> fields = ctModel.filterChildren((Filter<CtType<?>>) el ->
                        el.getQualifiedName().equals(BooksCatalog.class.getName()))
                .filterChildren((CtField<?> el) -> el.getParent(new TypeFilter<>(CtType.class))
                        .getQualifiedName().equals(BooksCatalog.class.getName()))
                .select((CtField<?> el) -> !(el.isStatic() && el.isFinal()))
                .list();

        // Impl
        List<CtField<?>> implFields = fields.stream()
                .filter(el -> el.getType().isArray())
                .toList();
        assertEquals(0, implFields.size(),
                "There is no adequate reason to use array fields into 'BooksCatalog' class");
    }

    @Test
    void testNoMorePublicMethods() {
        List<CtMethod<?>> methods = ctModel.filterChildren((Filter<CtType<?>>) el ->
                        el.getQualifiedName().equals(BooksCatalog.class.getName()))
                .filterChildren((CtMethod<?> m) -> m.getParent(new TypeFilter<>(CtType.class))
                        .getQualifiedName().equals(BooksCatalog.class.getName()))
                .list();
        List<String> actual = methods.stream()
                .filter(CtMethod::isPublic)
                .map(CtMethod::getSimpleName)
                .sorted()
                .toList();
        assertEquals(6, actual.size(),
                "You can add only private methods but found: " + actual);
        actual = methods.stream()
                .filter(m -> !(m.isPublic() || m.isPrivate() || m.isProtected()))
                .map(CtMethod::getSimpleName)
                .filter(m -> !m.equals("asTreeString"))
                .toList();
        assertEquals(0, actual.size(),
                "You can add only private methods but found: " + actual);
        actual = methods.stream()
                .filter(CtMethod::isProtected)
                .map(CtMethod::getSimpleName)
                .toList();
        assertEquals(0, actual.size(),
                "You can add only private methods but found: " + actual);
    }

    @Test
    void testNoArrays() {
        List<CtVariable<?>> actual = ctModel
                .filterChildren(new TypeFilter<>(CtVariable.class))
                .select((CtVariable<?> el) -> el.getRoleInParent() != CtRole.PARAMETER)
                .select((CtVariable<?> el) -> el.getType().isArray())
                .list();
        assertEquals(0, actual.size(),
                "You must not use arrays but found: " + actual);
    }

    @Test
    void testComplianceLambda() {
        List<CtLambda<?>> list = ctModel.filterChildren((Filter<CtLambda<?>>) el -> true).list();
        Assertions.assertTrue(list.isEmpty(),
                "Lambdas are not allowed in this project but was: " +
                        list);
    }

    @Test
    void testComplianceFori() {
        List<CtLambda<?>> list = ctModel.filterChildren((Filter<CtFor>) el -> true).list();
        Assertions.assertTrue(list.isEmpty(),
                "Only foreach and while loops are allowed in this project but was: " +
                        list);
    }
}
