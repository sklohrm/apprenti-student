import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Variables
        Artifact artifact = new Artifact();
        int yearOfDiscovery;
        Person discoverer = new Person();
        String firstName;
        String lastName;
        String specialty;

        System.out.println("Welcome to the Museum's Artifact Deposit Page");

        // Enter the name of a new Artifact
        System.out.println("Enter the name of the Artifact: ");
        artifact.setName(input.nextLine());

        // Enter the year of it's discovery
        System.out.println("Enter the year it was discovered: ");
        while (true) {
            try {
                artifact.setYearOfDiscovery(Integer.parseInt(input.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid format, enter a number: ");
            }
        }

        // Enter the name and specialty of the discoverer
        System.out.println("Enter the first name of the discoverer:");
        discoverer.setFirstName(input.nextLine());

        System.out.println("Enter the last name of the discoverer:");
        discoverer.setLastName(input.nextLine());

        System.out.println("Enter the specialty of the discoverer: ");
        discoverer.setSpecialty(input.nextLine());

        artifact.setDiscoverer(discoverer);

        // If-else for whether discoverer is the curator
        while (true) {
            System.out.println("Is the discoverer the curator? (y/n)");
            String choice = input.nextLine().trim();

            if (choice.equalsIgnoreCase("y")) {
                artifact.setCurator(discoverer);
                break;
            } else if (choice.equalsIgnoreCase("n")) {
                // I use a second person because the Artifact's toString() calls .equals() on the Person class
                // If all I did was change the names, It would still use the same class and think that the curator
                // and discoverer are the same person.
                Person curator = new Person();

                System.out.println("Enter the first name of the curator: ");
                curator.setFirstName(input.nextLine());

                System.out.println("Enter the last name of the curator: ");
                curator.setLastName(input.nextLine());

                System.out.println("Enter the specialty of the curator: ");
                curator.setSpecialty(input.nextLine());

                artifact.setCurator(curator);
                break;
            } else {
                System.out.println("Invalid input. Enter 'y' or 'n'");
            }
        }

        // Print out report
        System.out.println(artifact);

    }

}
