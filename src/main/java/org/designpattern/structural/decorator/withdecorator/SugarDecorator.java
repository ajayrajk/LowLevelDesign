package org.designpattern.structural.decorator.withdecorator;


public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription()+ "Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost()+5.0;
    }
}
