package com.epam.java.basics.module_4_arrays.task_3_sum_of_previous;

import java.util.Arrays;

public class SumOfPrevious {
    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};
        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array) {
        if (array == null || array.length == 0) throw new UnsupportedOperationException();

        boolean[] result = new boolean[array.length];

        for (int i = 2; i < array.length; i++) {
            if (array[i] == array[i - 2] + array[i - 1]) {
                result[i] = true;
            }
        }
        return result;
    }
}