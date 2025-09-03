package org.example;

import java.util.Scanner;

public class ConsoleIO {
    public static void display(String message) {
        System.out.println(message);
    }

    public static String promptString(String message) {
        Scanner sc = new Scanner(System.in);
        display(message);
        return sc.nextLine();
    }

    public static double promptDouble(String message) {
        double result;
        while (true) {
            try {
                result = Double.parseDouble(promptString(message));
                return result;
            } catch (NumberFormatException ex) {
                display("Invalid number");
            }
        }
    }
}
