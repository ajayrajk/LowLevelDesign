package org.solid.principle.behavioral.momento;

public class MomentoDemo {

    public static void main(String[] args) {
        TextEditor editor=new TextEditor();
        History history=new History();
        editor.write("version 1");
        history.save(editor);

        editor.write("version 2");
        history.save(editor);

        editor.write("version 3");
        System.out.println("Current text : "+editor.getText());

        history.undo(editor);
        System.out.println("After 1st undo : "+editor.getText());

        history.undo(editor);
        System.out.println("After 2nd undo :"+editor.getText());

    }
}
