package org.concurrency.ch4;

import java.util.ArrayList;
import java.util.List;

public class SafeList<T> {
    private final List<T>  list=new ArrayList<>();

    private synchronized  boolean putIfAbsent(T t){
        if(!list.contains(t)) {
            list.add(t);
            return true;
        }
        return false;
    }
}
