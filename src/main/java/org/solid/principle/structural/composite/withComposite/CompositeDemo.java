package org.solid.principle.structural.composite.withComposite;



public class CompositeDemo {
    public static void main(String[] args) {
        FileSystem file1 = new File("a.txt");
        FileSystem file2 = new File("b.png");
        Folder folder1 = new Folder("Documents");
        folder1.add(file1);
        folder1.add(file2);
        Folder root = new Folder("Home");
        root.add(folder1);
        root.showDetails();
    }
}
