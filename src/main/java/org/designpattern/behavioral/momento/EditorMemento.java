package org.designpattern.behavioral.momento;

public class EditorMemento {
    private final String state;

    public EditorMemento(String state) {
        this.state = state;
    }

    public String getShavedState() {
        return this.state;
    }
}
