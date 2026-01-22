package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsLen10 {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("Java","Stream","API","Code","Fun");

        Map<Integer,List<String>> groupingByLength=words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupingByLength);
    }
}
