package org.designpattern.creational.prototype.withprototype;

public class ProtoTypeDemo {

    public static void main(String[] args) {
        Enemy baseOrc=new Enemy("Orc",100,"Axe");

        Enemy orc1=(Enemy)baseOrc.clone();
        Enemy orc2=(Enemy)baseOrc.clone();

        System.out.println(orc1.clone());

        System.out.println(orc2.toString());

    }
}
