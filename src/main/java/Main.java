import Customers.Customer;

public class Main {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();

        Customer alex = bankingService.createCustomers("Alex");
        bankingService.createAccount(alex.getCustomerId(), "savings");


        Customer tumi = bankingService.createCustomers("tumi");
        bankingService.createAccount(tumi.getCustomerId(), "checking");
//        bankingService.printCustomerAccount(tumi.getCustomerId());

        bankingService.deposit(alex.getCustomerId(), alex.getAccounts().get(0).getAccountNumber(), 5000);
//        bankingService.printCustomerAccount(alex.getCustomerId());
        bankingService.withdraw(alex.getCustomerId(), alex.getAccounts().get(0).getAccountNumber(), 999);
//        bankingService.printCustomerAccount(alex.getCustomerId());


        bankingService.transfer(alex.getCustomerId(), alex.getAccounts().get(0).getAccountNumber(), tumi.getCustomerId(), tumi.getAccounts().getFirst().getAccountNumber(), 200000);
        bankingService.printCustomerAccount(alex.getCustomerId());
        System.out.println("");
        bankingService.printCustomerAccount(tumi.getCustomerId());
    }
}
