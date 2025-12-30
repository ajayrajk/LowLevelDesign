package org.solid.principle.structural.adapterdesign.withadapter;


public class PaypalAdapter implements PaymentProcessor {
    PaypalLibrary paypalLibrary=new PaypalLibrary();

    @Override
    public void pay(String currency, double amount) {
        paypalLibrary.payAmount(currency, amount);
    }
}
