package org.solid.principle.liskov;

public class SquareSolved implements Shape
{
   protected int side;

    public SquareSolved(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side*side;
    }


}
