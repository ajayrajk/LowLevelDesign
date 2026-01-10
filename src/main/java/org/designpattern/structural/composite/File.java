package org.designpattern.structural.composite;

import java.awt.desktop.SystemEventListener;

public class File {

     String name;

    public File(String name) {
        this.name = name;
    }

    void showDetails(){
        System.out.println("File :"+name);
    }
}
