package org.designpattern.creational.abstractfactory;

public class MacButton implements Button{

    @Override
    public void render() {
       System.out.println("Rendering mac button");
    }
}
