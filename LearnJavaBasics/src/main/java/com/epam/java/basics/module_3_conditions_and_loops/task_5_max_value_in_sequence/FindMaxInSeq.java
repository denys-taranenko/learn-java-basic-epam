package com.epam.java.basics.module_3_conditions_and_loops.task_5_max_value_in_sequence;

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