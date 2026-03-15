package org.concurrency.ch3;

public class SafeInteger {

    private int number;

    public synchronized int getNumber() {
        return number;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }
}
