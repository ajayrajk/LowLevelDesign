package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateWithoutCollector25 {

    public static void main(String[] args) {
        List<Integer>  numbers= Arrays.asList(1,2,3,2,4,3,5);

        List<Integer> uniqueNumber=numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueNumber);

    }
}
