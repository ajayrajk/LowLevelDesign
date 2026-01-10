package org.designpattern.behavioral.statedesign.withstate;

public class StateDesignDemo {

    public static void main(String[] args) {
        VendingMachine machine=new VendingMachine();

        machine.dispense();
        machine.insertCoin();
        machine.insertCoin();
        machine.dispense();
        machine.dispense();

    }
}
