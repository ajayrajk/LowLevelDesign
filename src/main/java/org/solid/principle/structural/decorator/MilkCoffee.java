package org.solid.principle.structural.decorator;

public class MilkCoffee implements Coffee{

    @Override
    public String getDescription() {
        return "Milk Coffee";
    }

    @Override
    public double getCost() {
        return 60.0;
    }
}
