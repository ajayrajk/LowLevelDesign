package org.java8.features;

import java.util.List;

public class StreamAPI {
    /*Benefits:
    Cleaner code
    Parallel processing
    Lazy evaluation*/
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,5);

        nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(System.out::println);


    }
}
