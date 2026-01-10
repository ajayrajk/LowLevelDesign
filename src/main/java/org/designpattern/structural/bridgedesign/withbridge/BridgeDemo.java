package org.designpattern.structural.bridgedesign.withbridge;

public class BridgeDemo {

    public static void main(String[] args) {
        Shape circle1=new Circle(new WindowDrawingAPI(),10,10,5);
        Shape circle2=new Circle(new LinuxDrawingAPI(),10,10,5);

        circle1.draw();
        circle2.draw();

    }
}
