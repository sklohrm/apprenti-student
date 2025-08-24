package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        String[] inputs = {"water", "soda", "juice", "WATER", "Tea", ""};
        String[] expectedOutputs = {
                "You selected Water",
                "You selected Soda",
                "You selected Juice",
                "You selected Water",
                "Invalid selection",
                "Invalid selection"
        };


        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expected = expectedOutputs[i];
            System.out.print("Testing with " + input + "... ");
            String actual = selectDrink(input);
            if (expected.equals(actual)) {
                System.out.println("Passed!");
            } else {
                System.out.println("FAIL: Expected '" + expected + "', got '" + actual + "'");
            }
        }
    }

    private static String selectDrink(String choice) {
        choice = choice.toLowerCase(); // Normalize input for case insensitivity
        System.out.println("Received input: " + choice); // Debug print

        // add switch
        switch (choice) {
            case "water":
                return "You selected Water";
            case "soda":
                return "You selected Soda";
            case "juice":
                return "You selected Juice";
            default:
                return "Invalid selection";
        }
    }
}