package org.designpattern.structural.adapterdesign;

public class RazorPayProcessor implements PaymentProcessor{
    @Override
    public void pay(String currency, double amount) {
          System.out.println("Paying using razorpay "+ currency +" "+amount);
    }
}
