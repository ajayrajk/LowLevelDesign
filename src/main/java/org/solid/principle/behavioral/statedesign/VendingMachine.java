package org.solid.principle.behavioral.statedesign;

public class VendingMachine {

    private String state="NO_COIN";

    public void insertCoin(){
        if (state.equals("NO_COIN")){
            System.out.println("Coin inserted");
        }else if (state.equals("HAS_COIN")){
            System.out.println("Coin is already inserted");
        }else if (state.equals("DISPENSING")){
            System.out.println("Waits, dispensing is in progress");
        }
    }
}
