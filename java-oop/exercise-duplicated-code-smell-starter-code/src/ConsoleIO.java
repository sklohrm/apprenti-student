import java.util.Scanner;

public class ConsoleIO {

    Scanner myScanner = new Scanner(System.in);

    public void writeMessage(String message) {
        System.out.println(message);
    }

    // Breaks loop when valid int is provided, otherwise throws error and prompts again.
    public int getInteger(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(getInput(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Input a valid number");
            } catch (Exception e) {
                System.out.println("Something happened...");
            }
        }
    }

    // The call to getInteger covers type validation so the only error that needs to be checked for is whether the
    // number is in range.
    public int getIntegerInBetween(String prompt, int min, int max) {
        while (true) {
            try {
                int number = getInteger(prompt);
                if (number < min || number > max) {
                    throw new IllegalArgumentException();
                }
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a number between " + min + " and " + max);
            } catch (Exception e) {
                System.out.println("Something happened...");
            }
        }
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        return myScanner.nextLine();
    }

    public String getNameWithDefault(String prompt, String defaultValue) {
        String name = getInput(prompt);
        if (name == null || name.isEmpty()) {
            System.out.println("It's okay if you don't want to tell me your name.");
            name = defaultValue;
        }
        return name;
    }

    // Similar to the getIntegerBetween method, but working on Strings instead.
    public String getNonNullNonEmptyString (String prompt) {
        while (true) {
            try {
                String result = getInput(prompt);
                if(result == null || result.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                return result;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a valid response.");
            } catch (Exception e) {
                System.out.println("Something happened...");
            }
        }
    }

    // Works the same as getInteger, but parses a double instead.
    public double getMoney() {
        while (true) {
            try {
                return Double.parseDouble(getInput("Enter the amount of cash on hand: "));
            } catch (NumberFormatException e) {
                System.out.println("Input a valid number");
            } catch (Exception e) {
                System.out.println("Something happened...");
            }
        }
    }

    // Works like getIntegerBetween method, but the range is hard coded to be positive. Again the possible errors are
    // caught between this method and getMoney
    public double getPositiveMoney() {
        while (true) {
            try {
                double number = getMoney();
                if (number < 0) {
                    throw new IllegalArgumentException();
                }
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a positive number.");
            } catch (Exception e) {
                System.out.println("Something happened...");
            }
        }
    }
}
