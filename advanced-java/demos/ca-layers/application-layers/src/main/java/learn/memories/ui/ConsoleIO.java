package learn.memories.ui;

import java.util.Scanner;

public class ConsoleIO implements TextIO {

    private final Scanner console = new Scanner(System.in);

    @Override
    public void printLn(Object value) {
        System.out.println(value);
    }

    @Override
    public void print(Object value) {
        System.out.print(value);
    }

    @Override
    public void printf(String format, Object... values) {
        System.out.printf(format, values);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return console.nextLine();
    }

    @Override
    public boolean readBoolean(String prompt) {
        String result = readString(prompt);
        return result.equalsIgnoreCase("y");
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            String value = readString(prompt);
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                printf("'%s' is not a valid number.%n", value);
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if ( value >= min && value <= max) {
                return value;
            }
            printf("Value must be between %s and %s.%n", min, max);
        }
    }
}
