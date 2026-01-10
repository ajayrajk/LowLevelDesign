package org.designpattern.structural.adapterdesign.withadapter;

public class AdapterDemo {

    public static void main(String[] args) {
        PaymentProcessor razorpay =  new RazorPayProcessor();
        PaymentProcessor paypal = new PaypalAdapter();
        razorpay.pay("INR", 1000);
        paypal.pay("INR", 1000);
    }

}
