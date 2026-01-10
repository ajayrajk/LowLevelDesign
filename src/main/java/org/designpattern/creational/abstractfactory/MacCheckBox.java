package org.designpattern.creational.abstractfactory;

public class MacCheckBox implements CheckBox{

    @Override
    public void render() {
        System.out.println("Rendering checkbox button");
    }
}
