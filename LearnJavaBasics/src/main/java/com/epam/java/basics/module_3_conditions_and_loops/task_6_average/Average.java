package com.epam.java.basics.module_3_conditions_and_loops.task_6_average;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int average;
        int sum = 0;
        int count = 0;

        while (true) {
            int userNumber = scanner.nextInt();

            if (userNumber == 0) {
                break;
            }
            sum += userNumber;
            count++;
        }
        average = sum / count;
        System.out.println(average);
    }
}