package org.example.shoppingcart;

/**
 * If tax exempt don't charge tax.
 * If order total is more than $100 apply discount 5%
 * If order total is more than $500 apply discount 10%
 * If promo code is valid, apply free shipping (unless next-day or 2-day)
 */
public class ShoppingCartApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the shopping cart app!");

        java.util.Scanner console = new java.util.Scanner(System.in);

        double productPrice = 4.99;
        int productQuantity = 78;
        double totalCost = productPrice * productQuantity;

        // New variables
        double taxRate = .07;
        double standardShipping = 2.00;
        double twoDayShipping = 5.00;
        double overnightShipping = 10.00;

        System.out.println("Product Price: " + productPrice);
        System.out.println("Product Quantity: " + productQuantity);
        System.out.println("Total Cost: " + totalCost);

        // Prompt for tax exempt
        System.out.print("Are you tax-exempt? (y/n) ");
        String taxExempt = console.nextLine();

        // Prompt for shipping
        System.out.print("Shipping? (standard / overnight / two-day) ");
        String shipping = console.nextLine();

        // Prompt for promo code
        System.out.print("Promo code for free shipping? ");
        String promoCode = console.nextLine();

        if (totalCost > 100) {
            // If order total is more than 500 apply discount 10%
            if (totalCost > 500) {
                totalCost *= .9;
            } else {
                // If order total is more than 100 apply discount 5%
                totalCost *= .95;
            }
        }

        // Charge tax if not exempt
        if (taxExempt.equals("n")) {
            totalCost *= (1 + taxRate);
        }

        // If promo code is valid apply free shipping unless overnight or two-day
        switch (shipping) {
            case "standard":
                if (promoCode != null) {
                    break;
                } else {
                    totalCost += 2.00;
                    break;
                }
            case "overnight":
                totalCost += 5.00;
                break;
            case "two-day":
                totalCost += 10.00;
                break;
            default:
                System.out.println("Invalid shipping type");
                break;
        }

        // Print details
        System.out.println("\nDetails:");
        System.out.println("Tax-exempt: " + taxExempt);
        System.out.println("Shipping: " + shipping);
        System.out.println("Promo code: " + promoCode);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Bye");
    }
}