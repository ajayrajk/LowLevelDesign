package org.designpattern.creational.abstractfactory.withAF;

import org.designpattern.creational.abstractfactory.Button;
import org.designpattern.creational.abstractfactory.CheckBox;
import org.designpattern.creational.abstractfactory.MacButton;
import org.designpattern.creational.abstractfactory.MacCheckBox;

public class MacFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }


    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }

}
