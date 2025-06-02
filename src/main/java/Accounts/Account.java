package Accounts;

public abstract class Account {
    protected String accountNumber;
    protected int balance;

    public Account(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    // Methods
    public void deposit(int amount){
        this.balance += amount;
    }


    public void withDraw(int amount){
        this.balance -= amount;
    }


    public int getBalance(){
        return this.balance;
    }


    public String getAccountNumber(){
        return this.accountNumber;
    }

    public abstract void displayInfo();


}
