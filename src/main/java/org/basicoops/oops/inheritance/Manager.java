package org.basicoops.oops.inheritance;

public class Manager extends Employee{

    @Override
    double calCalculateBonus() {
        return salary*0.20;
    }
}
