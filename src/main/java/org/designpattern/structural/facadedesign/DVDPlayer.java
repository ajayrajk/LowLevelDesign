package org.designpattern.structural.facadedesign;

public class DVDPlayer {

    public void on(){
        System.out.println("DVD player on");
    }

    public void off(){
        System.out.println("DVD Player off");
    }

   public void play(String movie){
        System.out.println("Playing movie :"+movie);
    }


}
