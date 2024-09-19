package com.epam.java.basics.module_18_sets.task_1_ranged_ops_integer_set;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RangedOpsIntegerSetTest {

    @Test
    void testInitialState() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();

        assertEquals(0, set.size());
        assertEquals(0, set.size());

        Iterator<Integer> iterator = set.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testAddOrdered() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();

        set.addAll(List.of(0, 1, 2));

        assertEquals(3, set.size());
        assertEquals(List.of(0, 1, 2), pullToList(set));
    }

    @Test
    void testAddUnordered() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();

        set.addAll(List.of(12, 5, 0, 1, 2, 3, 4, 8));

        assertEquals(8, set.size());
        assertEquals(List.of(0, 1, 2, 3, 4, 5, 8, 12), pullToList(set));
    }

    @Test
    void testAddDuplicates() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();

        set.addAll(List.of(12, 5, 0, 12, 2, 8, 1, 2, 3, 4, 8));

        assertEquals(8, set.size());
        assertEquals(List.of(0, 1, 2, 3, 4, 5, 8, 12), pullToList(set));
    }

    @Test
    void testRange() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();

        assertTrue(set.add(-5, 5));
        assertEquals(10, set.size());
        assertEquals(List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4), pullToList(set));

        assertTrue(set.add(9, 10));
        assertEquals(11, set.size());
        assertEquals(List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 9), pullToList(set));

        assertTrue(set.add(-100, -97));
        assertEquals(14, set.size());
        assertEquals(List.of(-100, -99, -98, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 9), pullToList(set));

        assertFalse(set.add(0, 3));
        assertEquals(14, set.size());
        assertEquals(List.of(-100, -99, -98, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 9), pullToList(set));

        assertFalse(set.add(2, 5));
        assertEquals(14, set.size());
        assertEquals(List.of(-100, -99, -98, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 9), pullToList(set));

        assertTrue(set.add(2, 7));
        assertEquals(16, set.size());
        assertEquals(List.of(-100, -99, -98, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 9), pullToList(set));

        assertFalse(set.remove(20, 25));
        assertEquals(16, set.size());
        assertEquals(List.of(-100, -99, -98, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 9), pullToList(set));

        assertTrue(set.remove(0, 3));
        assertEquals(13, set.size());
        assertEquals(List.of(-100, -99, -98, -5, -4, -3, -2, -1, 3, 4, 5, 6, 9), pullToList(set));

        assertFalse(set.remove(0, 3));
        assertEquals(13, set.size());
        assertEquals(List.of(-100, -99, -98, -5, -4, -3, -2, -1, 3, 4, 5, 6, 9), pullToList(set));

        assertTrue(set.remove(5, 10));
        assertEquals(10, set.size());
        assertEquals(List.of(-100, -99, -98, -5, -4, -3, -2, -1, 3, 4), pullToList(set));

        assertTrue(set.remove(-99, 99));
        assertEquals(1, set.size());
        assertEquals(List.of(-100), pullToList(set));

        assertTrue(set.remove(-100, 100));
        assertEquals(0, set.size());
        assertEquals(List.of(), pullToList(set));
    }

    private List<Integer> pullToList(final RangedOpsIntegerSet set) {
        return new ArrayList<>(set);
    }
}
