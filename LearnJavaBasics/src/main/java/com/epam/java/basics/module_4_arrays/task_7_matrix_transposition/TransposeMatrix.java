package com.epam.java.basics.module_4_arrays.task_7_matrix_transposition;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] testArray = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        for (int[] elem : testArray) {
            for (int anInt : elem) {
                System.out.printf("%4s", anInt);
            }
            System.out.println();
        }

        System.out.println();

        for (int[] elem : transpose(testArray)) {
            for (int anInt : elem) {
                System.out.printf("%4s", anInt);
            }
            System.out.println();
        }
    }

    public static int[][] transpose (int[][] matrix) {
        if (matrix == null) throw new UnsupportedOperationException();

        int[][] resultArray = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                resultArray[j][i] = matrix[i][j];

        return resultArray;
    }
}