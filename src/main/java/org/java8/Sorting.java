package org.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(4,2,45,23,56,34);
        System.out.println(numbers.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));

        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
