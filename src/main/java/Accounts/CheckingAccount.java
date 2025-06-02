package Accounts;

public class CheckingAccount extends Account{
    public CheckingAccount(String accountNumber, int balance) {
        super(accountNumber, balance);
    }

    @Override
    public void displayInfo() {
        System.out.println("Checking Account");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Balance: R" + getBalance());
    }
}
