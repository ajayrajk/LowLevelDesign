package org.designpattern.structural.facadedesign;

public class SurroundSound {

    public void on() {
        System.out.println("Surround Sound ON");
    }
    public  void setVolume(int level) {
        System.out.println("Volume set to " + level);
    }
    public void off() {
        System.out.println("Surround Sound OFF");
    }
}
