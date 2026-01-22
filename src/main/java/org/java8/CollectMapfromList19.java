package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectMapfromList19 {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("Java","Stream","API");

        Map<String,Integer> wordLengthMap=words.stream()
                .collect(Collectors.toMap(word->word, String::length));

        System.out.println(wordLengthMap);
    }
}
