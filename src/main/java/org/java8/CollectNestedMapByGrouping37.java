package org.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectNestedMapByGrouping37 {

    List<Employee> employees= Arrays.asList(
            new Employee("Alice","HR",25),
            new Employee("Bob","IT",30),
            new Employee("Charlie","HR",30),
            new Employee("Dave","IT",25)
    );

    Map<String,Map<Integer,List<String>>> grouped=employees.stream()
            .collect(Collectors.groupingBy(e->e.department,Collectors.groupingBy()))




    class Employee{
        String name, department;
        int age;
        public Employee(String name, String department, int age) {
            this.name = name;
            this.department = department;
            this.age = age;
        }
    }
}
