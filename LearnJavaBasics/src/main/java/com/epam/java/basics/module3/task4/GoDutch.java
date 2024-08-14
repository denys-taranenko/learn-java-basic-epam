package com.epam.java.basics.module3.task4;

import java.util.Scanner;

public class GoDutch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalBill = scanner.nextInt();
        if (totalBill  < 0) {
            System.out.println("Bill total amount cannot be negative");
            return;
        }

        int numberOfFriends = scanner.nextInt();
        if (numberOfFriends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }

        int serviceCharge = (totalBill  * 10) / 100;
        int amountPerFriend = (totalBill  + serviceCharge) / numberOfFriends;

        System.out.println(amountPerFriend);
    }
}