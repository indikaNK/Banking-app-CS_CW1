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

        //create a bank account Object for regular clients
        BankAccount bankAccountv1 = new BankAccount("000011",0);
        BankAccount bankAccountv2 = new BankAccount("000021",0);
        BankAccount bankAccountv3 = new BankAccount("000031",0);
        BankAccount bankAccountv4 = new BankAccount("000041",0);
        BankAccount bankAccountv5 = new BankAccount("000051",0);
        BankAccount bankAccountv6 = new BankAccount("000061",0);
        BankAccount bankAccountv7 = new BankAccount("000071",0);
        BankAccount bankAccountv8 = new BankAccount("000081",0);
        BankAccount bankAccountv9 = new BankAccount("000091",0);
        BankAccount bankAccountv10 = new BankAccount("000110",0);


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

        //Create a runnable Object for VIP clients
        Runnable run_objv1 = new VIPClient(bankAccountv1,"c11","Omal", 20000 );
        Runnable run_objv2 = new VIPClient(bankAccountv2,"c12","Panduka", 30000 );
        Runnable run_objv3 = new VIPClient(bankAccountv3,"c13","Riyas", 40000 );
        Runnable run_objv4 = new VIPClient(bankAccountv4,"c14","Sanka", 10000 );
        Runnable run_objv5 = new VIPClient(bankAccountv5,"c15","Thusith", 5000 );
        Runnable run_objv6 = new VIPClient(bankAccountv6,"c16","Uma", 20000 );
        Runnable run_objv7 = new VIPClient(bankAccountv7,"c17","Vivek", 30000 );
        Runnable run_objv8 = new VIPClient(bankAccountv8,"c18","wasantha", 50000 );
        Runnable run_objv9 = new VIPClient(bankAccountv9,"c19","wasana", 20000 );
        Runnable run_objv10 = new VIPClient(bankAccountv10,"c110","Max", 1000 );

        //create a thread group for  Regular clients and VIP clients
        ThreadGroup regularsGroup = new ThreadGroup("RegularGroup");
        ThreadGroup vipGroup = new ThreadGroup("VIPGroup");


        //create a 2 thread Arrays for storing 10 and Regular clients and 10 vips
        Thread[] regularArray = new Thread[10];
        Thread[] vipArray = new Thread[10];



        //Assign VIP to vipArray
        vipArray[0] =  new Thread(vipGroup,run_objv1,"vip_Omal");
        vipArray[1] =  new Thread(vipGroup,run_objv2,"vip_Panduka");
        vipArray[2] =  new Thread(vipGroup,run_objv3,"vip_Riyas");
        vipArray[3] =  new Thread(vipGroup,run_objv4,"vip_Sanka");
        vipArray[4] =  new Thread(vipGroup,run_objv5,"vip_Thusith");
        vipArray[5] =  new Thread(vipGroup,run_objv6,"vip_Uma");
        vipArray[6] =  new Thread(vipGroup,run_objv7,"vip_Vivek");
        vipArray[7] =  new Thread(vipGroup,run_objv8,"vip_wasantha");
        vipArray[8] =  new Thread(vipGroup,run_objv9,"vip_wasana");
        vipArray[9] =  new Thread(vipGroup,run_objv10,"vip_max");


        //set max priority for vip clients
        vipGroup.setMaxPriority(10);
        for (Thread t:vipArray
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




        //lets set a priority for Regular clients
        regularsGroup.setMaxPriority(1);
        for (Thread t:regularArray
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