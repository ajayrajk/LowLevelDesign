package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomCollector16 {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("Java","Stream","API");

        String joined=words.stream()
                .collect(Collectors.joining(", ")).trim();
        System.out.println(joined);
    }
}
