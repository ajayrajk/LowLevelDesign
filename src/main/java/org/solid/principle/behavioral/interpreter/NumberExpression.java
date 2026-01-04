package org.solid.principle.behavioral.interpreter;
// Terminal expression for numbers
public class NumberExpression implements Expression{
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return 0;
    }
}
