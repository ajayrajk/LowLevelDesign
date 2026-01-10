package org.designpattern.structural.decorator.withdecorator;

public class DecoratorDemo {

    public static void main(String[] args) {
          Coffee coffee=new SimpleCoffee();
          coffee=new MildDecorator(coffee);
          coffee=new SugarDecorator(coffee);

          System.out.println(coffee.getDescription()+"cost :"+coffee.getCost());

    }
}
