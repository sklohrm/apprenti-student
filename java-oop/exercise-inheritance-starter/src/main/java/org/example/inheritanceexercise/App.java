package org.example.inheritanceexercise;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();

        //Create your sample payments here
        CreditCardPayment creditPayment = new CreditCardPayment(1, 15.42, 12345654, "American Express");
        DebitCardPayment debitPayment = new DebitCardPayment(2, 558.93, 4944, 299390001, "US Bank", 0.25);
        GiftCardPayment giftCardPayment = new GiftCardPayment(3, 101.99, "Joe Blow", 1000.00, 255);

        payments.add(creditPayment);
        payments.add(debitPayment);
        payments.add(giftCardPayment);

        //Payments Report
        for (Payment p : payments) {
            System.out.println(p.toString());
        }

        //Payment Processing Report
        for (Payment p : payments) {
            p.processPayment();
        }

        // Uncomment this section after implementing GiftCardPayment to verify that balances are correct after processing
        // Post processing gift card balance check
        for (Payment p : payments) {
            if (p instanceof GiftCardPayment) {
                System.out.println(p.toString());
            }
        }
    }
}
