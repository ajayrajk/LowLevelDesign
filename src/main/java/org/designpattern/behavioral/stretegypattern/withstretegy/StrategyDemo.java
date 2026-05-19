package org.designpattern.behavioral.stretegypattern.withstretegy;

public class StrategyDemo {

    /*
    * Define a family of algorithms , encapsulations each one, and makes them interchangeable.
    * The algorithm can vary independently form of client that use it.
    * */

    /*
    * Instead of Hardcoding the logic we choose an algorithm of runtime based on context.
    * */

    /*
    * ❓ Interview Question
       “Design a payment system supporting multiple payment methods”
    * */

    /*
    *  🧠 Why Important
       Replace logic at runtime
       Avoids big if-else
       💥 Real Use
        Pricing engine
        Discount system
        Retry policies
    * */

    public static void main(String[] args) {
        PaymentContext context=new PaymentContext();
        context.setPaymentStrategy(new CreditCardPayment());
        context.pay(500);
    }
}
