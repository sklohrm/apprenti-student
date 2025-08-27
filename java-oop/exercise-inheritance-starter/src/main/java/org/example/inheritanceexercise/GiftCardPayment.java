package org.example.inheritanceexercise;

public class GiftCardPayment extends Payment {

    private String accountNumber;
    private double balance;
    private int loyaltyPoints;

    public GiftCardPayment(int id, double amount, String accountNumber, double balance, int loyaltyPoints) {
        super(id, amount);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.loyaltyPoints = loyaltyPoints;
    }


    @Override
    public boolean processPayment() {
        System.out.println("Processing gift card and adding loyalty points.");
        if (balance >= super.getAmount()) {
            balance -= super.getAmount();
            loyaltyPoints += 100 * ((int) Math.floor(super.getAmount()));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Type: Gift Card Balance: $" + String.format("%.2f", balance) + " Loyalty Points: " + loyaltyPoints;
    }
}
