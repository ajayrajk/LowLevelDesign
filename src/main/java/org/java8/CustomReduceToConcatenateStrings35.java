package org.java8;

import java.util.Arrays;
import java.util.List;

public class CustomReduceToConcatenateStrings35 {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("Stream","API","is","awesome");

        String reversedConcatenation=words.stream()
                .reduce((w1,w2)->w2+" "+w1)
                .orElse("");

        System.out.println(reversedConcatenation);

    }
}
