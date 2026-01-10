package org.designpattern.behavioral.interpreter;

public class InterpreterDemo {

    public static void main(String[] args) {
        // Constructing the expression: (5 + 3) - (2 + 1)
        Expression five = new NumberExpression(8);
        Expression three = new NumberExpression(3);
        Expression two = new NumberExpression(2);
        Expression one = new NumberExpression(1);

        Expression add1 = new AddExpression(five, three); // 5 + 3
        Expression add2 = new AddExpression(two, one);   // 2 + 1

        Expression subtract = new SubtractExpression(add1, add2); // (5 + 3) - (2 + 1)

        // Interpreting the expression
        System.out.println("Result: " + subtract.interpret()); // Result: 5
    }
}
