import java.util.Random;
import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        //Guess the Number (Do-While Loop)
        //● Generate a random number between 1 and 50.
        //● Ask the user to guess the number.
        //● Keep asking until the user gets it right using a do-while loop.
        Random rand = new Random();
        Scanner console = new Scanner(System.in);

        int randomNumber = rand.nextInt(1, 50);
        System.out.println(randomNumber);
        System.out.print("Guess the number between 1 and 50: ");
        do {
            int guess = Integer.parseInt(console.nextLine());
            if (guess == randomNumber) {
                break;
            }
            System.out.print("Wrong! Guess again: ");
        } while (true);
        System.out.println("You got it!");

//        Simple ATM System (Do-While Loop)
//        ● Start with an account balance of $500.
        double balance = 500.00;
        int input = 0;
        double ammt = 0;

        System.out.println("Welcome to the ATM");
        //        ● Use a do-while loop to keep asking until they choose to exit
        do {
            //        ● Ask the user if they want to:
            //        ○ 1 Withdraw
            //        ○ 2 Deposit
            //        ○ 3 Check Balance
            //        ○ 4 Exit
            System.out.println("What do you want to do?");
            System.out.println("1 Withdraw");
            System.out.println("2 Deposit");
            System.out.println("3 Check Balance");
            System.out.println("4 Exit");
            System.out.print("Enter your choice: ");
            input = Integer.parseInt(console.nextLine());
            switch (input) {
                case 1:
                    System.out.print("How much do you want to withdraw:");
                    ammt = Double.parseDouble(console.nextLine());
                    balance -= ammt;
                    break;
                case 2:
                    System.out.print("How much do you want to deposit: ");
                    ammt = Double.parseDouble(console.nextLine());
                    balance += ammt;
                    break;
                case 3:
                    System.out.println("Current Balance: " + balance);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Something happened.");
            }
        } while (input != 4);
        System.out.println("Goodbye!");


    }

}
