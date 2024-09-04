package com.epam.java.basics.module_4_arrays.task_4_local_maxima_remove;

import java.util.Arrays;

public class LocalMaximaRemove {
    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        if (array == null || array.length == 0) throw new UnsupportedOperationException();

        int[] tempArray = new int[array.length];
        int index = 0;

        if (array.length == 1 || array[0] <= array[1]) {
            tempArray[index++] = array[0];
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (!(array[i] > array[i - 1] && array[i] > array[i + 1])) {
                tempArray[index++] = array[i];
            }
        }

        if (array.length > 1 && array[array.length - 1] <= array[array.length - 2]) {
            tempArray[index++] = array[array.length - 1];
        }

        int[] resultArray = new int[index];
        System.arraycopy(tempArray, 0, resultArray, 0, index);

        return resultArray;
    }
}