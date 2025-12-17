package org.solid.principle.liskov.withLSP;



public class JiskovSubstitution {


    /*Problem:
    Square is not really a subtype of Rectangle.
    If a method expects a Rectangle and sets width and height separately, it will
    misbehave when given a Square.*/

    public static void main(String[] args) {
//        Rectangle rect = new Square();
//        rect.setWidth(4);
//        rect.setHeight(5);
//        System.out.println(rect.getArea()); // Expected 20, but gets 25

        Square rect = new Square(4);
        System.out.println(rect.getArea());

    }
/*
    This violates LSP because substituting Square for Rectangle breaks correctness.
*/

    /*Benefits:
    Rectangle and Square both extend Shape.
    No broken assumptions: they can be substituted wherever a Shape is expected.
            Clean, follows Liskov Substitution Principle.*/
}
