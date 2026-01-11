package org.designpattern.creational.abstractfactory;

public class AbstractFactoryDemo {

    /*The Abstract Factory pattern provides an interface for creating families of related
    or dependent objects without specifying their concrete classes. It allows the creation
    of objects that are compatible with each other based on the chosen factory
    implementation. This pattern is useful for systems that need to be independent of
    how their products are created.*/
    public static void main(String[] args) {
        String osType="windows";
        Button btn;
        CheckBox cb;
        if (osType.equalsIgnoreCase("windows")){
            btn=new WindowsButton();
            cb=new WindowsCheckBox();
        }else {
            btn = new MacButton();
            cb = new MacCheckBox();
        }

        btn.render();;
        cb.render();

    }
}
