package org.designpattern.structural.adapterdesign;

public class PaypalProcessor {


    public void payMoney(String currency, double amount) {
        System.out.println("Paying using paypal "+currency+" "+amount);
    }
}
