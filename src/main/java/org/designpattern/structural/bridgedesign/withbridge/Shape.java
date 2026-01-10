package org.designpattern.structural.bridgedesign.withbridge;

abstract public class Shape {

    protected DrawingAPI drawingAPI;

    public Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }
    //High level abstraction
    public abstract void draw();


}
