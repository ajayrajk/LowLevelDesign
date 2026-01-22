package org.java8;

import java.util.Arrays;
import java.util.List;

public class ConcatenateStrings12 {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("Stream","API","is", "powerful");

        String concatenated=words.stream()
                .reduce("",(s1,s2)->s1+" "+s2).trim();

        System.out.println(concatenated);
    }
}
