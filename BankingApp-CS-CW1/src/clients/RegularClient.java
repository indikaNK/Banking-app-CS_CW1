package clients;

import bank.BankAccount;

import java.math.BigDecimal;

public class RegularClient extends Client{
    public RegularClient(BankAccount bankAccount,String clientID, String name, double amount) {
        super(bankAccount, clientID, name, amount);
    }


    // constructor


    // run method overriding allow to use specific cases for different type of clients
    @Override
    public void run() {
        System.out.println(":::Regular Clients:::");

        // check transaction amount exceeds the limit
        if( amount > super.DEFAULT_LIMIT){
            System.out.println("Sorry ! This Transaction cannot be proceed of It Exceed The Max Limit LKR. "+super.DEFAULT_LIMIT);
        }else {
           //try to deposit money to account
            bankAccount.depositMoney(BigDecimal.valueOf(amount));
            bankAccount.getBalance();
            // try to withdraw money
            bankAccount.withdrawMoney(BigDecimal.valueOf(amount));
        }

    }
}
