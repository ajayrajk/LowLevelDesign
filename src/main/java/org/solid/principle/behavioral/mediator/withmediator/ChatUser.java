package org.solid.principle.behavioral.mediator.withmediator;

public class ChatUser extends User{
    public ChatUser(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    void send(String message) {
        //chatMediator.sendMessage(message,this);
    }

    @Override
    void receive(String message) {
        System.out.println("Received message "+message);
    }
}
