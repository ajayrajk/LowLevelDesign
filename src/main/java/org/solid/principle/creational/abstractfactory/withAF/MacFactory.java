package org.solid.principle.creational.abstractfactory.withAF;

import org.solid.principle.creational.abstractfactory.Button;
import org.solid.principle.creational.abstractfactory.CheckBox;
import org.solid.principle.creational.abstractfactory.MacButton;
import org.solid.principle.creational.abstractfactory.MacCheckBox;

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
