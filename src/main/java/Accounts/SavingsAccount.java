package Accounts;

public class SavingsAccount extends Account{
    public SavingsAccount(String accountNumber, int balance) {
        super(accountNumber, balance);
    }

    @Override
    public void displayInfo() {
        System.out.println("Savings Account");
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Balance: R" + getBalance());
    }
}
