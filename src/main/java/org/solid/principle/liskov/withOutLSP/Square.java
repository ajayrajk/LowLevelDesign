package org.solid.principle.liskov.withOutLSP;

import org.solid.principle.liskov.withOutLSP.Rectangle;

public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // forces height = width
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // forces width = height
    }
}
