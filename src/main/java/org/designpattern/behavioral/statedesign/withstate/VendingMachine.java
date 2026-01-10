package org.designpattern.behavioral.statedesign.withstate;

public class VendingMachine {

    private State noCoinState;
    private State hasCoinState;
    private State currentState;

    public VendingMachine() {
        this.noCoinState = new NoCoinState(this);
        this.hasCoinState = new HasCoinState(this);
        this.currentState = new NoCoinState(this);
    }

    public void setState(State state) {
        this.currentState=state;
    }

    public State getNoCoinState(){
        return  noCoinState;
    }

    public State getHasCoinState(){
        return  hasCoinState;
    }

    public void insertCoin(){
        currentState.insertCoin();
    }

    public void dispense(){
        currentState.dispense();
    }

}
