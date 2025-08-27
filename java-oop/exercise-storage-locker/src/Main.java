import java.util.Scanner;

public class Main {

    // I remembered javadocs exist, so I messed around with them a bit in this assignment.

    static Scanner input = new Scanner(System.in);
    static LockerManager lockerManager = new LockerManager();

    public static void main(String[] args) {

        // Initialize variables
        boolean exit = false;

        System.out.println("Welcome to the Locker Manager!");
        while (!exit) {
            displayMenu();
            int userChoice = getValidInput(6);
            switch (userChoice) {
                // Add Locker
                case 1:
                    addLocker();
                    break;
                // Remove Locker
                case 2:
                    removeLocker();
                    break;
                // Store Item
                case 3:
                    storeItem();
                    break;
                // Retrieve Item
                case 4:
                    retrieveItem();
                    break;
                // Display All Lockers
                case 5:
                    lockerManager.displayAllLockers();
                    break;
                // Exit
                default:
                    System.out.println("Good day!");
                    exit = true;
                    break;
            }
        }
    }

    private static void retrieveItem() {
        String lockerID = promptUserForLockerID();
        Locker locker = lockerManager.getLocker(lockerID);
        if (locker != null) {
            if (locker.getContents().isEmpty()) {
                System.out.println("No item to remove.");
            } else {
                locker.removeItem();
                System.out.println("Item removed from locker " + lockerID);
            }
        } else {
            System.out.println("No Locker found.");
        }
    }

    private static String promptUserForLockerID() {
        System.out.print("Enter Locker ID: ");
        return input.nextLine();
    }

    private static String promptUserForItem() {
        System.out.print("Enter item to store: ");
        return input.nextLine();
    }

    /**
     * Store an item in a locker.
     */
    private static void storeItem() {
        String lockerID = promptUserForLockerID();
        Locker locker = lockerManager.getLocker(lockerID);
        if (locker != null) {
            String item = promptUserForItem();
            locker.storeItem(item);
            System.out.println("Item stored in locker " + lockerID);
        } else {
            System.out.println("No Locker found.");
        }
    }

    /**
     * Remove a {@code Locker} from the {@code LockerManager}.
     */
    private static void removeLocker() {
        String lockerID = promptUserForLockerID();
        if (lockerManager.getLocker(lockerID) == null) {
            System.out.println("No Locker found.");
        } else {
            lockerManager.removeLocker(lockerID);
            System.out.println("Locker " + lockerID + " removed.");
        }
    }

    private static void addLocker() {
        String lockerID = promptUserForLockerID();
        if (lockerManager.getLocker(lockerID) != null) {
            System.out.println("A Locker with the ID " + lockerID + " already exists.");
        } else {
            lockerManager.addLocker(lockerID);
            System.out.println("Locker " + lockerID + " added.");
        }
    }

    private static void displayMenu() {
        // Display is formatted with new lines to match requirements. Maybe we should remove them?
        System.out.println("\n1. Add Locker");
        System.out.println("\n2. Remove Locker");
        System.out.println("\n3. Store Item");
        System.out.println("\n4. Retrieve Item");
        System.out.println("\n5. Display All Lockers");
        System.out.println("\n6. Exit");
        System.out.print("\nChoose an option: ");
    }

    // Make sure that the input is an integer in the correct range
    public static int getValidInput(int range) {
        while (true) {
            try {
                int output = Integer.parseInt(input.nextLine());
                if (output < 0 || output > 6) {
                    throw new IllegalArgumentException();
                } else {
                    return output;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            } catch (IllegalArgumentException e) {
                System.out.print("Please enter a number between 1 and " + range + ": ");
            }
        }
    }


}
