package org.designpattern.behavioral.statedesign.withstate;

public class HasCoinState implements State{

    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin is already inserted");
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing the product");
       vendingMachine.setState(vendingMachine.getNoCoinState());
    }
}
