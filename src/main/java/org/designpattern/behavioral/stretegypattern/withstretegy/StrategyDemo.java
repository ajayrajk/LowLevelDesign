package org.designpattern.behavioral.stretegypattern.withstretegy;

public class StrategyDemo {
    public static void main(String[] args) {
        PaymentContext context=new PaymentContext();
        context.setPaymentStrategy(new CreditCardPayment());
        context.pay(500);
    }
}
