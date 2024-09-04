package com.epam.java.basics.module_3_conditions_and_loops.task_3_snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();

        if (b >= a && h >a) {
            System.out.println("Impossible");
        } else {
            int days = 0;
            int currentHeight = 0;

            while (currentHeight < h) {
                days++;
                currentHeight += a;

                if (currentHeight >= h) {
                    break;
                }

                currentHeight -= b;
            }
            System.out.println(days);
        }
    }
}