package com.epam.java.basics.module_15_optional.task_1_optional_max;

import java.util.OptionalInt;

public class MaxMethod {

    public static OptionalInt max(int[] values) {
        if (values == null || values.length == 0) {
            return OptionalInt.empty();
        }

        int result = Integer.MIN_VALUE;

        for (int value : values) {
                result = Integer.max(value, result);
            }

        return OptionalInt.of(result);
    }
}