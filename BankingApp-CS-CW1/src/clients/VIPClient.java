package clients;

import bank.BankAccount;

import java.math.BigDecimal;

public class VIPClient extends Client{
    public VIPClient(BankAccount bankAccount, String clientID, String name, double amount) {
        super(bankAccount, clientID, name, amount);
    }

    @Override
    public void run() {
        System.out.println("****:::VIP Clients:::****");

        //try to deposit money to account
        bankAccount.depositMoney(BigDecimal.valueOf(amount));
        bankAccount.getBalance();
        bankAccount.withdrawMoney(BigDecimal.valueOf(amount));

    }

}
