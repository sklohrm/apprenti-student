import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // Initialize variables
        Scanner input = new Scanner(System.in);
        LockerManager lockerManager = new LockerManager();
        boolean exit = false;

        System.out.println("Welcome to the Locker Manager!");
        while (exit == false) {
            System.out.println("\n1. Add Locker");
            System.out.println("\n2. Remove Locker");
            System.out.println("\n3. Store Item");
            System.out.println("\n4. Retrieve Item");
            System.out.println("\n5. Display All Lockers");
            System.out.println("\n6. Exit");
            System.out.print("\nChoose an option: ");
            int userChoice = getValidInput(input, 6);
            String lockerID;
            String item;
            Locker locker;
            switch (userChoice) {
                // Add Locker
                case 1:
                    System.out.print("Enter Locker ID: ");
                    lockerID = input.nextLine();
                    if (lockerManager.getLocker(lockerID) != null) {
                        System.out.println("A Locker with the ID " + lockerID + " already exists.");
                    } else {
                        lockerManager.addLocker(lockerID);
                        System.out.println("Locker " + lockerID + " added.");
                    }
                    break;
                // Remove Locker
                case 2:
                    System.out.print("Enter Locker ID: ");
                    lockerID = input.nextLine();
                    if (lockerManager.getLocker(lockerID) == null) {
                        System.out.println("No Locker found.");
                    } else {
                        lockerManager.removeLocker(lockerID);
                        System.out.println("Locker " + lockerID + " removed.");
                    }
                    break;
                // Store Item
                case 3:
                    System.out.print("Enter Locker ID: ");
                    lockerID = input.nextLine();
                    locker = lockerManager.getLocker(lockerID);
                    if (locker != null) {
                        System.out.println("Enter item to store: ");
                        item = input.nextLine();
                        locker.storeItem(item);
                        System.out.println("Item stored in locker " + lockerID);
                    } else {
                        System.out.println("No Locker found.");
                    }
                    break;
                // Retrieve Item
                case 4:
                    System.out.print("Enter Locker ID: ");
                    lockerID = input.nextLine();
                    locker = lockerManager.getLocker(lockerID);
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
                    break;
                // Display All Lockers
                case 5:
                    lockerManager.displayAllLockers();
                    break;
                // Exit
                default:
                    exit = true;
                    break;
            }
        }


    }

    // Make sure that the input is an integer in the correct range
    public static int getValidInput(Scanner input, int range) {
        while (true) {
            try {
                int output = Integer.parseInt(input.nextLine());
                if (output < 0 || output > 6) {
                    System.out.print("Please enter a number between 1 and " + range + ": ");
                } else {
                    return output;
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }


}
