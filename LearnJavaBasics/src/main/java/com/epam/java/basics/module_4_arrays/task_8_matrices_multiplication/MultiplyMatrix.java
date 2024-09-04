package com.epam.java.basics.module_4_arrays.task_8_matrices_multiplication;

import java.util.Objects;

public class MultiplyMatrix {
    public static void main(String[] args) {
        int[][] firstMatrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] secondMatrix = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        for (int[] elem : firstMatrix) {
            for (int anInt : elem) {
                System.out.printf("%4s", anInt);
            }
            System.out.println();
        }
        System.out.println();
        for (int[] elem : secondMatrix) {
            for (int anInt : elem) {
                System.out.printf("%4s", anInt);
            }
            System.out.println();
        }
        System.out.println();
        for (int[] elem : Objects.requireNonNull(multiply(firstMatrix, secondMatrix))) {
            for (int anInt : elem) {
                System.out.printf("%4s", anInt);
            }
            System.out.println();
        }

    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null) throw new UnsupportedOperationException();

        int matrix1ColumnsLen = matrix1[0].length;
        int matrix2RowLen = matrix2.length;

        if (matrix1ColumnsLen != matrix2RowLen) return null;

        int matrix1RRowLen = matrix1.length;
        int matrix2RColLen = matrix2[0].length;

        int[][] multiplyMatrix = new int[matrix1RRowLen][matrix2RColLen];

        for (int i = 0; i < matrix1RRowLen; i++) {
            for (int j = 0; j < matrix2RColLen; j++) {
                for (int k = 0; k < matrix1ColumnsLen; k++) {
                    multiplyMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return multiplyMatrix;
    }
}