package bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    //    test case 01 - Create a Bank account
    @Test
    public void BankAccountCreateTest() {
        BankAccount bankAccount = new BankAccount("000000", 1000.00);
    }

    //    test case 01_A - Creating account without account number
    @Test
    public void bankAccountCreateWithoutACCNo() {
        assertThrows(RuntimeException.class, () -> new BankAccount("", 1000.00));
    }

    //    test case 01_B - Creating account without a balance
    @Test
    public void bankAccountCreateWithoutBalance() {
        assertThrows(RuntimeException.class, () -> new BankAccount("1234", 0));
    }

    @org.junit.jupiter.api.Test
    void getAccountNumber() {
    }

    @org.junit.jupiter.api.Test
    void setAccountNumber() {
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
    }

    @org.junit.jupiter.api.Test
    void setBalance() {
    }

    @org.junit.jupiter.api.Test
    void depositMoney() {
//        Verify weather the bank deposit updated successfully
        BankAccount bankAccount = new BankAccount("000000", 1000.00);

        bankAccount.depositMoney(BigDecimal.valueOf(500));

        assertEquals(BigDecimal.valueOf(1500),bankAccount.getBalance());


    }

//    test case 06_A - Verify weather a negative or zero amount can be deposited
    @Test
    public void depositLowMoneyTest() {
        BankAccount bankAccount = new BankAccount("000000", 1000.00);
        assertThrows(RuntimeException.class, ()-> bankAccount.depositMoney(BigDecimal.valueOf(0)));
        assertThrows(RuntimeException.class, ()-> bankAccount.depositMoney(BigDecimal.valueOf(-100)));
    }

    //        test 07 - Verify weather the bank withdraws updated successfully

    @org.junit.jupiter.api.Test
    void withdrawMoney() {
        BankAccount bankAccount = new BankAccount("000000", 1000.00);

        //withdraw 500 from an account
        bankAccount.withdrawMoney(BigDecimal.valueOf(500));

        assertEquals(BigDecimal.valueOf(500),bankAccount.getBalance());

    }
}