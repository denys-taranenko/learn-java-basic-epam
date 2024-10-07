package com.epam.java.basics.module_23_nio_2.task_1_file_tree;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

class FileTreeCodeComplianceTest {

    @Test
    void packageRestrictionTest() {
        final JavaClasses javaClasses = new ClassFileImporter().importClasses(FileTree.class);
        noClasses().should().accessClassesThat().resideInAPackage("java.io")
                .because("You mustn't use anything besides java.nio")
                .check(javaClasses);
    }
}
