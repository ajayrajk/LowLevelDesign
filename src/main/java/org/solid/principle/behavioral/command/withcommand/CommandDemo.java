package org.solid.principle.behavioral.command.withcommand;

public class CommandDemo {

    public static void main(String[] args) {
        Light light=new Light();

        Command lightOn=new LightOffCommand(light);
        Command lightOff=new LightOnCommand(light);

        RemoteControl remoteControl=new RemoteControl();

        remoteControl.setCommand(lightOn);

        remoteControl.pressButton();

        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();


    }
}
