package com.epam.java.basics.module_18_sets.task_2_project_skills;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author D. Kolesnikov
 */
class ProjectTest {

    //////////////////////////////////////////////////////////////////////////////

    private static boolean isAllTestsMustFailed;

    private static Throwable complianceTestFailedCause;

    static {
        try {
            String testClassName = new Exception().getStackTrace()[0].getClassName();
            String className = testClassName.substring(0, testClassName.lastIndexOf("Test"));
            Class<?> c = Class.forName(className);

            java.lang.reflect.Method[] methods = {
                    c.getDeclaredMethod("getRoles"),
                    c.getDeclaredMethod("getConformity", Set.class)
            };

            org.apache.bcel.classfile.JavaClass jc = org.apache.bcel.Repository.lookupClass(c);
            for (java.lang.reflect.Method method : methods) {
                org.apache.bcel.classfile.Method m = jc.getMethod(method);
                org.apache.bcel.classfile.Code code = m.getCode();
                Assertions.assertTrue(code.getCode().length > 2, () -> m + " is not a stub");
            }
        } catch (Throwable t) {
            isAllTestsMustFailed = true;
            complianceTestFailedCause = t;
            t.printStackTrace();
        }
    }

    static {
        if (isAllTestsMustFailed) {
            Assertions.fail(() -> "Compliance test failed: " + complianceTestFailedCause.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////////

    @Test
    void test1() {
        Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA, Skill.DATABASE),
                new Role(Position.KEY_DEVELOPER, Level.A2, Skill.JAVA, Skill.DATABASE, Skill.SPRING),
                new Role(Position.TESTER, Level.A3, Skill.TESTING_TOOLS, Skill.AWS), new Role(Position.TESTER, Level.A3, Skill.AWS));

        Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.DATABASE),
                new Member("Name2", Level.A2, Skill.JAVA, Skill.DATABASE, Skill.SPRING),
                new Member("Name3", Level.A3, Skill.TESTING_TOOLS, Skill.AWS), new Member("Name4", Level.A3, Skill.TESTING_TOOLS)));

        int expected = 87;
        int actual = project.getConformity(team);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA, Skill.DATABASE),
                new Role(Position.TESTER, Level.A3, Skill.TESTING_TOOLS, Skill.AWS), new Role(Position.TESTER, Level.A3, Skill.AWS));

        Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.DATABASE),
                new Member("Name2", Level.A2, Skill.JAVA, Skill.DATABASE, Skill.SPRING),
                new Member("Name3", Level.A3, Skill.TESTING_TOOLS, Skill.AWS)));

        int expected = 80;
        int actual = project.getConformity(team);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test3() {
        Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA),
                new Role(Position.KEY_DEVELOPER, Level.A2, Skill.JAVA), new Role(Position.TESTER, Level.A3, Skill.TESTING_TOOLS),
                new Role(Position.TESTER, Level.A3, Skill.AWS));

        Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.DATABASE),
                new Member("Name2", Level.A2, Skill.JAVA, Skill.DATABASE), new Member("Name4", Level.A3, Skill.TESTING_TOOLS)));

        int expected = 75;
        int actual = project.getConformity(team);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test4() {
        Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA));

        Set<Member> team = new HashSet<>(List.of(new Member("Name1", Level.A1, Skill.JAVA, Skill.JAVA)));

        int expected = 100;
        int actual = project.getConformity(team);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test5() {
        Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA));

        Set<Member> team = new HashSet<>();

        int expected = 0;
        int actual = project.getConformity(team);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test6() {
        Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA, Skill.DATABASE),
                new Role(Position.TESTER, Level.A3, Skill.TESTING_TOOLS, Skill.AWS), new Role(Position.TESTER, Level.A3, Skill.AWS));

        Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.DATABASE),
                new Member("Name4", Level.A3, Skill.TESTING_TOOLS)));

        int expected = 60;
        int actual = project.getConformity(team);
        Assertions.assertEquals(expected, actual);
    }
}
