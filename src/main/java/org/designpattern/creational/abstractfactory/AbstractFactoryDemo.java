package org.designpattern.creational.abstractfactory;

public class AbstractFactoryDemo {
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
