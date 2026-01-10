package org.designpattern.behavioral.visitordesign.withvisitor;

public interface Shape {
    void accept(ShapeVisitor shapeVisitor);
}
