package org.basicoops.oops.inheritance;

public class InheritanceDemo {

    public static void main(String[] args) {
        Employee manager=new Manager();
        System.out.println("Manage salary "+ manager.calCalculateBonus());

        Employee employee=new Employee();
        System.out.println("Employee salary "+ employee.calCalculateBonus());

    }
}
