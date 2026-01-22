package org.java8;

import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequency14 {

    public static void main(String[] args) {
        String  str="development";

        Map<Character, Long> frequency=str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));


        System.out.println(frequency);
    }


}
