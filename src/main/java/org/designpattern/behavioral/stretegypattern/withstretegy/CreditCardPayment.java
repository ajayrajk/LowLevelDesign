package org.designpattern.behavioral.stretegypattern.withstretegy;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println(" Pay by Credit Card payment method amount is :"+amount);
    }
}
