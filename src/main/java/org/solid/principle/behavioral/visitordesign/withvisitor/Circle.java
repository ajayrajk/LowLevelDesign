package org.solid.principle.behavioral.visitordesign.withvisitor;

public class Circle implements Shape{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visit(this);
    }

    public int getRadius() {
        return radius;
    }
}
