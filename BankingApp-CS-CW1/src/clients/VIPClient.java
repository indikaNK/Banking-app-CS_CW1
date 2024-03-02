package clients;

import bank.BankAccount;

import java.math.BigDecimal;

public class VIPClient extends Client{
    public VIPClient(BankAccount bankAccount, String clientID, String name, double amount) {
        super(bankAccount, clientID, name, amount);
    }

    @Override
    public void run() {

        //try to deposit money to account
        bankAccount.depositMoney(BigDecimal.valueOf(1000));
        bankAccount.getBalance();
        bankAccount.withdrawMoney(BigDecimal.valueOf(500));

    }

}
