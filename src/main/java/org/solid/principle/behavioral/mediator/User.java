package org.solid.principle.behavioral.mediator;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(User to, String messages){
        System.out.println("Sending messages to "+to.name+" and the msg is "+messages);
    }

}
