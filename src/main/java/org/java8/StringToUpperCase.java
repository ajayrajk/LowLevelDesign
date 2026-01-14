package org.java8;

import java.lang.invoke.CallSite;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToUpperCase {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Alice","Bob","Rajput","Kamal","Rohit","Sachin","Ajay");
         List<String> toUpper=names.stream().map(String::toUpperCase)
                 .collect(Collectors.toList());
        System.out.println(toUpper);
    }
}
