package com.epam.java.basics.module_17_lists_and_queues.task_1_simple_array_list;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SimpleArrayListImplTest {

    @Test
    void testAdd() {
        SimpleArrayList a = new SimpleArrayListImpl();
        a.add(1);
        a.add(1);
        a.add(1);
        List<Integer> expected = asList(1, 1, 1);
        assertSimpleListEquals(expected, a);
    }

    @Test
    void testAdd2() {
        SimpleArrayList a = new SimpleArrayListImpl();
        a.add(1);
        assertThrows(NullPointerException.class, () -> a.add(null), "The list cannot contain null elements. " +
                "The add and remove methods must " +
                "throw a `NullPointerException` if they get `null`.");
        a.add(1);
        List<Integer> expected = asList(1, 1);
        assertSimpleListEquals(expected, a, "The list must accept / return null values.");
    }

    private void assertSimpleListEquals(List<?> expected, SimpleArrayList actual) {
        assertSimpleListEquals(expected, actual, "");
    }
    private void assertSimpleListEquals(List<?> expected, SimpleArrayList actual, String message) {
        assertEquals(expected.size(), actual.size(),
                "The sizes ere not equal. Expected size: " + expected.size() +
                        ", actual size: " + actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i),
                    message +
                            " Expected: " + expected + ", actual: " + actual);
        }
    }

    @Test
    void testGet() {
        SimpleArrayList a = new SimpleArrayListImpl();
        a.add(1);
        assertThrows(NullPointerException.class, () -> a.add(null),
                "The list cannot contain null elements. " +
                        "The add and remove methods must " +
                        "throw a `NullPointerException` if they get `null`.");
        a.add(3);
        assertEquals(1, a.get(0));
        assertEquals(3, a.get(1));
    }

    @Test
    void testGet2() {
        SimpleArrayList a = new SimpleArrayListImpl();
        assertThrows(IndexOutOfBoundsException.class, () -> a.get(0));
        SimpleArrayList a1 = new SimpleArrayListImpl();
        a1.add(0);
        a1.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> a1.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> a1.get(2));
        assertDoesNotThrow(() -> a1.get(1));
    }

    @Test
    void testRemove() {
        SimpleArrayList a = new SimpleArrayListImpl();
        a.add(1);
        a.add(2);
        a.add("null");
        a.add(3);
        assertEquals(Optional.of(2), a.remove(2));
        assertSimpleListEquals(asList(1, "null", 3), a);
        assertEquals(Optional.of("null"), a.remove("null"));
        assertSimpleListEquals(asList(1, 3), a);
        assertEquals(Optional.of(3), a.remove(3));
        assertSimpleListEquals(List.of(1), a);
        assertEquals(Optional.of(1), a.remove(1));
        assertSimpleListEquals(List.of(), a);
    }

    @Test
    void testRemove2() {
        SimpleArrayList a = new SimpleArrayListImpl();
        assertThrows(NullPointerException.class, () -> a.remove(null));
    }

    @Test
    void testRemove3() {
        SimpleArrayList a = new SimpleArrayListImpl();
        String s = "";
        a.add("1" + s);
        a.add("2" + s);
        a.add("null");
        a.add("3" + s);
        assertEquals(Optional.of("null"), a.remove("null"));
        assertEquals(Optional.of("2"), a.remove("2"));
        assertSimpleListEquals(asList("1", "3"), a);
        assertEquals(Optional.of("3"), a.remove("3"));
        assertSimpleListEquals(List.of("1"), a);
        assertEquals(Optional.empty(), a.remove("null"));
        assertSimpleListEquals(List.of("1"), a);
        assertEquals(Optional.of("1"), a.remove("1"));
        assertSimpleListEquals(List.of(), a);
    }

    @Test
    void testSize() {
        SimpleArrayList a = new SimpleArrayListImpl();
        a.add(1);
        a.add(2);
        a.add(3);
        assertEquals(3, a.size());
        a.remove(1);
        assertEquals(2, a.size());
        a.remove(0);
        assertEquals(2, a.size());
        a.remove(2);
        assertEquals(1, a.size());
        a.remove(3);
        assertEquals(0, a.size());
        a.remove(0);
        assertEquals(0, a.size());
    }

    @Test
    void testToString() {
        SimpleArrayList a = new SimpleArrayListImpl();
        a.add(1);
        a.add(2);
        a.add(3);
        String actual = a.toString();
        String expected = "[1, 2, 3]";
        assertEquals(expected, actual,
                "Expected: '" + expected + "', but was: '" + actual + "'");
        a = new SimpleArrayListImpl();
        actual = a.toString();
        expected = "[]";
        assertEquals(expected, actual,
                "Expected: '" + expected + "', but was: '" + actual + "'");
    }

    @ParameterizedTest
    @MethodSource("casesIncreaseCapacity")
    void testIncreaseCapacity(int capacity, int add) {
        SimpleArrayList a = new SimpleArrayListImpl();
        for (int s = 0; s < add; s++) {
            a.add(s);
        }
        assertEquals(capacity, a.capacity(),
                "It should increase capacity only " +
                        "if number of elements riches 75.0% of capacity");
        a.add(add);
        int expected = (int) (capacity * 2 * 0.75);
        assertEquals(expected, a.capacity(),
                "It should increase capacity then " +
                        "number of elements riches 75.0% of capacity");
    }


    @ParameterizedTest
    @MethodSource("casesDecreaseCapacity")
    void testDecreaseCapacity(int add, int remove) {
        SimpleArrayList a = new SimpleArrayListImpl();
        for (int i = 0; i < add; i++) {
            a.add(i);
        }
        for (int i = 0; i < remove; i++) {
            a.remove(i);
        }
        a.remove(remove);
        assertTrue(a.decreaseCapacity());
        assertFalse(a.decreaseCapacity());
    }

    static Stream<Arguments> casesIncreaseCapacity() {
        return Stream.of(
                Arguments.of(10, 7),
                Arguments.of(22, 16),
                Arguments.of(49, 36),
                Arguments.of(109, 81)
        );
    }

    static Stream<Arguments> casesDecreaseCapacity() {
        return Stream.of(
                Arguments.of(7, 2),
                Arguments.of(14, 5),
                Arguments.of(28, 11)
        );
    }

}