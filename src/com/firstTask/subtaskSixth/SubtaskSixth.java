package com.firstTask.subtaskSixth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class SubtaskSixth {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> randomArray = new ArrayList<>();

        int lowerBound = 5, upperBound = 10;

        for (int i = 0; i < (lowerBound + (int) (Math.random() * upperBound)); i++) {
            randomArray.add((int) (Math.random() * upperBound));
        }

        outputArray("Random array generated with Math.random():", randomArray);
        Collections.sort(randomArray);
        outputArray("Sorted random array generated with Math.random():", randomArray);

        randomArray.clear();

        Random myRandom = new Random();

        for (int i = 0; i < myRandom.nextInt(lowerBound, upperBound); i++) {
            randomArray.add(myRandom.nextInt(upperBound));
        }

        outputArray("Random array generated with Random class:", randomArray);
        Collections.sort(randomArray);
        outputArray("Sorted random array generated with Random class:", randomArray);
    }

    private static void outputArray(String message, ArrayList<Integer> array) {
        System.out.println(message);

        for (Integer number : array) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
