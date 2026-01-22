package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RemoveNull17 {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("Java", null,"Stream",null,"API");

        List<String> removeNullWords=words.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        System.out.println(removeNullWords);
    }
}
