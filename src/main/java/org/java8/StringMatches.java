package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringMatches {

    public static void main(String[] args) {
        List<String> strList= Arrays.asList("Java Persistent API", "Stream API","Lambda");
        boolean isAvailable=strList.stream().anyMatch(s->s.contains("API"));

        System.out.println(isAvailable);

        System.out.println(strList.stream().filter(s->s.contains("API")).collect(Collectors.toList()));

    }
}
