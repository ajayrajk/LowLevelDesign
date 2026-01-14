package org.basicoops.oops.abstraction;

public class CreditCardPayment implements Payment{

    @Override
    public void payment(double amount) {
        System.out.println("Credit card payment "+amount);
    }

}
