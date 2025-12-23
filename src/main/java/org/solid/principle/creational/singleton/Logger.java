package org.solid.principle.creational.singleton;

public class Logger {

    private String url;
    public void log(String message){
        System.out.println("[LOG] "+message);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
