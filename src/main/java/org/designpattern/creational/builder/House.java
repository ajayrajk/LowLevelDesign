package org.designpattern.creational.builder;

public class House {
   /* The Builder pattern separates the construction of a complex object from its
    representation. It allows the step-by-step creation of objects, providing greater control
    over the construction process and enabling the production of different representations
    of an object using the same construction code. This pattern is particularly useful
    when an object requires multiple steps to be created or when the construction process
    involves numerous parameters.*/
    private String foundation;
    private String walls;
    private String roof;
    private boolean swimmingPool;
    private boolean garden;
    private boolean garage;

    public House(String foundation, String walls, String roof, boolean swimmingPool, boolean garden, boolean garage) {
        this.foundation = foundation;
        this.walls = walls;
        this.roof = roof;
        this.swimmingPool = swimmingPool;
        this.garden = garden;
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", walls='" + walls + '\'' +
                ", roof='" + roof + '\'' +
                ", swimmingPool=" + swimmingPool +
                ", garden=" + garden +
                ", garage=" + garage +
                '}';
    }
}
