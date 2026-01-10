package org.solidprinciple.srp;


//Bad Code
public class Employee {
    private int empId;
    private String name;
    private double salary;
    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
    // Business logic
    public double calculateSalary() {
        return salary * 1.1; // add 10% bonus
    }
    // Persistence
    public void saveToDatabase() {
        System.out.println("Saving " + name + " to database...");
    }
    // Reporting
    public void generateReport() {
        System.out.println("Employee Report: " + name + ", Salary: " + salary);
    }
}
