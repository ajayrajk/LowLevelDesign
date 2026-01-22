package org.java8;

import java.util.Arrays;
import java.util.List;

public class CalculateAverage18 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,20,30,40,50);

        double average=list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println(average);


    }
}
