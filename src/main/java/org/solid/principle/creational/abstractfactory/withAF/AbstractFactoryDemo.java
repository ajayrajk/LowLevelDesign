package org.solid.principle.creational.abstractfactory.withAF;

import org.solid.principle.creational.abstractfactory.Button;
import org.solid.principle.creational.abstractfactory.CheckBox;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        UIFactory uiFactory;
        String osType="mac";
        if (osType.equalsIgnoreCase("windows")){
            uiFactory=new WindowsFactory();
        }else {
            uiFactory=new MacFactory();
        }
        Button btn= uiFactory.createButton();
        CheckBox cb= uiFactory.createCheckBox();
        btn.render();
        cb.render();
    }
}
