package com.epam.java.basics.module_3_conditions_and_loops.task_8_quadratic_equation;

import java.util.Locale;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double discriminator = (b * b) - 4 * (a * c);
        double firstRoot;
        double secondRoot;

        if (discriminator > 0) {
            firstRoot = (-b + Math.sqrt(discriminator)) / (2.0D * a);
            secondRoot = (-b - Math.sqrt(discriminator)) / (2.0D * a);
            System.out.println(firstRoot + " " + secondRoot);
        } else if (discriminator == 0) {
            firstRoot = -b / (2.0D * a);
            System.out.println(firstRoot);
        } else {
            System.out.println("no roots");
        }
    }
}