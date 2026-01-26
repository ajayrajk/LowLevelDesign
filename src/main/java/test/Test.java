package test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    //Infosys
    public static void main(String[] args) {
        //1st approach
//        String str="ajay";
//
//        HashMap<Character,Integer> hm=new HashMap<>();
//
//        for (int i=0;i<str.length();i++){
//            char ch=str.charAt(i);
//            hm.put(ch,hm.getOrDefault(ch,0)+1);
//        }
//        int res=0;
//        char ch=' ';
//        for (Map.Entry<Character,Integer> entry: hm.entrySet()){
//              if (entry.getValue()>res){
//                  res=entry.getValue();
//                  ch= entry.getKey();
//              }
//        }
//
//        System.out.println("char :"+ ""+ch +"value :"+res);

        //Second approach
        String str = "ajay";

        Map.Entry<Character, Long> result =
                str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .get();

        System.out.println("char: " + result.getKey() + " value: " + result.getValue());




    }
}
