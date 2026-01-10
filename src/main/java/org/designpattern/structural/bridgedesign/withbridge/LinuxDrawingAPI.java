package org.designpattern.structural.bridgedesign.withbridge;

public class LinuxDrawingAPI implements DrawingAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
          System.out.println("Drawing circle in linux");
    }

}
