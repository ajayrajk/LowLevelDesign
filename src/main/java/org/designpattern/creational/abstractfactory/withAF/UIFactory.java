package org.designpattern.creational.abstractfactory.withAF;

import org.designpattern.creational.abstractfactory.Button;
import org.designpattern.creational.abstractfactory.CheckBox;

public interface UIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
