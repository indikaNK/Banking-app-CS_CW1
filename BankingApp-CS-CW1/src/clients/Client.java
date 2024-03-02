package clients;

import bank.BankAccount;

//This class is responsible to implement common attributes and methods for both regular and VIP clients
public class Client implements Runnable {


    // all clients should have a client ID and a name,age and amount
    // client default has a transaction limit up to 200,000.
    // VIP clients get max priority over other clients
    // age does not considered as a strong fact in proceeding with transactions

    //Bank account instance for calling the methods
    protected final BankAccount bankAccount;

    protected final double DEFAULT_LIMIT = 200000;
    protected String clientID;
    protected String name; //client name
    protected double amount;

    //constructor
    public Client(BankAccount bankAccount, String clientID, String name, double amount) {
        this.bankAccount = bankAccount;
        this.clientID = clientID;
        this.name = name;
        this.amount = amount;
    }


    @Override
    public void run() {
        System.out.println("You Executed Main-clients.Client ");


    }
}
