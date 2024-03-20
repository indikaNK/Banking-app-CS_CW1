import bank.BankAccount;
import clients.RegularClient;
import clients.VIPClient;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
BankAccount bankAccount10 = new BankAccount("00010",0);

//        Create a 10 spaced array of bank account type
        BankAccount[] bankAccounts = new BankAccount[10];

//        Fill bank account array with automated bank accounts
        for (int i = 0; i < 10; i++) {
            String accountNumber = String.format("%05d", i + 1);
            BankAccount bankAccount = new BankAccount(accountNumber, 1000);
            bankAccounts[i] = bankAccount;

        }

//        display all bank accounts for regulars
//        for (int i = 0; i < bankAccounts.length; i++) {
//            System.out.println(bankAccounts[i].getAccountNumber());
//        }

        //Create a 10 spaced array of bank account type VIPs
        BankAccount[] bankAccountsVIP = new BankAccount[10];

//        Fill bank account array with automated bank accounts
        for (int i = 0; i < 10; i++) {
            String accountNumber = String.format("%05d", i + 1);
            BankAccount bankAccount = new BankAccount(accountNumber, 1000);
            bankAccountsVIP[i] = bankAccount;

        }
//        display all bank accounts for VIPs
//        for (int i = 0; i < bankAccountsVIP.length; i++) {
//
//            System.out.println(bankAccountsVIP[i].getAccountNumber());
//        }


        //Create a runnable Object
        Runnable run_obj1 = new RegularClient(bankAccounts[0], "c1", "Asiri", 20000);
        Runnable run_obj2 = new RegularClient(bankAccounts[1], "c2", "Bandara", 30000);
        Runnable run_obj3 = new RegularClient(bankAccounts[2], "c3", "Chanka", 40000);
        Runnable run_obj4 = new RegularClient(bankAccounts[3], "c4", "Damitha", 10000);
        Runnable run_obj5 = new RegularClient(bankAccounts[4], "c5", "Earl", 5000);
        Runnable run_obj6 = new RegularClient(bankAccounts[5], "c6", "Fathima", 20000);
        Runnable run_obj7 = new RegularClient(bankAccounts[4], "c7", "Gayan", 30000);
        Runnable run_obj8 = new RegularClient(bankAccounts[7], "c8", "Harsha", 50000);
        Runnable run_obj9 = new RegularClient(bankAccounts[8], "c9", "Indika", 20000);
        Runnable run_obj10 = new RegularClient(bankAccounts[9], "c10", "Jason", 1000);

        //Create a runnable Object for VIP clients
        Runnable run_objv1 = new VIPClient(bankAccountsVIP[0], "c11", "Omal", 20000);
        Runnable run_objv2 = new VIPClient(bankAccountsVIP[1], "c12", "Panduka", 30000);
        Runnable run_objv3 = new VIPClient(bankAccountsVIP[2], "c13", "Riyas", 40000);
        Runnable run_objv4 = new VIPClient(bankAccountsVIP[3], "c14", "Sanka", 10000);
        Runnable run_objv5 = new VIPClient(bankAccountsVIP[4], "c15", "Thusith", 5000);
        Runnable run_objv6 = new VIPClient(bankAccountsVIP[5], "c16", "Uma", 20000);
        Runnable run_objv7 = new VIPClient(bankAccountsVIP[6], "c17", "Vivek", 30000);
        Runnable run_objv8 = new VIPClient(bankAccountsVIP[7], "c18", "wasantha", 50000);
        Runnable run_objv9 = new VIPClient(bankAccountsVIP[8], "c19", "wasana", 20000);
        Runnable run_objv10 = new VIPClient(bankAccountsVIP[9], "c110", "Max", 1000);

        //create a thread group for  Regular clients and VIP clients
        ThreadGroup regularsGroup = new ThreadGroup("RegularGroup");
        ThreadGroup vipGroup = new ThreadGroup("VIPGroup");


        //create a 2 thread Arrays for storing 10 and Regular clients and 10 vips
        Thread[] regularArray = new Thread[10];
        Thread[] vipArray = new Thread[10];


        //Assign VIP to vipArray
        vipArray[0] = new Thread(vipGroup, run_objv1, "vip_Omal");
        vipArray[1] = new Thread(vipGroup, run_objv2, "vip_Panduka");
        vipArray[2] = new Thread(vipGroup, run_objv3, "vip_Riyas");
        vipArray[3] = new Thread(vipGroup, run_objv4, "vip_Sanka");
        vipArray[4] = new Thread(vipGroup, run_objv5, "vip_Thusith");
        vipArray[5] = new Thread(vipGroup, run_objv6, "vip_Uma");
        vipArray[6] = new Thread(vipGroup, run_objv7, "vip_Vivek");
        vipArray[7] = new Thread(vipGroup, run_objv8, "vip_wasantha");
        vipArray[8] = new Thread(vipGroup, run_objv9, "vip_wasana");
        vipArray[9] = new Thread(vipGroup, run_objv10, "vip_max");


        //set max priority for vip clients
        vipGroup.setMaxPriority(10);
        for (Thread t : vipArray
        ) {
            //start regulars array
            t.start();
            try {
                t.join(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //Assign Regulars to regularsArray
        regularArray[0] = new Thread(regularsGroup, run_obj1, "Asiri");
        regularArray[1] = new Thread(regularsGroup, run_obj2, "Bandara");
        regularArray[2] = new Thread(regularsGroup, run_obj3, "Chanaka");
        regularArray[3] = new Thread(regularsGroup, run_obj4, "Damitha");
        regularArray[4] = new Thread(regularsGroup, run_obj5, "Earl");
        regularArray[5] = new Thread(regularsGroup, run_obj6, "Fathima");
        regularArray[6] = new Thread(regularsGroup, run_obj7, "Gayan");
        regularArray[7] = new Thread(regularsGroup, run_obj8, "Harsha");
        regularArray[8] = new Thread(regularsGroup, run_obj9, "Indika");
        regularArray[9] = new Thread(regularsGroup, run_obj10, "Jason");


        //lets set a priority for Regular clients
        regularsGroup.setMaxPriority(1);
        for (Thread t : regularArray
        ) {
            //start regulars array
            t.start();
            // since VIP Threads gets Priority, let's try to release the resources
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



    }
}