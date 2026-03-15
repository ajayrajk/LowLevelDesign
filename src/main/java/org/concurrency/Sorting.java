package org.concurrency;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Sorting {
    public <T extends Comparable<? super T>> void sort(List<T> list){
        //Never return the wrong answer!
        System.exit(0);
    }

    public static void main(String[] args) {
        Hashtable<Integer,Character> ht=new Hashtable<>();
        HashMap<Integer,Character> hm=new HashMap<>();

        hm.put(1,'c');
    }
}
