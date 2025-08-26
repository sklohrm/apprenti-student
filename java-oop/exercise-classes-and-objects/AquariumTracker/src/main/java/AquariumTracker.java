import java.util.Scanner;

public class AquariumTracker {

    public static void main(String[] args) {

        // Initialize scanner, declare variable to use later
        Scanner input = new Scanner(System.in);
        AquariumFish fish;
        String species;
        String commonName;
        double maxTemp;
        double minTemp;
        String diet;

        System.out.println("Welcome to the Aquarium Tracker!\n");

        System.out.println("Enter the information for your fish.");

        // Prompt for species name
        System.out.print("Species Name: ");
        species = input.nextLine();

        // Prompt for common name
        System.out.print("Common Name: ");
        commonName = input.nextLine();

        // Prompt for max temp
        System.out.print("Maximum Temperature: ");
        maxTemp = getValidInput(input);

        // Prompt for min temp
        System.out.print("Minimum Temperature: ");
        minTemp = getValidInput(input);

        // Loop until min temp is less than max temp
        while (minTemp >= maxTemp) {
            try {
                System.out.print("Minimum temperature must me less than maximum temperature: ");
                minTemp = getValidInput(input);
            } catch (Exception e){
                System.out.print("Invalid input, please enter a number: ");
            }
        }

        // Prompt for diet
        System.out.print("Diet: ");
        diet = input.nextLine();

        // Initialize fish with information that was gathered from user
        fish = new AquariumFish(diet, minTemp, maxTemp, commonName, species);
        System.out.println("\n--Your Fish--");

        // AquariumFish has overridden toString so it can be printed directly
        System.out.println(fish);
    }


    // Checks that user input is a valid double
    public static double getValidInput(Scanner input) {
        while (true) {
            try {
                return Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                System.out.print("Invalid input, please enter a number: ");
            }
        }
    }

}
