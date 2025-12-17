package org.solid.principle.srp.withsrp;

// Salary calculation responsibility
class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        return employee.getSalary() * 1.1;
    }
}




