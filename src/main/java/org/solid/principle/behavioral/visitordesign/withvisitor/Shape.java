package org.solid.principle.behavioral.visitordesign.withvisitor;

public interface Shape {
    void accept(ShapeVisitor shapeVisitor);
}
