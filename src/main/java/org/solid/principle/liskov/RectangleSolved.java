package org.solid.principle.liskov;

public class RectangleSolved implements Shape{

    protected int width;
    protected int height;

    public RectangleSolved(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width*height;
    }
}
