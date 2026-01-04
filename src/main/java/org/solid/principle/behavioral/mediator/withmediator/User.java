package org.solid.principle.behavioral.mediator.withmediator;

abstract class User {
    protected ChatMediator chatMediator;
    protected String name;

    public User(ChatMediator chatMediator, String name) {
        this.chatMediator = chatMediator;
        this.name = name;
    }

    abstract void send(String message);
    abstract void receive(String  message);

}
