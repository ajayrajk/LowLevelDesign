package org.solid.principle.liskov;

        /*Good Example (follows LSP)
        We separate the abstractions: Shape instead of forcing Square to be a Rectangle.*/
interface Shape {
    int getArea();
}