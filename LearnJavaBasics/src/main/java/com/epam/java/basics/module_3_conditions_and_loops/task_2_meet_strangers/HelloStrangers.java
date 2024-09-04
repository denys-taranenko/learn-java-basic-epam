package com.epam.java.basics.module_3_conditions_and_loops.task_2_meet_strangers;

import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numberOfStrangers = scanner.nextInt();
        scanner.nextLine();

        if (numberOfStrangers == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (numberOfStrangers < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
                while (numberOfStrangers > 0) {
                    String strangerName = scanner.nextLine();
                    System.out.println("Hello, " + strangerName);
                    numberOfStrangers--;
                }
            }
    }
}