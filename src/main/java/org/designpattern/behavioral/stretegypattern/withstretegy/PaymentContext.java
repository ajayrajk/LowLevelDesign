package org.designpattern.behavioral.stretegypattern.withstretegy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy){
        this.strategy=strategy;
    }

    public void pay(int amount){
        this.strategy.pay(amount);
    }
}
