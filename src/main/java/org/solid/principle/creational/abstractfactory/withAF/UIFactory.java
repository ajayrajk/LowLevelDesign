package org.solid.principle.creational.abstractfactory.withAF;

import org.solid.principle.creational.abstractfactory.Button;
import org.solid.principle.creational.abstractfactory.CheckBox;

public interface UIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
