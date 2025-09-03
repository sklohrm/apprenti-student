package org.example;

public class ShoppingCart {

    // After going through it in class it seems I overthought things. Still going to leave the comment below just
    // to keep my thoughts here.

    // I made these changes assuming that the refactoring has to pass tests as written. If I was rewriting the tests as
    // well, I would make items, taxRate, and discountCode all variables on the ShoppingCart class. Then you wouldn't
    // need to pass around all of them as arguments to the private methods. The way that the methods work now, it makes
    // more sense for ShoppingCart to be a service or utility with a static checkout method.

    public double checkoutShoppingCart (Item[] items, double taxRate, double discountCode) {

        double subtotal = calculateSubtotal(items);

        subtotal = applyDiscount(subtotal, discountCode);

        subtotal = applyTax(subtotal, taxRate);

        return subtotal;
    }


    // Private Helper methods
    private double calculateSubtotal(Item[] items) {
        double subtotal = 0.0;
        for (Item item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    private double applyDiscount(double subtotal, double discountCode) {
        double discount = subtotal * discountCode;
        return subtotal - discount;
    }

    private double applyTax(double subtotal, double taxRate) {
        return subtotal + (subtotal * taxRate);
    }

}
