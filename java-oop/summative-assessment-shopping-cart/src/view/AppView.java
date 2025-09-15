package view;

import model.CartItem;
import model.Product;

import java.util.List;
import java.util.Scanner;

/**
 * Handles console input and output.
 * <p>
 * Uses <code>ConsoleIO</code> to read input and display messages to the user.
 * Provides methods for displaying products, cart contents, and prompting for various types of input.
 */
public class AppView {

    private ConsoleIO io;

    /**
     * Constructs an AppView using the specified ConsoleIO instance.
     *
     * @param io the ConsoleIO instance used for input and output
     */
    public AppView(ConsoleIO io) {
        this.io = io;
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to display
     */
    public void displayMessage(String message) {
        io.print(message);
    }

    /**
     * Displays a list of products to the user.
     *
     * @param products the list of products to display
     */
    public void displayProducts(List<Product> products) {
        io.print("=========================Inventory=========================");
        for (Product product : products) {
            io.print(formatProduct(product));
        }
        io.print("===========================================================");
    }

    /**
     * Formats a product for display with standardized layout.
     * <p>
     * Returns a formatted string containing the product's ID, name (left-aligned in a 25-character field),
     * and price formatted as currency with two decimal places.
     *
     * @param product the product to format
     * @return a formatted string representation of the product
     */
    public String formatProduct(Product product) {
        return String.format("ID: %s | Name: %-25s | Price: $%.2f", product.getId(), product.getName(), product.getPrice());
    }

    /**
     * Formats a cart item for display including product information and quantity.
     * <p>
     * Returns a formatted string that combines the product's standard formatting
     * (from formatProduct) with the item's quantity, formatted with comma separators
     * and right-aligned in a 13-character field.
     *
     * @param item the cart item to format
     * @return a formatted string representation of the cart item including quantity
     */
    public String formatCartItem(CartItem item) {
        return formatProduct(item.getProduct()) + " | Quantity: " + String.format("%,13d", item.getQuantity());
    }

    /**
     * Displays a formatted message indicating an action performed on a product.
     * <p>
     * Outputs a message in the format: "[action] x[quantity] [productName]"
     * For example: "Added x5 Red Apples (1 lb)" or "Removed x2 Bananas (1 lb)"
     *
     * @param action the action performed (e.g., "Added", "Removed")
     * @param quantity the quantity of the product involved in the action
     * @param productName the name of the product
     */
    public void displayformattedQuantityMessage(String action, int quantity, String productName) {
        io.print(action + " x" + quantity + " " + productName);
    }


    /**
     * Displays the contents of a shopping cart to the user.
     *
     * @param cartItems the list of cart items to display
     */
    public void displayCart(List<CartItem> cartItems) {
        io.print("===================================Cart Contents=====================================");
        if (cartItems.isEmpty()) {
            io.print("Your cart is empty.");
        } else {
            for (CartItem cartItem : cartItems) {
                io.print(formatCartItem(cartItem));
            }
        }
        io.print("=====================================================================================");
    }

    /**
     * Displays a prompt to the user with standardized formatting.
     * <p>
     * Outputs the prompt message followed by a colon and space to indicate
     * that user input is expected.
     *
     * @param prompt the prompt message to display
     */
    public void prompt(String prompt) {
        io.print(prompt + ": ");
    }

    /**
     * Prompts the user for string input.
     *
     * @param prompt the prompt message
     * @return the user input as a String
     */
    public String getString(String prompt) {
        prompt(prompt);
        return io.getInput();
    }

    /**
     * Prompts the user for string input and converts it to uppercase.
     *
     * @param prompt the prompt message
     * @return the user input as a String formatted with <code>.toUpperCase()</code>
     */
    public String getStringUpperCase(String prompt) {
        return getString(prompt).toUpperCase();
    }

    /**
     * Prompts the user for integer input, repeating until a valid integer is entered.
     *
     * @param prompt the prompt message
     * @return the user input as an integer
     */
    public int getInt(String prompt) {
        String input;
        while (true) {
            prompt(prompt);
            input = io.getInput();
            try {
                long value = Long.parseLong(input);

                if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
                    io.print("ERROR: Number is too large or too small.");
                } else {
                    return (int) value;
                }
            } catch (NumberFormatException e) {
                io.print("ERROR: Enter a number.");
            }
        }
    }

    /**
     * Prompts the user for an integer within the specified range, repeating until a valid integer is entered.
     *
     * @param prompt the prompt message
     * @param min    the minimum accepted value (inclusive)
     * @param max    the maximum accepted value (inclusive)
     * @param error  the error message to display if input is out of range
     * @return the user input as an integer
     */
    public int getIntInRange(String prompt, int min, int max, String error) {
        while (true) {
            int value = getInt(prompt);
            if (value >= min && value <= max) {
                return value;
            } else {
                io.print(error);
            }
        }
    }

    /**
     * Prompts the user for an integer within the specified range, repeating until a valid integer is entered.
     * <p>
     * Uses a default error message.
     *
     * @param prompt the prompt message
     * @param min    the minimum accepted value (inclusive)
     * @param max    the maximum accepted value (exclusive)
     * @return the user input as an integer
     */
    public int getIntInRange(String prompt, int min, int max) {
        return getIntInRange(prompt, min, max, "Error: Enter a number between " + min + " and " + max + ".");
    }

    /**
     * Prompts the user for a positive integer, repeating until a positive integer is entered.
     *
     * @param prompt the prompt message
     * @return the user input as an integer
     */
    public int getPositiveInt(String prompt) {
        return getIntInRange(prompt, 1, Integer.MAX_VALUE, "Error: Enter a positive number.");
    }

}
