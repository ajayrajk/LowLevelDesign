package org.java8;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordInSentence31 {

    public static void main(String[] args) {
        String sentence="Java Stream API is very powerful";

        String longestWord= Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println(longestWord);
    }
}
