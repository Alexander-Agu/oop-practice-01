package Customers;

import Accounts.Account;

import java.util.ArrayList;

public class Customer {
    private String name;
    private  String customerId;
    private ArrayList<Account> accounts = new ArrayList<>();

    private static int count = 0;

    public Customer(String name){
        count++;
        this.customerId = "" + count;
        this.name = name;
    }

    // METHODS
    public  void addAccount(Account account){
        accounts.add(account);
    }


    public ArrayList<Account> getAccounts(){
        return accounts;
    }


    public String getName() {
        return name;
    }


    public String getCustomerId() {
        return customerId;
    }
}
