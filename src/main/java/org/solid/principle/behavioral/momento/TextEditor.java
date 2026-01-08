package org.solid.principle.behavioral.momento;

public class TextEditor {
    private String text;

    public void write(String nextText){
        this.text=nextText;
    }

    public String getText() {
        return text;
    }

    public EditorMemento save(){
        return  new EditorMemento(text);
    }

    public void restore(EditorMemento memento){
        this.text=memento.getShavedState();
    }
}
