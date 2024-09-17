package com.epam.java.basics.module_17_lists_and_queues.task_2_doubly_linked_list;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtTypeInformation;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D. Kolesnikov
 */
public class DoublyLinkedListImplTest {

    //////////////////////////////////////////////////////////////////////////////

    private static boolean isAllTestsMustFailed;

    private static Throwable complianceTestFailedCause;

    static {
        try {
            String testClassName = new Exception().getStackTrace()[0].getClassName();
            String className = testClassName.substring(0, testClassName.lastIndexOf("Test"));
            Class<?> c = Class.forName(className);

            java.lang.reflect.Method[] methods = {
                    c.getDeclaredMethod("addFirst", Object.class),
                    c.getDeclaredMethod("addLast", Object.class),
                    c.getDeclaredMethod("delete", int.class),
                    c.getDeclaredMethod("remove", Object.class),
                    c.getDeclaredMethod("set", int.class, Object.class),
                    c.getDeclaredMethod("size"),
                    c.getDeclaredMethod("toArray"),
                    c.getDeclaredMethod("toString")
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

    private DoublyLinkedListImpl list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedListImpl();
    }

    @Test
    void toStringShouldReturnElementsSeparatedBySpace() {
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        String expected = "D C B A";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    void sizeShouldReturn0WhenNoElementsWereAdded() {
        int expected = 0;
        int actual = list.size();
        assertEquals(expected, actual);
    }

    @Test
    void sizeShouldReturn3WhenThreeElementsWereAdded() {
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        int expected = 3;
        int actual = list.size();
        assertEquals(expected, actual);
    }

    @Test
    void toArrayShouldReturnEmptyArrayWhenListIsEmpty() {
        Object[] expected = {};
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addLastShouldAddThreeElementsABC() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        String expected = "A B C";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test
    void toArrayShouldReturnArrayWith3ElementsWhenListContains3Elements() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        Object[] expected = {"A", "B", "C"};
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void setShouldSetSecondElement() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.set(1, "7");
        Object[] expected = {"A", "7", "C"};
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void setShouldThrowExceptionIfIndexOutOfBounds() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, "7"));
    }

    @Test
    void getShouldReturnFirstElement() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        Object expected = "A";
        Object actual = list.remove("A").get();
        assertEquals(expected, actual);
    }

    @Test
    void getShouldReturnLastElement() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        Object expected = "C";
        Object actual = list.remove("C").get();
        assertEquals(expected, actual);
    }

    @Test
    void getShouldReturnNullIfNoSuchElement() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        assertTrue(list.remove("7").isEmpty());
    }

    @Test
    void deleteShouldDeleteOneElementWhenListContainOneElement() {
        list.addLast("A");
        list.delete(0);
        Object[] expected = {};
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteShouldDeleteOneElementsWhenListContainsThreeElements() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.delete(0);
        Object[] expected = {"B", "C"};
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteShouldDeleteSecondElementWhenListContainsThreeElements() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.delete(1);
        Object[] expected = {"A", "C"};
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteShouldDeleteLastElement() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.delete(2);
        Object[] expected = {"A", "B"};
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteShouldDeleteAllElements() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        Object[] expected;
        Object[] actual;

        list.delete(0);
        expected = new Object[] {"B", "C"};
        actual = list.toArray();
        assertArrayEquals(expected, actual);

        list.delete(0);
        expected = new Object[] {"C"};
        actual = list.toArray();
        assertArrayEquals(expected, actual);

        list.delete(0);
        expected = new Object[] {};
        actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addFirstShouldReturnFalseWhenAddNull() {
        assertFalse(list.addLast(null));
    }

    @Test
    void addFirstShouldReturnTrueWhenAddNonNull() {
        assertTrue(list.addLast("A"));
    }

    @Test
    void addLastShouldReturnFalseWhenAddNull() {
        assertFalse(list.addLast(null));
    }

    @Test
    void addLastShouldReturnTrueWhenAddNonNull() {
        assertTrue(list.addLast("A"));
    }

    @Test
    void setShouldReturnFalseWhenAddNull() {
        list.addFirst("A");
        assertFalse(list.set(0, null));
    }

    @Test
    void setShouldReturnTrueWhenAddNonNull() {
        list.addFirst("A");
        assertTrue(list.set(0, "B"));
    }

    @Test
    void appShouldUseOnlyOptionalFromJavaUtilPackage() {
        SpoonAPI spoon = new Launcher();
        spoon.addInputResource("src/main/java/com/epam/java/basics/module_17_lists_and_queues/task_2_doubly_linked_list");
        spoon.buildModel();

        java.util.List<String> types = spoon.getModel()
                .getElements(new TypeFilter<>(CtTypeReference.class))
                .stream()
                .filter(r -> r.toString().startsWith("java.util."))
                .map(CtTypeReference::getQualifiedName).distinct()
                .toList();

        assertIterableEquals(
                List.of("java.util.Optional"),
                types,
                () -> "You must use exactly one type from java.util package and subpackages: "
                        + "java.util.Optional, but found:" + types);
    }

    @Test
    void appShouldUseOnlyOneTopLevelClass() {
        String packName = getClass().getPackage().getName();

        SpoonAPI spoon = new Launcher();
        spoon.addInputResource("src/main/java/com/epam/java/basics/module_17_lists_and_queues/task_2_doubly_linked_list");
        spoon.buildModel();

        List<String> types = spoon.getModel()
                .getElements(new TypeFilter<>(CtTypeReference.class))
                .stream()
                .filter(CtTypeInformation::isClass)
                .filter(r -> r.toString().startsWith(packName))
                .map(CtTypeReference::getQualifiedName).distinct()
                .toList();

        assertEquals(2, types.size(),
                () -> "You must use exactly two classes (DoubleLinkedList and Node) but found:" + types);
    }

    @Test
    void listShouldDeclaredOnlyTwoFields() {
        Field[] fields = DoublyLinkedListImpl.class.getDeclaredFields();
        assertEquals(2, fields.length, "You must declare only two fields");
        for (Field f : fields) {
            assertNotSame(f.getType().getSuperclass(), Number.class, "Field cannot be of type of number");
        }
    }

}
