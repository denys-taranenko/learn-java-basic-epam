package com.epam.java.basics.module5.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int k2 = scanner.nextInt();
        int b2 = scanner.nextInt();

        Line line1 = new Line(k1,b1);
        Line line2 = new Line(k2,b2);

        System.out.println("result is " + line1.intersection(line2));
    }
}