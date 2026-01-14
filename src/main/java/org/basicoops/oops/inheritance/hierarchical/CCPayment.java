package org.basicoops.oops.inheritance.hierarchical;

public class CCPayment extends Payment{


    @Override
    public void pay() {
        System.out.println("Pay by credit card");
    }

}
