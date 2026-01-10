package org.designpattern.behavioral.interpreter;

// Non-terminal expression for subtraction
public class SubtractExpression implements Expression{
    Expression left,right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret()- right.interpret();
    }
}
