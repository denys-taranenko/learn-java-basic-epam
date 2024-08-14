package com.epam.java.basics.module3.task5;

import java.util.Scanner;

public class FindMaxInSeq {
    public static void main(String[] args) {
        System.out.println(max());
    }

    public static int max() {
        Scanner scanner = new Scanner(System.in);
        int maxValue = scanner.nextInt();

        if (maxValue == 0) {
            return 0;
        }

        while (true) {
            int userNumber = scanner.nextInt();

            if (userNumber == 0) {
                break;
            } if (userNumber > maxValue) {
                maxValue = userNumber;
            }
        }
        return maxValue;
    }
}