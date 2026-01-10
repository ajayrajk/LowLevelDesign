package org.designpattern.behavioral.command;

public class CommandDemo {

    public static void main(String[] args) {
        Light light=new Light();

        RemoteControl remoteControl=new RemoteControl();
        remoteControl.presButton("on",light);
        remoteControl.presButton("off",light);

    }
}
