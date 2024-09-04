package com.epam.java.basics.module_4_arrays.task_6_spiral;

public class Spiral {
    public static void main(String[] args) {
        int[][] spiral = Spiral.spiral(3, 4);

        for (int[] elem : spiral) {
            for (int anInt : elem) {
                System.out.printf("%4s", anInt);
            }
            System.out.println();
        }
    }

    public static int[][] spiral(int rows, int columns) {
        if (rows <= 0 || columns <= 0) throw new UnsupportedOperationException();

        int[][] spiralArray = new int[rows][columns];
        int maxValue = rows * columns;
        int number = 1;
        int minRow = 0, maxRow = rows - 1;
        int minColumn = 0, maxColumn = columns - 1;

        while (number <= maxValue) {
            for (int i = minColumn; i <= maxColumn && number <= maxValue; i++) {
                spiralArray[minRow][i] = number++;
            }
            minRow++;

            for (int i = minRow; i <= maxRow && number <= maxValue; i++) {
                spiralArray[i][maxColumn] = number++;
            }
            maxColumn--;

            for (int i = maxColumn; i >= minColumn && number <= maxValue; i--) {
                spiralArray[maxRow][i] = number++;
            }
            maxRow--;

            for (int i = maxRow; i >= minRow && number <= maxValue; i--) {
                spiralArray[i][minColumn] = number++;
            }
            minColumn++;
        }
        return spiralArray;
    }
}