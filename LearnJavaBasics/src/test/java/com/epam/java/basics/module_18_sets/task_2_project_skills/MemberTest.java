package com.epam.java.basics.module_18_sets.task_2_project_skills;

import java.util.EnumSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author D. Kolesnikov
 */
class MemberTest {

    //////////////////////////////////////////////////////////////////////////////

    private static boolean isAllTestsMustFailed;

    private static Throwable complianceTestFailedCause;

    static {
        try {
            String testClassName = new Exception().getStackTrace()[0].getClassName();
            String className = testClassName.substring(0, testClassName.lastIndexOf("Test"));
            Class<?> c = Class.forName(className);

            java.lang.reflect.Method[] methods = {
                    c.getDeclaredMethod("getName"),
                    c.getDeclaredMethod("getLevel"),
                    c.getDeclaredMethod("getSkills")
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
        Member m = new Member("Name1", Level.A1, Skill.JAVA);
        Class<?> expected = EnumSet.class;
        Class<?> actual = m.getSkills().getClass().getSuperclass();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        Member m = new Member("Name2", Level.A1, Skill.JAVA, Skill.DATABASE, Skill.SPRING);
        Class<?> expected = EnumSet.class;
        Class<?> actual = m.getSkills().getClass().getSuperclass();
        Assertions.assertEquals(expected, actual);
    }
}
