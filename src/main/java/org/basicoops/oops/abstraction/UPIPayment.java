package org.basicoops.oops.abstraction;

public class UPIPayment implements Payment{

    @Override
    public void payment(double amount) {
        System.out.println("UPI Payment "+amount);
    }

}
