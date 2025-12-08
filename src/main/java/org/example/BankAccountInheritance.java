package org.example;

public class BankAccountInheritance {

    String accountNumber;
    double balance;
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }


}

class SavingsAccount extends BankAccount {
    double interestRate;
    public void addInterest() {
        balance += balance * interestRate;
    }
}
