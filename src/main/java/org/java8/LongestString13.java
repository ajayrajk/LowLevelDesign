package org.java8;

import java.util.Arrays;
import java.util.List;

public class LongestString13 {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("Java","Stream","API","Development");

        String longest=words.stream()
                .reduce((word1,word2)->word1.length()>word2.length()?word1:word2)
                .orElse(null);

        System.out.println(longest);
    }
}
