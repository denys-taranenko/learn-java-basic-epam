package com.epam.java.basics.module_3_conditions_and_loops.task_7_pizza_split;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int numberOfPieces = scanner.nextInt();

        int numberOfPizza = 1;
        int totalPieces = numberOfPizza * numberOfPieces;

        while (totalPieces % numberOfPeople != 0) {
            numberOfPizza++;
            totalPieces = numberOfPizza * numberOfPieces;
        }

        System.out.println(numberOfPizza);
    }
}