package org.example.shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the shopping cart app!");

        // Define an instance of Scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt for tax exempt
        System.out.println("Are you tax exempt? (y/n)");
        String exemptStatus = scanner.nextLine();

        // Prompt for shipping
        System.out.println("Shipping? (y/n)");
        String shipping = scanner.nextLine();

        // Prompt for order quantity
        System.out.println("Order Quantity? (y/n)");
        String orderQuantity = scanner.nextLine();

        // Prompt for promo code
        System.out.println("Promo code for free shipping? (y/n)");
        String promoCode = scanner.nextLine();

        // Print details
        System.out.println("Details:");
        System.out.println("Tax-Exempt: " + exemptStatus);
        System.out.println("Shipping: " + shipping);
        System.out.println("Order Quantity: " + orderQuantity);
        System.out.println("Promo Code: " + promoCode);
        System.out.println("Bye");
    }

}
