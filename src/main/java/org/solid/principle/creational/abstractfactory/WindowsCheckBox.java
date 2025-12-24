package org.solid.principle.creational.abstractfactory;

public class WindowsCheckBox implements CheckBox{
    @Override
    public void render() {
        System.out.println("Rendering Windows check box");
    }
}
