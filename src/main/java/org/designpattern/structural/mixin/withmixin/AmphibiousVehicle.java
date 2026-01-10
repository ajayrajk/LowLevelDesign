package org.designpattern.structural.mixin.withmixin;

public class AmphibiousVehicle extends Car implements LoggingMixin{
    void sail() {
        System.out.println("AmphibiousVehicle is sailing");
    }
}
