public class BankAccount {

    // bank account class is the acting monitor class
    /*
    * It consist of 2 main properties and 3 operations.
    * properties
    * account number  (-)
    * Balance (-)
    *
    * constructor, getBalance , depositMoney(), withdrawMoney()
    *
    * */
    private String accountNumber;

    //this var may get changed frequently
    private volatile double balance;

    //constructor

    public BankAccount(String accountNumber, double balance) {
        super();
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //getters - setters


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
