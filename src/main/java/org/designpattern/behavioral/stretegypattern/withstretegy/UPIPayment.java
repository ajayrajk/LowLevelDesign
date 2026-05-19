package org.designpattern.behavioral.stretegypattern.withstretegy;

public class UPIPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println(" Pay by UPI payment method amount is :"+amount);
    }
}
