package org.example;

//Abstraction
abstract class Shape {
    abstract void draw();  //Abstract method, to be implemented by subclasses
}

class Circle extends Shape{

    @Override
    void draw() {
        System.err.println("Drawing Circle");
    }
}

class Rectangle extends Shape{

    @Override
    void draw() {
        System.err.println("Drawing Rectangle");

    }
}

//Encapsulation
class BankAccountEncapsulation{
     private double balance;   //Attribute

     public void deposit(double amount){
         if (amount>0){
             this.balance+=amount;
         }
     }


}




//








