package com.epam.java.basics.module4.task2;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    public static int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int sumResult = 0;

        for (int element : array) {
            if (element % 2 == 0) {
                sumResult += element;
            }
        }
        return sumResult;
    }
}