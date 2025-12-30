package org.solid.principle.structural.facadedesign;

public class FacadeDemo {

    public static void main(String[] args) {
        DVDPlayer dvdPlayer=new DVDPlayer();
        Projector projector=new Projector();
        SurroundSound surroundSound=new SurroundSound();

        dvdPlayer.on();
        projector.on();
        projector.setInput("DVD Player");

        surroundSound.on();
        surroundSound.setVolume(8);
        dvdPlayer.play("Inception");


    }
}
