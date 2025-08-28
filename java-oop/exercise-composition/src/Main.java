import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Variables
        Artifact artifact;
        String artifactName;
        int yearOfDiscovery;
        Person discoverer;
        String firstName;
        String lastName;
        String specialty;

        System.out.println("Welcome to the Museum's Artifact Deposit Page");

        // Enter the name of a new Artifact
        System.out.println("Enter the name of the Artifact: ");
        artifactName = input.nextLine();

        // Enter the year of it's discovery
        System.out.println("Enter the year it was discovered: ");
        while (true) {
            try {
                yearOfDiscovery = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid format, enter a number: ");
            }
        }

        // Enter the name and specialty of the discoverer
        System.out.println("Enter the first name of the discoverer:");
        firstName = input.nextLine();

        System.out.println("Enter the last name of the discoverer:");
        lastName = input.nextLine();

        System.out.println("Enter the specialty of the discoverer: ");
        specialty = input.nextLine();

        discoverer = new Person(firstName, lastName, specialty);

        // If-else for whether discoverer is the curator
        while (true) {
            System.out.println("Is the discoverer the curator? (y/n)");
            String choice = input.nextLine().trim();

            if (choice.equalsIgnoreCase("y")) {
                artifact = new Artifact(artifactName, discoverer, discoverer, yearOfDiscovery);
                break;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("Enter the first name of the curator: ");
                firstName = input.nextLine();

                System.out.println("Enter the last name of the curator: ");
                lastName = input.nextLine();

                System.out.println("Enter the specialty of the curator: ");
                specialty = input.nextLine();

                Person curator = new Person(firstName, lastName, specialty);

                artifact = new Artifact(artifactName, discoverer, curator, yearOfDiscovery);
                break;
            } else {
                System.out.println("Invalid input. Enter 'y' or 'n'");
            }
        }

        // Print out report
        System.out.println(artifact);

    }

}
