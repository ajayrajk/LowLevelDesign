package org.designpattern.behavioral.command;

public class RemoteControl {

    void presButton(String  action, Light light){
         if (action.equals("on")){
             light.on();
         }else {
             light.off();
         }
    }
}
