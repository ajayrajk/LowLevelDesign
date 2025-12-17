package org.solid.principle.srp.withsrp;

// Reporting responsibility
class EmployeeReport {
    public void generateReport(Employee employee) {
        System.out.println("Employee Report: " + employee.getName() +
                ", Salary: " + employee.getSalary());
    }
}