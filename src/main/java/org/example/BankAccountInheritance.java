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

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void addInterest(double balance) {
        balance += balance * interestRate;
    }
}
