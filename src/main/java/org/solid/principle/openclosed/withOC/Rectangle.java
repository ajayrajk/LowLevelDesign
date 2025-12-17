package org.solid.principle.openclosed.withOC;

public class Rectangle implements Shape{
    double length;
    double width;
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length*width;
    }
}


