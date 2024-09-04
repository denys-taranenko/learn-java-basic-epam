package com.epam.java.basics.module_1_first_programs_in_java.task_2_meet_a_stranger;

import java.util.Scanner;

public class MeetAStranger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userStr = scanner.nextLine();

        System.out.println("Hello, " + userStr);
    }
}