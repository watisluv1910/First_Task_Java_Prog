package com.firstTask.subtaskSeventh;

import java.util.Scanner;
import java.util.function.Function;

public class SubtaskSeventh {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = input("Enter the number: ",  Integer::valueOf);
        System.out.print("The factorial of the entered number: " + calcFactorial(number));
    }
    
    private static int calcFactorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
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
}
