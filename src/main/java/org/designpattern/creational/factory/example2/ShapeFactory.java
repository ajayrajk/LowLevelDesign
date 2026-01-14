package org.designpattern.creational.factory.example2;

public class ShapeFactory {

    public  Shape getFactory(String factoryType){
        if (factoryType.equals("circle"))
            return new Circle();
        else return new Square();

    }
}
