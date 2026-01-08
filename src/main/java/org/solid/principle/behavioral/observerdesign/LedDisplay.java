package org.solid.principle.behavioral.observerdesign;

public class LedDisplay implements Observer{

    @Override
    public void update(int temperature) {
        System.out.println("Temperature have changed to "+temperature);
    }
}
