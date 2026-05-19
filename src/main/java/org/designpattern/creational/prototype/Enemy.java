package org.designpattern.creational.prototype;

public class Enemy {
    private String type;
    private int health;
    private String weapon;

    public Enemy(String type, int health, String weapon) {
        this.type = type;
        this.health = health;
        this.weapon = weapon;
    }

    //Expensive operations here lots of DB calls
    //(its common operation and not an enemy operation
}
