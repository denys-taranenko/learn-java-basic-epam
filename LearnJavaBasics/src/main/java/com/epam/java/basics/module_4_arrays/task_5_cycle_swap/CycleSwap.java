package com.epam.java.basics.module_4_arrays.task_5_cycle_swap;

import java.util.Arrays;

public class CycleSwap {
    public static void main(String[] args) {
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array);
            System.out.println(Arrays.toString(array));
        }
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array, 2);
            System.out.println(Arrays.toString(array));
        }
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array, 5);
            System.out.println(Arrays.toString(array));
        }
    }

    public static void cycleSwap(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int lastIndex = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = lastIndex;
    }

    public static void cycleSwap(int[] array, int shift) {
        if (array == null || array.length == 0) {
            return;
        }

        int splitIndex = array.length - shift;
        int[] temp = new int[shift];

        System.arraycopy(array, splitIndex, temp, 0, shift);
        System.arraycopy(array, 0, array, shift, splitIndex);
        System.arraycopy(temp, 0, array, 0, shift);
    }
}