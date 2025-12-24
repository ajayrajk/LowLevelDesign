package org.solid.principle.creational.builder.withbuilder;

public class HouseBuilderDemo {

    public static void main(String[] args) {
        House house=new House.HouseBuilder().foundation("Concreate")
                .walls("Bricks")
                .roof("Tiles")
                .swimmingPool(false)
                .garden(true)
                .garage(true)
                .build();
    }
}
