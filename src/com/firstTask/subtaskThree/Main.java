package com.firstTask.subtaskThree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;


public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Integer numAmount = input("Enter the amount of numbers, sum of which you would like to count: ", Integer::valueOf);

        for (int i = 0; i < numAmount; i++) {
            Integer number = input("Enter the number: ", Integer::valueOf);
            numbers.add(number);
        }

        if (numbers.isEmpty()) {
            System.err.println("Error: Incorrect input format");
            System.exit(1);
        }
        else {
            System.out.println("The total sum is: " + countSum(numbers));
        }
    }

    private static int countSum(ArrayList<Integer> numbers) {
        int primarySum = 0, secondarySum = 0, iterator = 0;

        for (Integer number : numbers) {
            primarySum += number;
        }

        while (iterator < numbers.size()) {
            secondarySum += numbers.get(iterator);
            iterator++;
        }

        equals(primarySum, secondarySum);
        iterator = secondarySum = 0;

        do {
            secondarySum += numbers.get(iterator);
            iterator++;
        } while (iterator < numbers.size());

        equals(primarySum, secondarySum);

        return primarySum;
    }

    private static <T> T input(String message, Function<Integer, T> converter) {
        while (true) { // Чтобы не ругался на возможное отсутствие return'a
            try {
                System.out.println(message);
                return converter.apply(scanner.nextInt());
            }
            catch (Exception e) {
                System.err.println("Error: Incorrect input format.");
                System.exit(1);
            }
        }
    }

    private static void equals(Integer primarySum, Integer secondarySum) {
        if (primarySum != secondarySum) {
            System.err.println("Error: Not equal sum.");
            System.exit(1);
        }
    }
}