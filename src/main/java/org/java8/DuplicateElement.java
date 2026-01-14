package org.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElement {

    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,4,3,2,5,6);

        Set<Integer> unique=new HashSet<>();

        Set<Integer> duplicate= numbers.stream().filter(n->!unique.add(n))
                .collect(Collectors.toSet());

        System.out.println(duplicate);

     }
}
