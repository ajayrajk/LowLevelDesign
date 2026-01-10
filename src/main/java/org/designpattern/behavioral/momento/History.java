package org.designpattern.behavioral.momento;

import java.util.Stack;

public class History {
    private Stack<EditorMemento> history=new Stack<>();

    public void save(TextEditor editor){
        history.push(editor.save());
    }

    public void undo(TextEditor editor){
        if (!history.isEmpty()){
            editor.restore(history.pop());
        }
    }
}
