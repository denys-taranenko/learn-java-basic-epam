package com.epam.java.basics.module_4_arrays.task_1_max_method;

public class MaxMethod {
    public static void main(String[] args) {
        int[] vals = new int[]{ -2, 0, 10, 5 };
        int result = MaxMethod.max(vals);
        System.out.println(result == 10);
    }

    public static int max(int[] values) {
        if (values.length == 0) {
            throw new UnsupportedOperationException("Array must not be empty");
        }

        int maxValue = values[0];
        for (int element : values) {
            if (element > maxValue) {
                maxValue = element;
            }
        }
        return maxValue;
    }
}