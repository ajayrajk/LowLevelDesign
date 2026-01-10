package org.designpattern.creational.abstractfactory.withAF;

import org.designpattern.creational.abstractfactory.Button;
import org.designpattern.creational.abstractfactory.CheckBox;

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
