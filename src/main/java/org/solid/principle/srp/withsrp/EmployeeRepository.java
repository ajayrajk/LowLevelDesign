package org.solid.principle.srp.withsrp;

// Database responsibility
class EmployeeRepository {
    public void saveToDatabase(Employee employee) {
        System.out.println("Saving " + employee.getName() + " to database...");
    }
}