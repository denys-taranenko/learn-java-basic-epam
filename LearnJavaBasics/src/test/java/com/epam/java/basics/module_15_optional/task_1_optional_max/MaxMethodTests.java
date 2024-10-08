package com.epam.java.basics.module_15_optional.task_1_optional_max;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class MaxMethodTests {

    @Test
    @DisplayName("For an empty array returns empty result")
    void testEmptyArray() {
        OptionalInt result = MaxMethod.max(new int[]{});
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("For null returns empty result")
    void testNullArray() {
        OptionalInt result = MaxMethod.max(null);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("For an array of length 1 returns its only value")
    void testReturnArraysSingleValue() {
        int[] values = new int[]{10};
        OptionalInt result = MaxMethod.max(values);
        assertEquals(values[0], result.getAsInt());
    }

    @Test
    @DisplayName("For an array of negative ints returns correct max")
    void testReturnMaxForNegativeValues() {
        int[] values = new int[]{-4, -3, -3, -10, -2, -145};
        OptionalInt result = MaxMethod.max(values);
        assertEquals(-2, result.getAsInt());
    }

    @Test
    @DisplayName("For an array containing MAX_VALUE return the value")
    void testReturnIntegerMaxIfArrayContainsIt() {
        int[] values = new int[]{-10, 3, 255528, 0, Integer.MAX_VALUE, 100, 0};
        OptionalInt result = MaxMethod.max(values);
        assertEquals(Integer.MAX_VALUE, result.getAsInt());
    }

    @Test
    @DisplayName("For an array containing value near to MAX_VALUE return the value")
    void testReturnsValueNearToIntegerMaxIfArrayContainsIt() {
        int diff = 27;
        int toFind = Integer.MAX_VALUE - diff;
        int[] values = new int[]{8332, 0, -123, 44, 23, 924823, toFind};
        OptionalInt result = MaxMethod.max(values);
        assertEquals(toFind, result.getAsInt());
    }

    @Test
    void testReturnMaxValueForSampleArray() {
        int[] values = new int[]{-574, -484, 444, -217, 978, -370, 269, -9, 189};
        OptionalInt result = MaxMethod.max(values);
        assertEquals(978, result.getAsInt());
    }

    @Test
    void testReturnMaxValueForSampleArray2() {
        int[] values = new int[]{-794, -206, -500, -410, -850, -249, -968, -536, -61, -65, -866};
        OptionalInt result = MaxMethod.max(values);
        assertEquals(-61, result.getAsInt());
    }

    @Test
    void testReturnMaxValueForSampleArray3() {
        int[] values = new int[]{806, 19, 140, 392, 36, 528, 351, 29, 786, 646, 656, 542, 890, 424};
        OptionalInt result = MaxMethod.max(values);
        assertEquals(890, result.getAsInt());
    }
}