package org.designpattern.structural.decorator.withdecorator;

public class DecoratorDemo {

    /*
    *  If you allow you to dynamically add new behaviour or responsibility to objects that without
    *  modifying their existing code.
    * */

    /*
    *  ❓ Interview Question
       “Design a pizza system with add-ons (cheese, toppings)”
    * */

    /*
    * 🧠 Real Use
       Logging layers
       Middleware
       Spring Security filters
    * */

    public static void main(String[] args) {
          Coffee coffee=new SimpleCoffee();
          coffee=new MildDecorator(coffee);
          coffee=new SugarDecorator(coffee);

          System.out.println(coffee.getDescription()+"cost :"+coffee.getCost());

    }
}
