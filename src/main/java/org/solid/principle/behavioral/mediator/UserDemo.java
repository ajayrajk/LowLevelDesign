package org.solid.principle.behavioral.mediator;

public class UserDemo {

    public static void main(String[] args) {
        User john=new User("John");
        User jane=new User("Jane");
        User bob=new User("Bob");
        john.sendMessage(jane,"Hi Jane...");
        jane.sendMessage(bob,"Hi Bob..");
    }
}
