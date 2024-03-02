import bank.BankAccount;
import clients.RegularClient;
import clients.VIPClient;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //create a bank account Object for regular clients
        BankAccount bankAccount1 = new BankAccount("00001",0);
        BankAccount bankAccount2 = new BankAccount("00002",0);
        BankAccount bankAccount3 = new BankAccount("00003",0);
        BankAccount bankAccount4 = new BankAccount("00004",0);
        BankAccount bankAccount5 = new BankAccount("00005",0);
        BankAccount bankAccount6 = new BankAccount("00006",0);
        BankAccount bankAccount7 = new BankAccount("00007",0);
        BankAccount bankAccount8 = new BankAccount("00008",0);
        BankAccount bankAccount9 = new BankAccount("00009",0);
        BankAccount bankAccount10 = new BankAccount("00010",0);
        //Create a runnable Object

        Runnable run_obj1 = new RegularClient(bankAccount1,"c1","Asiri", 20000 );
        Runnable run_obj2 = new RegularClient(bankAccount2,"c2","Bandara", 30000 );
        Runnable run_obj3 = new RegularClient(bankAccount3,"c3","Chanka", 40000 );
        Runnable run_obj4 = new RegularClient(bankAccount4,"c4","Damitha", 10000 );
        Runnable run_obj5 = new RegularClient(bankAccount5,"c5","Earl", 5000 );
        Runnable run_obj6 = new RegularClient(bankAccount6,"c6","Fathima", 20000 );
        Runnable run_obj7 = new RegularClient(bankAccount7,"c7","Gayan", 30000 );
        Runnable run_obj8 = new RegularClient(bankAccount8,"c8","Harsha", 50000 );
        Runnable run_obj9 = new RegularClient(bankAccount9,"c9","Indika", 20000 );
        Runnable run_obj10 = new RegularClient(bankAccount10,"c10","Jason", 1000 );

        Runnable run_objVIP1 = new VIPClient(bankAccount2,"c2","Bandara", 20000 );

        //create a thread group for  Regular clients and VIP clients
        ThreadGroup regularsGroup = new ThreadGroup("RegularGroup");
        ThreadGroup vipGroup = new ThreadGroup("VIPGroup");


        //create a 2 thread Arrays for storing 10 and Regular clients and 10 vips
        Thread[] regularArray = new Thread[10];
        Thread[] vipArray = new Thread[10];

        //Assign Regulars to regularsArray
        regularArray[0] =  new Thread(regularsGroup,run_obj1,"Asiri");
        regularArray[1] =  new Thread(regularsGroup,run_obj2,"Bandara");
        regularArray[2] =  new Thread(regularsGroup,run_obj3,"Chanaka");
        regularArray[3] =  new Thread(regularsGroup,run_obj4,"Damitha");
        regularArray[4] =  new Thread(regularsGroup,run_obj5,"Earl");
        regularArray[5] =  new Thread(regularsGroup,run_obj6,"Fathima");
        regularArray[6] =  new Thread(regularsGroup,run_obj7,"Gayan");
        regularArray[7] =  new Thread(regularsGroup,run_obj8,"Harsha");
        regularArray[8] =  new Thread(regularsGroup,run_obj9,"Indika");
        regularArray[9] =  new Thread(regularsGroup,run_obj10,"Jason");


        for (Thread t:regularArray
             ) {
            t.start();
        }


//        vipArray[0] =  new Thread(vipGroup,run_objVIP1,"Bandara");
//        vipArray[0].start();








        //create a thread for Asiri (RC)
//        Thread client_Asiri = new Thread(run_obj1,"Client-Asiri");
//        Thread client_Bandara = new Thread(run_obj2,"VIP Client-Bandara");
//        client_Bandara.start();
//        client_Asiri.start();

    }
}