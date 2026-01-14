package org.basicoops.oops.abstraction;

public class AbstractionDemo {
    public static void main(String[] args) {
        Payment ccPayment=new CreditCardPayment();
         ccPayment.payment(123.34);

        Payment upiPayment=new UPIPayment();
        upiPayment.payment(245.34);

    }
}
