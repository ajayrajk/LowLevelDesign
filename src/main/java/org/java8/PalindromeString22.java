package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromeString22 {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("radar","level","world","java");

        List<String> palindromes=words.stream()
                .filter(word->word.equals(new StringBuilder(word).reverse().toString()))
                .collect(Collectors.toList());

        System.out.println(palindromes);
    }

}
