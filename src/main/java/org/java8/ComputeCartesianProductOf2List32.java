package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputeCartesianProductOf2List32 {

    public static void main(String[] args) {
        List<Integer> list1= Arrays.asList(1,2,3);
        List<Integer> list2=Arrays.asList(4,5);

        List<String> cartesianProduct=list1.stream()
                .flatMap(i->list2.stream().map(j->"("+i+","+j+")"))
                .collect(Collectors.toList());

        System.out.println(cartesianProduct);
    }
}
