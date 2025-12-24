package org.solid.principle.creational.builder;

public class House {
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
