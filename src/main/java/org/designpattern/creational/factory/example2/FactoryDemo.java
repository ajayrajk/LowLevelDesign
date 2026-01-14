package org.designpattern.creational.factory.example2;

public class FactoryDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory=new ShapeFactory();

        Shape shape1=shapeFactory.getFactory("circle");
        shape1.draw();

        Shape shape2=shapeFactory.getFactory("square");
        shape2.draw();


    }
}
