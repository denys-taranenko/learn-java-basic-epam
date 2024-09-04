package com.epam.java.basics.module_2_data_types.task_1_electronic_watch;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        final int SECONDS_IN_A_DAY = 0x15180;
        final int SECONDS_IN_A_HOUR = 0xE10;
        final int SECONDS_IN_A_MINUTES = 0x3C;

        Scanner scanner = new Scanner(System.in);
        int userSeconds = scanner.nextInt();

        userSeconds %= SECONDS_IN_A_DAY;

        int hoursResult = userSeconds / SECONDS_IN_A_HOUR;
        int minutesResult = (userSeconds / SECONDS_IN_A_MINUTES) % SECONDS_IN_A_MINUTES;
        int secondsResult = userSeconds % SECONDS_IN_A_MINUTES;

        System.out.printf("%d:%02d:%02d", hoursResult, minutesResult, secondsResult);
    }
}