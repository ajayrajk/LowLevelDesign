package org.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    String  name;
    List<File> files=new ArrayList<>();
    List<Folder> subFolder=new ArrayList<>();
    public Folder(String name) {
        this.name = name;
    }

    void add(File file){
        files.add(file);
    }

    void addFolder(Folder folder){
        this.subFolder.add(folder);
    }

    void showDetails(){
        System.out.println("Folder :"+name);
        for (File f:files){
                f.showDetails();
        }
        for (Folder sf:subFolder){
            sf.showDetails();
        }
    }
}
