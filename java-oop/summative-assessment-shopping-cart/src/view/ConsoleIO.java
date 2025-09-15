package view;

import java.util.Scanner;

/**
 * Provides low-level console input and output functionality.
 * <p>
 * This class acts as a wrapper around <code>java.util.Scanner</code> and <code>System.out</code>.
 * It is designed to be used by higher-level view classes like <code>AppView</code>.
 */
public class ConsoleIO {
    Scanner scanner;

    /**
     * Constructs a ConsoleIO with the specified <code>Scanner</code>.
     *
     * @param scanner the Scanner instance used to read user input
     */
    public ConsoleIO(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Prints a message to the console.
     *
     * @param s the message to display
     */
    public void print(String s) {
        System.out.println(s);
    }

    /**
     * Reads a line of user input from the console.
     *
     * @return the line entered by the user as a String
     */
    public String getInput() {
        return scanner.nextLine();
    }
}
