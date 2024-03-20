package bank;

import java.math.BigDecimal;

public class BankAccount {

    // bank account class is the acting monitor class
    //which means it does not to anything on its own
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

    //this var may get changed frequently, so we add it as volatile
    private volatile BigDecimal balance;

    //constructor
    public BankAccount(String accountNumber, double balance) {
        super(); //super kw is added automatically
        //check weather all details are availble to create a bank account

        if (accountNumber.isEmpty()) {
            throw new RuntimeException("Please Enter an Account Number");
        }
        if (String.valueOf(balance).isEmpty() || balance == 0) {
            throw new RuntimeException("Please Enter a value for Initial Balance”");
        }
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal(balance);

    }

    //methods that are working with a critical section are added as sync methods using synchronized keyword
    //getters - setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public synchronized BigDecimal getBalance() {
        System.out.println("Current Balance:" + balance);
        return balance;
    }

    public synchronized void setBalance(double balance) {
        this.balance = BigDecimal.valueOf(balance);
    }

    // these are the basic functionalities that are supported by my banking app

    //regular client deposit
    public synchronized void depositMoney(BigDecimal amount) {
        //if the amount is greater than 0 only, then we allow the transaction
        if (amount.intValue() > 0) {
            //we should update the balance
            BigDecimal amountTobeAdded = new BigDecimal(amount.intValue());
            balance = balance.add(amountTobeAdded);

            System.out.println(Thread.currentThread().getName() + ", After Deposit Account Balance " + balance);

        }else {
            throw new RuntimeException("Amount cannot be less than or equal to 0");
        }
    }

    public synchronized void withdrawMoney(BigDecimal amount) {
        //if the amount is greater than 0 only, then we allow the transaction
        if (amount.doubleValue() <= balance.doubleValue()) {
            //we should update the balance
            BigDecimal amountTobeRemoved = new BigDecimal(amount.intValue());
            balance = balance.subtract(amountTobeRemoved);

            System.out.println(Thread.currentThread().getName() + ", After Withdraw Account Balance " + balance);

        }else {
            throw new RuntimeException("Transaction Could’nt be Proceeded due to Low account balance ");

        }
    }


}
