package org.designpattern.structural.decorator;

public class SugarCoffee implements  Coffee{
    public String getDescription() {
        return "Simple Coffee +  Sugar";
    }
    public double getCost() {
        return 55.0;
    }
}
