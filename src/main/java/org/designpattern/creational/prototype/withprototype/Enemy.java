package org.designpattern.creational.prototype.withprototype;

public class Enemy implements ProtoType{
    private String type;
    private int health;
    private String weapon;

    public Enemy(String type, int health, String weapon) {
        this.type = type;
        this.health = health;
        this.weapon = weapon;
    }

    @Override
    public ProtoType clone() {
        try {
            return (ProtoType) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("Cloning not supported "+e);
        }
    }
}
