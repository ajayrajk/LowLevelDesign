package org.designpattern.behavioral.statedesign.withstate;


public class NoCoinState implements State{
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    @Override
    public void dispense() {
        System.out.println("Please insert coin first");

    }
}
