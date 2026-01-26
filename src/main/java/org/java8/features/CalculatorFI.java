package org.java8.features;

public class CalculatorFI {
    public static void main(String[] args) {
        Calculator c=(a,b) -> a+b;
        System.out.println(c.add(2,3));
    }
}

/*
An interface with exactly one abstract method.
*/
@FunctionalInterface
interface Calculator{
    int add(int a,int b);
}
