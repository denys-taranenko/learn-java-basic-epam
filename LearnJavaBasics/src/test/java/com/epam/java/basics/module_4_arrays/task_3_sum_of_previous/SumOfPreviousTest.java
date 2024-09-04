package com.epam.java.basics.module_4_arrays.task_3_sum_of_previous;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SumOfPreviousTest {

    @Test
    public void sumOfPreviousTest(){

        int[] array;
        boolean[] expected;
        boolean[] actual;

        {
            array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};
            expected = new boolean[]{false, false, true, false, false, true, false, true};
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{1, -1, 10, 4, 14, 13, 15, 25};
            expected = new boolean[]{false, false, false, false, true, false, false, false};
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{1, -1, 10, 4, 6, 13, 15, 25};
            expected = new boolean[]{false, false, false, false, false, false, false, false};
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }

        {
            array = new int[20];
            Arrays.fill(array, 5);
            array[8] = 10;
            array[19] = 10;
            actual = SumOfPrevious.getSumCheckArray(array);

            assertEquals(20, actual.length);
            assertTrue(actual[8]);
            assertTrue(actual[19]);
            assertFalse(actual[0]);
            assertFalse(actual[1]);
            assertFalse(actual[15]);
        }

        {
            array = new int[50];
            Arrays.fill(array, 12);
            array[0] = 24;
            array[28] = 20;
            array[41] = 24;
            actual = SumOfPrevious.getSumCheckArray(array);

            assertEquals(50, actual.length);
            assertTrue(actual[41]);
            assertFalse(actual[28]);
            assertFalse(actual[0]);
        }

        {
            array = new int[]{16, 8};
            expected = new boolean[]{false, false};
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{-2, 9, 11};
            expected = new boolean[]{false, false, false};
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{16, 8, 24};
            expected = new boolean[]{false, false, true};
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }

        {
            array = new int[150];
            Arrays.fill(array, 35);
            expected = new boolean[150];
            Arrays.fill(expected, false);
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{-1, 3, 2, 5, 7, 12, 19, 31, 50, 81, 131, 212};
            expected = new boolean[12];
            Arrays.fill(expected, 0, 2, false);
            Arrays.fill(expected, 2, 12, true);
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }

        {
            array = new int[50];
            expected = new boolean[50];
            Arrays.fill(expected, 0, 2, false);
            Arrays.fill(expected, 2, 50, true);
            actual = SumOfPrevious.getSumCheckArray(array);

            assertArrayEquals(expected, actual);
        }
    }
}