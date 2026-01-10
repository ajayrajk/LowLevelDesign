package org.designpattern.structural.mixin;

public class CarWithLogging extends Car{

    void drive() {
        System.out.println("[LOG] Driving");
         super.drive();
    }
}
