package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionStrByPalindrome29 {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("radar","level","java","stream");

        Map<Boolean,List<String>> partitioned=words.stream()
                .collect(Collectors.groupingBy(word->word.equals(new StringBuilder(word).reverse().toString())));

        System.out.println(partitioned);
    }
}
