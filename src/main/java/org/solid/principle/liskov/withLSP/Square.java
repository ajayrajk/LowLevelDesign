package org.solid.principle.liskov.withLSP;

import org.solid.principle.liskov.withLSP.Shape;

public class Square implements Shape
{
   protected int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side*side;
    }


}
