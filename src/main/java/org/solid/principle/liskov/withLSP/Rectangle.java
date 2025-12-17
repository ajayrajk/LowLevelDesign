package org.solid.principle.liskov.withLSP;

import org.solid.principle.liskov.withLSP.Shape;

public class Rectangle implements Shape {

    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width*height;
    }
}
