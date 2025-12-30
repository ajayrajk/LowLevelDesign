package org.solid.principle.structural.bridgedesign.withbridge;

public class WindowDrawingAPI implements DrawingAPI{


    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle in windows");
    }

}
