import java.util.Scanner;

public class WhileLoops {
    public static void main(String[] args) {

        //1. Countdown Timer (While Loop)
        //● Prompt the user for a starting number.
        Scanner console = new Scanner(System.in);
        String input = "";
        int number = 0;
        while (true) {
            System.out.print("Enter a number: ");
            input = console.nextLine();
            try {
                number = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
        //● Use a while loop to count down to zero.
        while (number >= 0) {
            System.out.println(number);
            number--;
        }

        //● Print "Blast off!" when it reaches zero
        System.out.println("Blast off!");
        //2. Password Validator (While Loop)
        while (true) {
            //● Ask the user to enter a password.
            System.out.print("Enter a new password: ");
            input = console.nextLine();
            //● Keep asking until they enter the correct password ("letmein").
            if (!input.equals("letmein")) {
                System.out.println("Invalid password.");
            } else {
                System.out.println("Password reset complete.");
                break;
            }
        }



    }
}
