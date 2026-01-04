package org.solid.principle.behavioral.command.withcommand;

public class LightOffCommand implements Command{
    private Light light;


    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

}
