package org.solid.principle.behavioral.visitordesign.withvisitor;

public interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}
