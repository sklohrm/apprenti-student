import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {

    //1. Count Up! (For Loop)
    //● Write a program that prints numbers 1 to 100 using a for loop.
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    //● Modify the program to print only even numbers.
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    //2.Multiplication Table (For Loop)
    //● Ask the user for a number.
        Scanner console = new Scanner(System.in);
        String input = "";
        int number = 0;

        while (true) {
            System.out.println("Enter a number: ");
            input = console.nextLine();
            try {
                number = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    //● Print the multiplication table (1 to 10) for that number
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }

    }
}
