package org.solid.principle.liskov.withOutLSP;

/*Subclasses should be substitutable for their base classes without affecting the
        correctness of the program.
        The Liskov Substitution Principle (LSP) states:
        Let q(x) be a property provable about objects of x of type T. Then q(y) should
        be provable for objects y of type S where S is a subtype of T.
        This means that every subclass or derived class should be substitutable for
        their base or parent class.
        Bad Example (violates LSP)
        Here, Square inherits from Rectangle, but it breaks expected behavior.*/
public class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        return height*width;
    }
}
