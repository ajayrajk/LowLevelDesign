package org.solid.principle.structural.facadedesign;

public class Projector {

    public void on(){
        System.out.println("Projector is on");
    }

    public void off(){
        System.out.println("Projector is off");
    }

    public  void setInput(String source){
        System.out.println("Project input source set to :"+source);
    }


}
