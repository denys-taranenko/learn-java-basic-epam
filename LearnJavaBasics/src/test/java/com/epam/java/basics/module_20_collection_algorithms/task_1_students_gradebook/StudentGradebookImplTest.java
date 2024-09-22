package com.epam.java.basics.module_20_collection_algorithms.task_1_students_gradebook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * @author D. Kolesnikov
 */
class StudentGradebookImplTest {

    //////////////////////////////////////////////////////////////////////////////

    private static boolean isAllTestsMustFailed;

    private static Throwable complianceTestFailedCause;

    static {
        try {
            String testClassName = new Exception().getStackTrace()[0].getClassName();
            String className = testClassName.substring(0, testClassName.lastIndexOf("Test"));
            Class<?> c = Class.forName(className);

            java.lang.reflect.Method[] methods = {
                    c.getDeclaredMethod("addEntryOfStudent", Student.class, String.class, BigDecimal.class),
                    c.getDeclaredMethod("size"),
                    c.getDeclaredMethod("getStudentsByDiscipline", String.class),
                    c.getDeclaredMethod("getComparator"),
                    c.getDeclaredMethod("removeStudentsByGrade", BigDecimal.class),
                    c.getDeclaredMethod("getAndSortAllStudents")
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

    private StudentGradebook gbook;

    private static final Student S1 = new Student("LName1", "FName1", "Group1");
    private static final Student S2 = new Student("LName2", "FName2", "Group1");
    private static final Student S3 = new Student("LName3", "FName3", "Group1");
    private static final Student S4 = new Student("LName4", "FName4", "Group2");
    private static final Student S5 = new Student("LName5", "FName5", "Group2");
    private static final Student S6 = new Student("LName6", "FName6", "Group2");

    @BeforeEach
    void setUp() {
        gbook = new StudentGradebookImpl();
        gbook.addEntryOfStudent(S1, "dis1", BigDecimal.valueOf(3.3));
        gbook.addEntryOfStudent(S1, "dis2", BigDecimal.valueOf(3.4));
        gbook.addEntryOfStudent(S1, "dis3", BigDecimal.valueOf(3.5));

        gbook.addEntryOfStudent(S2, "dis1", BigDecimal.valueOf(3.3));
        gbook.addEntryOfStudent(S2, "dis2", BigDecimal.valueOf(3.4));
        gbook.addEntryOfStudent(S2, "dis3", BigDecimal.valueOf(3.5));

        gbook.addEntryOfStudent(S3, "dis1", BigDecimal.valueOf(3.9));
        gbook.addEntryOfStudent(S3, "dis2", BigDecimal.valueOf(4.0));
        gbook.addEntryOfStudent(S3, "dis3", BigDecimal.valueOf(4.1));

        gbook.addEntryOfStudent(S4, "dis1", BigDecimal.valueOf(4.6));
        gbook.addEntryOfStudent(S4, "dis2", BigDecimal.valueOf(4.2));
        gbook.addEntryOfStudent(S4, "dis3", BigDecimal.valueOf(5.0));

        gbook.addEntryOfStudent(S5, "dis1", BigDecimal.valueOf(4.5));
        gbook.addEntryOfStudent(S5, "dis2", BigDecimal.valueOf(4.6));
        gbook.addEntryOfStudent(S5, "dis3", BigDecimal.valueOf(4.7));

        gbook.addEntryOfStudent(S6, "dis1", BigDecimal.valueOf(4.4));
        gbook.addEntryOfStudent(S6, "dis2", BigDecimal.valueOf(4.6));
        gbook.addEntryOfStudent(S6, "dis3", BigDecimal.valueOf(4.8));
    }

    @Test
    void addEntryOfStudentShouldReturnCorrectValues() {
        assertTrue(gbook.addEntryOfStudent(S1, "dis4", BigDecimal.valueOf(3.3)));
        assertFalse(gbook.addEntryOfStudent(S1, "dis4", BigDecimal.valueOf(3.3)));
        assertFalse(gbook.addEntryOfStudent(S1, "dis4", BigDecimal.valueOf(3.3)));
        assertTrue(gbook.addEntryOfStudent(S1, "dis5", BigDecimal.valueOf(3.3)));
    }

    @Test
    void sizeShouldBeEqualed6() {
        int expected = 6;
        int actual = gbook.size();
        assertEquals(expected, actual);
    }

    @Test
    void getAndSortAllStudentsShouldReturnMapWithCorrectContent() {
        Map<BigDecimal, List<Student>> map = gbook.getAndSortAllStudents();

        List<Student> expected;
        List<Student> actual;

        expected = Arrays.asList(S1, S2);
        actual = map.get(BigDecimal.valueOf(3.4));
        assertIterableEquals(expected, actual);

        expected = List.of(S3);
        actual = map.get(BigDecimal.valueOf(4.0));
        assertIterableEquals(expected, actual);

        expected = Arrays.asList(S4, S5, S6);
        actual = map.get(BigDecimal.valueOf(4.6));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getComparatorShouldReturnCorrectComparator() {
        Comparator<Student> comp = gbook.getComparator();

        assertThrows(RuntimeException.class, () -> comp.compare(S1, null));
        assertEquals(Math.signum(comp.compare(S1, S2)), -Math.signum(comp.compare(S2, S1)));

        Student s1 = new Student("name1", "name1", "group1");
        Student s2 = new Student("name1", "name1", "group1");
        Student s3 = new Student("name2", "name2", "group2");

        assertEquals(0, comp.compare(s1, s2));
        float signum = Math.signum(comp.compare(s1, s3));
        assertEquals(signum, signum);
    }

    @Test
    void getStudentsByDisciplineShouldReturnProperValue() {
        List<String> expected = Arrays.asList(
                "FName1_LName1: 3.3",
                "FName2_LName2: 3.3",
                "FName3_LName3: 3.9",
                "FName4_LName4: 4.6",
                "FName5_LName5: 4.5",
                "FName6_LName6: 4.4");
        List<String> actual = gbook.getStudentsByDiscipline("dis1");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void removeStudentsByGradeShouldProperlyRemoveEntries() {
        gbook.removeStudentsByGrade(BigDecimal.valueOf(4.0));

        List<Student> studs = new ArrayList<>();
        gbook.getAndSortAllStudents().forEach((k, v) -> studs.addAll(v));

        assertEquals(3, studs.size());

        assertTrue(studs.contains(S4));
        assertTrue(studs.contains(S5));
        assertTrue(studs.contains(S6));
    }

    @Test
    void appShoulNotUseLambdaExpressions() {
        Stream.of(StudentGradebookImpl.class)
                .map(Class::getDeclaredMethods)
                .flatMap(Stream::of)
                .filter(m -> Modifier.isStatic(m.getModifiers()))
                .filter(m -> Modifier.isPrivate(m.getModifiers()))
                .map(Method::getName)
                .filter(name -> name.contains("lambda$"))
                .findAny()
                .ifPresent(m ->
                        fail(() -> "Using of lambda expressions is restricted: " + m));
    }

    @Test
    void appShouldNotUseJavaUtilStream() {
        SpoonAPI spoon = new Launcher();
        spoon.addInputResource("src/main/java/com/epam/java/basics/module_20_collection_algorithms/task_1_students_gradebook");
        spoon.buildModel();

        spoon.getModel()
                .getElements(new TypeFilter<>(CtTypeReference.class))
                .stream()
                .filter(r -> r.toString().startsWith("java.util.stream"))
                .map(CtTypeReference::getQualifiedName)
                .findAny()
                .ifPresent(name ->
                        fail(() -> "Using of stream API is restricted: " + name));
    }
}
