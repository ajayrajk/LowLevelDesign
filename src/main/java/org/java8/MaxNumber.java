package org.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MaxNumber {

    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(12,23,45,56,68,78,79,97);
        System.out.println(numbers.stream().max(Integer::compare).orElseThrow());
    }
}
