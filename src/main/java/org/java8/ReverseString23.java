package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString23 {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("Java","Stream","API");

        List<String> reverseWords=words.stream()
                .map(word->new StringBuilder(word).reverse().toString())
                .collect(Collectors.toList());

        System.out.println(reverseWords);
    }
}
