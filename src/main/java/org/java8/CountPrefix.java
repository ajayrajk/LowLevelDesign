package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountPrefix {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Alice","Bob","Rajput","Kamal","Rohit","Sachin","Ajay");

        System.out.println(names.stream().filter(s->s.startsWith("A")).collect(Collectors.toList()));
        System.out.println(names.stream().filter(s->s.startsWith("R")).collect(Collectors.toList()));

    }
}
