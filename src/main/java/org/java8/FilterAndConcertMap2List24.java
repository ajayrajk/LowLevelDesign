package org.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterAndConcertMap2List24 {

    public static void main(String[] args) {
        Map<String, Integer> map=Map.of("A",5,"B",15,"C",10,"D",20);

        List<String> keys=map.entrySet().stream()
                .filter(entry->entry.getValue()>10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(keys);
    }
}
