package org.java8;

import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentChar26 {

    public static void main(String[] args) {
        String input="success";

        char mostFrequent=input.chars()
                .mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();

        System.out.println(mostFrequent);
    }
}
