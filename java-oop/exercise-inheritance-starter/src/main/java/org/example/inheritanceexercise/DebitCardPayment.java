package org.example.inheritanceexercise;

public class DebitCardPayment extends Payment {

    private long routingNumber;
    private long accountNumber;
    private String bankName;
    private double processingFee;

    public DebitCardPayment(
            int id,
            double amount,
            long routingNumber,
            long accountNumber,
            String bankName,
            double processingFee) {
        super(id, amount);
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.processingFee = processingFee;
    }

    @Override
    public boolean processPayment() {
        System.out.println("Direct debit processing fee: $" + String.format("%.2f", processingFee));
        System.out.println("Sending transaction to the bank: " + bankName);
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " Type: Debit Card Bank: " + bankName;
    }
}
