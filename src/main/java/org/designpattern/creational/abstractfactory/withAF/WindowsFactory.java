package org.designpattern.creational.abstractfactory.withAF;

import org.designpattern.creational.abstractfactory.Button;
import org.designpattern.creational.abstractfactory.CheckBox;
import org.designpattern.creational.abstractfactory.WindowsButton;
import org.designpattern.creational.abstractfactory.WindowsCheckBox;

public class WindowsFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }


    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }

}
