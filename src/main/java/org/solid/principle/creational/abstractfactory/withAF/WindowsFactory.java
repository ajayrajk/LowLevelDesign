package org.solid.principle.creational.abstractfactory.withAF;

import org.solid.principle.creational.abstractfactory.Button;
import org.solid.principle.creational.abstractfactory.CheckBox;
import org.solid.principle.creational.abstractfactory.WindowsButton;
import org.solid.principle.creational.abstractfactory.WindowsCheckBox;

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
