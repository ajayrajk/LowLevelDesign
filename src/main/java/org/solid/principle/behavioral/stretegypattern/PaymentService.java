package org.solid.principle.behavioral.stretegypattern;

public class PaymentService {

    public void pay(String method) {
        if (method.equals("credit")) {
            System.out.println("Paid using Credit Card");
        } else if (method.equals("paypal")) {
            System.out.println("Paid using PayPal");
        } else if (method.equals("upi")) {
            System.out.println("Paid using UPI");
        }
    }
}
