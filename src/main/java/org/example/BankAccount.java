package org.example;

public class BankAccount {

    //Attributes
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount>0){
            this.balance+=amount;
        }
    }

    public void withdraw(double amount){
        if(amount>0 && amount<this.balance){
            this.balance-=amount;
        }
    }

    public double getBalance(){
        return this.balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public class Main{
        public static void main(String[] args) {
            // Creating objects (instances) of the BankAccount class
            BankAccount myAccount = new BankAccount("123456", 500.00);
            BankAccount anotherAccount = new BankAccount("654321", 300.00);
            // Using methods on the objects
            myAccount.deposit(150.00);
            myAccount.withdraw(50.00);
            System.out.println("Balance in myAccount: " +
                    myAccount.getBalance()); // Output: 600.00
            anotherAccount.withdraw(100.00);
            System.out.println("Balance in anotherAccount: " +
                    anotherAccount.getBalance()); // Output: 200.00
        }
    }
}
