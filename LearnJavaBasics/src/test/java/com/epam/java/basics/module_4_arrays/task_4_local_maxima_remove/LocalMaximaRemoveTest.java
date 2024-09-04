package com.epam.java.basics.module_4_arrays.task_4_local_maxima_remove;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalMaximaRemoveTest {

    @Test
    public void removeLocalMaximaTest() {

        int[] array;
        int[] expected;
        int[] actual;

        {
            array = new int[]{-3, 2, 4, 3, 5, 12, 8};
            expected = new int[]{-3, 2, 3, 5, 8};
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertArrayEquals(new int[]{-3, 2, 4, 3, 5, 12, 8}, array);
            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{-3, 2, 4, 13, 5, 12, 8};
            expected = new int[]{-3, 2, 4, 5, 8};
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertArrayEquals(new int[]{-3, 2, 4, 13, 5, 12, 8}, array);
            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{18, 1, 3, 6, 7, -5};
            expected = new int[]{1, 3, 6, -5};
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertArrayEquals(new int[]{18, 1, 3, 6, 7, -5}, array);
            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{-18, 21, 3, 6, 7, 65};
            expected = new int[]{-18, 3, 6, 7};
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertArrayEquals(new int[]{-18, 21, 3, 6, 7, 65}, array);
            assertArrayEquals(expected, actual);
        }

        {
            array = new int[1000];
            Arrays.fill(array, 15);
            array[0] = 20;
            array[999] = 25;
            array[168] = 30;
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertEquals(997, actual.length);
            assertEquals(15, actual[0]);
            assertEquals(15, actual[996]);
        }

        {
            array = new int[1000];
            Arrays.fill(array, 15);
            array[0] = -20;
            array[999] = 25;
            array[168] = 18;
            array[421] = 0;
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertEquals(998, actual.length);
            assertEquals(-20, actual[0]);
            assertEquals(15, actual[997]);
            assertEquals(0, actual[420]);
        }

        {
            array = new int[]{100, 0};
            expected = new int[]{0};
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertArrayEquals(new int[]{100, 0}, array);
            assertArrayEquals(expected, actual);
        }

        {
            array = new int[]{10, 900};
            expected = new int[]{10};
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertArrayEquals(new int[]{10, 900}, array);
            assertArrayEquals(expected, actual);
        }

        {
            array = new int[1000];
            Arrays.fill(array, 10);
            for (int i = 0; i < array.length; i+=2){
                array[i] = 20;
            }
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertEquals(500, actual.length);
            assertEquals(10, actual[0]);
        }

        {
            array = new int[15000];
            Arrays.fill(array, 10);
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertArrayEquals(array, actual);
        }

        {
            array = new int[500];
            Arrays.fill(array, 0, 100, 150);
            Arrays.fill(array, 100, 200, 50);
            Arrays.fill(array, 200, 300, 15);
            Arrays.fill(array, 300, 400, 55);
            Arrays.fill(array, 400, 500, 500);
            actual = LocalMaximaRemove.removeLocalMaxima(array);

            assertArrayEquals(array, actual);
        }

    }
}