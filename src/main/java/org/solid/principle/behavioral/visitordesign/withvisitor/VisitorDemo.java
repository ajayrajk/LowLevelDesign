package org.solid.principle.behavioral.visitordesign.withvisitor;

public class VisitorDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5), new Rectangle(4, 6)
        };

        ShapeVisitor areaCalculator = new AreaCalculator();

        for (Shape shape : shapes) {
            shape.accept(areaCalculator);
        }
    }
}
