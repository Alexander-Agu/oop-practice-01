import Accounts.Account;
import Accounts.CheckingAccount;
import Accounts.SavingsAccount;
import Customers.Customer;

import java.util.ArrayList;
import java.util.Random;

public class BankingService {
    private ArrayList<Customer> customers = new ArrayList<>();

    public BankingService(){

    }


    // Methods
    public Customer createCustomers(String name){
        Customer customer = new Customer(name);
        customers.add(customer);
        return customer;
    }


    public void createAccount(String customerId, String type){
        Customer customer = findCustomer(customerId);
        String accountNumber = createAccountNumber();

        // Checking if they are trying to create a valid account
        Account account = null;
        if (type.equalsIgnoreCase("savings")) account = new SavingsAccount(accountNumber, 200000);
        if (type.equalsIgnoreCase("checking")) account = new CheckingAccount(accountNumber, 200000);


        // Only save accounts if both the customer and account are found
        if (customer != null && account != null) customer.addAccount(account);
    }


    public  void deposit(String customerId, String accountNumber, int amount){
        Customer customer = findCustomer(customerId);
        Account account = customer != null ? findAccount(customer, accountNumber) : null;

        if (customer != null) { // Only if customer is found get the account
            for (Account acc : customer.getAccounts()) {
                if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) account = acc;
            }
        }


        if (account != null){ // If account is found ... deposit
            account.deposit(amount);
        }
    }


    public void withdraw(String customerId, String accountNumber, int amount){
        Customer customer = findCustomer(customerId);
        Account account = customer != null ? findAccount(customer, accountNumber) : null;


        if(account != null){
            if (account.getBalance() >= amount){ // customer can only withdraw if their balance is >= to amount
                account.withDraw(amount);
            }
        }
    }



    public void transfer(String customerIdFrom, String accFrom, String customerIdTo, String accTo, int amount){
        Customer customerFrom = findCustomer(customerIdFrom);
        Customer customerTo = findCustomer(customerIdTo);

        Account accountFrom = customerFrom != null ? findAccount(customerFrom, accFrom) : null;
        Account accountTo = customerTo != null ? findAccount(customerTo, accTo) : null;

        if (accFrom != null && accTo != null){ // Only deposit if balance is >= amount
            if (accountFrom.getBalance() >= amount){
                accountTo.deposit(amount);
                accountFrom.withDraw(amount);
            }
        }
    }

    public void printCustomerAccount(String customerId){
        Customer customer = findCustomer(customerId);

        if (customer != null){
            for (Account account: customer.getAccounts()){
                account.displayInfo();
            }
        }
    }


    private Customer findCustomer(String customerId){
        Customer customer = null;

        // Search for customer
        for (Customer cus: customers){
            if (cus.getCustomerId().equalsIgnoreCase(customerId)) customer = cus;
        }

        return customer;
    }


    private Account findAccount(Customer customer, String accountNumber){
        for (Account acc : customer.getAccounts()) {
            if (accountNumber.equalsIgnoreCase(acc.getAccountNumber())) return acc;
        }

        return  null;
    }


    private String createAccountNumber(){
        Random random = new Random();

        String accountNumber = "";

        for (int x = 0; x<= 10; x++){
            int randomNum = random.nextInt(10);
            accountNumber += "" + randomNum;
        }

        return accountNumber;
    }



}
