package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByFirstCharacter34 {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("apple","banana","avocado","blueberry","cherry");

        Map<Character,List<String>> groupByFirstChar=words.stream()
                .collect(Collectors.groupingBy(word->word.charAt(0)));

        System.out.println(groupByFirstChar);
    }
}
