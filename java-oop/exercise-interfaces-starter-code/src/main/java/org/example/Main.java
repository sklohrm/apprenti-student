package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Before proceeding with the Main class, perform the following:
        1) Create three classes that implement the `Connectable` interface within the project.
            You should have the following devices:
            * TV
            * Fridge
            * Toaster
        2) Modify those classes to implement the desired behaviours within each:
            * Each class needs a property to capture the state, a boolean, to capture whether the device is on or off
            * Modify the methods as appropriate
            * The getName() method simply can return a hardcoded value representing the device type
        */

        // Define an array of devices to store 5 devices
        List<Connectable> devices = new ArrayList<>();

        System.out.println("Welcome to the Device Manager App!!");
        System.out.println("===================================");

        System.out.println("Setup the devices");
        System.out.println("=================\n");

        // Loop through the array of devices
        // - Prompt user for device type to add
        // - Create the device instance
        // - Store the instance in the array
        System.out.println("What type of device would you like to add?");
        System.out.println("1. Television");
        System.out.println("2. Refrigerator");
        System.out.println("3. Toaster");
        System.out.println("4. Exit");
        boolean exit = false;
        while (!exit) {
            switch (promptInt("Enter a number: ", 1, 4)) {
                case 1:
                    devices.add(new Television());
                    System.out.println("Television Added.");
                    break;
                case 2:
                    devices.add(new Refrigerator());
                    System.out.println("Refrigerator Added.");
                    break;
                case 3:
                    devices.add(new Toaster());
                    System.out.println("Toaster Added.");
                    break;
                default:
                    exit = true;
            }
        }


        // Come up with a menu system which will provide the following:
        // Select the device (one of the 5 in our array)
        // Device Menu Options:
        // - 1. Get Device Name
        // - 2. Turn On Device
        // - 3. Turn Off Device
        // - 4. Get Device Status
        // - 5. Quit
        // This process should continue until the user enters '5' to Quit
        while (true) {
            // This menu lists devices and prompts to select a device
            System.out.println("Interact with the devices");
            System.out.println("=========================");
            for (int i = 0; i < devices.size(); i++) {
                System.out.println(i + 1 + ". " + devices.get(i));
            }
            System.out.println((devices.size() + 1) + ". Exit");

            int choice = promptInt("Choose a device to interact with: ", 1, devices.size() + 1);

            if (choice == devices.size() + 1) {
                break;
            }

            Connectable currentDevice = devices.get(choice - 1);


            boolean goBack = false;
            while (!goBack) {
                // This menu prompts user to interact with the chosen device or go back
                System.out.println("Device Menu Options");
                System.out.println("=========================");
                System.out.println("1. Get Device Name");
                System.out.println("2. Turn on Device");
                System.out.println("3. Turn off Device");
                System.out.println("4. Get Device Status");
                System.out.println("5. Go Back");
                switch (promptInt("Enter a Number: ", 1, 5)) {
                    case 1:
                        System.out.println("Name: " + currentDevice.getName());
                        break;
                    case 2:
                        System.out.println(currentDevice.getName() + " is now on.");
                        currentDevice.turnOn();
                        break;
                    case 3:
                        System.out.println(currentDevice.getName() + " is now off.");
                        currentDevice.turnOff();
                        break;
                    case 4:
                        System.out.println(currentDevice.getName() + " is currently " + (currentDevice.getState() ? "on." : "off."));
                        break;
                    default:
                        goBack = true;
                }
            }
        }


        System.out.println("\nThanks for using the Device Manager App. Bye!");
    }

    // Utility method to prompt user for integer input
    public static int promptInt(String message) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (true) {
            try {
                System.out.println(message);
                String input = sc.nextLine();
                result = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }
        return result;
    }

    // Utility method to prompt user for integer input within a range
    public static int promptInt(String message, int min, int max) {
        int result = 0;

        boolean isValid = false;
        while (!isValid) {
            result = promptInt(message);
            if (result > max || result < min) {
                System.out.println("Entry out of range: " + min + " - " + max + ". Try again.");
            }
            else {
                isValid = true;
            }
        }
        return result;
    }
}