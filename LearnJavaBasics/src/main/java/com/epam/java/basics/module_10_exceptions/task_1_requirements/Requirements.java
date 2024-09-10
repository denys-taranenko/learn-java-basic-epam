package com.epam.java.basics.module_10_exceptions.task_1_requirements;

public class Requirements {

    public static void requireNonNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    public static void requireNonNull(Object obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
    }

    public static void checkArgument(boolean value) {
        if (!value) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean value, String message) {
        if (!value) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkState(boolean value) {
        if (!value) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean value, String message) {
        if (!value) {
            throw new IllegalStateException(message);
        }
    }

    public static void checkIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}