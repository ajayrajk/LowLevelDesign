package org.java8;

import java.util.Arrays;
import java.util.List;

public class SumOfSquaresEvenNum28 {

    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6);

        int sumOfSquares=numbers.stream()
                .filter(n->n%2==0)
                .mapToInt(n->n*n)
                .sum();
        System.out.println(sumOfSquares);
    }
}
