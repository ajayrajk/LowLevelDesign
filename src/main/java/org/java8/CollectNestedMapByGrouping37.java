package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectNestedMapByGrouping37 {


    public static void main(String[] args) {

        List<Employee> employees= Arrays.asList(
                new Employee("Alice","HR",25),
                new Employee("Bob","IT",30),
                new Employee("Charlie","HR",30),
                new Employee("Dave","IT",25)
        );

        Map<String,Map<Integer,List<String>>> grouped=employees.stream()
                .collect(Collectors.groupingBy(e->e.department,Collectors.groupingBy(e->e.age,
                        Collectors.mapping(e->e.name,Collectors.toList()))));

        System.out.println(grouped);

    }




   static class Employee{
        String name, department;
        int age;
        public Employee(String name, String department, int age) {
            this.name = name;
            this.department = department;
            this.age = age;
        }
    }
}
