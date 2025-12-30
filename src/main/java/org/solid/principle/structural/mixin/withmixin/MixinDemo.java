package org.solid.principle.structural.mixin.withmixin;

public class MixinDemo {
    public static void main(String[] args) {
        AmphibiousVehicle vehicle = new AmphibiousVehicle();
        vehicle.drive();
        vehicle.sail();
        vehicle.log("Vehicle is operational");
    }
}
