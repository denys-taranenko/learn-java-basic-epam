package com.epam.java.basics.module_3_conditions_and_loops.task_1_meet_an_agent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextInt() == PASSWORD) {
            System.out.println("Hello, Agent");
        } else {
            System.out.println("Access denied");
        }
    }
}