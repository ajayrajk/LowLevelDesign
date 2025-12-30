package org.solid.principle.structural.composite.withComposite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem{
    private String name;

    private List<FileSystem> contents=new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    void add(FileSystem fs){
        contents.add(fs);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder name: "+name);
        for (FileSystem fileSystem: contents){
            fileSystem.showDetails();
        }
    }
}
