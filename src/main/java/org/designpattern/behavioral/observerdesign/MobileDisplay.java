package org.designpattern.behavioral.observerdesign;

public class MobileDisplay implements Observer{

    @Override
    public void update(int temperature) {
        System.out.println("Temperature have changed to "+temperature);
    }
}
