package org.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NHighestScoringStudents33 {

    public static void main(String[] args) {

        List<Student> students=Arrays.asList(
                new Student("Alice",85),
                new Student("Bob",92),
                new Student("Charlie",88),
                new Student("Dave",78),
                new Student("Eve",91)
                );

        List<String> topStudents=students.stream()
                .sorted(Comparator.comparingInt((Student s)->s.score).reversed())
                .limit(3)
                .map(s->s.name)
                .collect(Collectors.toList());

        System.out.println(topStudents);

    }

   static class Student{
        String name;
        int score;
        Student(String name,int score){
            this.name=name;
            this.score=score;
        }
    }
}
