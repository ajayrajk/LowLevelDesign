package org.solid.principle.structural.adapterdesign.withadapter;


public class RazorPayProcessor implements PaymentProcessor {


    @Override
    public void pay(String currency, double amount) {
        System.out.println("Razorpay payment");
    }
}
