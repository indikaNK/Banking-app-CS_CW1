import bank.BankAccount;
import clients.RegularClient;
import clients.VIPClient;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //create a bank account Object
        BankAccount bankAccount1 = new BankAccount("00001",0);
        BankAccount bankAccount2 = new BankAccount("00002",0);
        //Create a runnable Object
        Runnable run_obj1 = new RegularClient(bankAccount1,"c1","Asiri", 20000 );
        Runnable run_obj2 = new VIPClient(bankAccount2,"c2","Bandara", 20000 );

        //create a thread for Asiri (RC)
        Thread client_Asiri = new Thread(run_obj1,"Client-Asiri");
        Thread client_Bandara = new Thread(run_obj2,"VIP Client-Bandara");
        client_Bandara.start();
        client_Asiri.start();

    }
}