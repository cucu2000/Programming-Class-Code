import java.util.Scanner;

public class Main {
    public static void main(String [] args){

        //menu
        System.out.println("Employee Information System");
        System.out.println("-----------------------------");
        System.out.println("Press 1 for Manager, 2 for Worker, 3 for Part Timer, 4 to Exit");

        Scanner scan = new Scanner(System.in);



       while(true){
           String string = scan.nextLine();
           if(string.equals("1")){
               System.out.println("Enter Name");
               String name = scan.nextLine();
               Manager m1 = new Manager(name);
               printManager(m1);


           }else if(string.equals("2")){
               System.out.println("Enter Name");
               String name = scan.nextLine();
               System.out.println("Enter Performance");
               int performance = scan.nextInt();
               Worker w1 = new Worker(name, performance);
               printWorker(w1);

           }else if(string.equals("3")){
               System.out.println("Enter Name");
               String name = scan.nextLine();
               System.out.println("Enter Time");
               int time = scan.nextInt();
               PartTimer p1 = new PartTimer(name, time);
               printPartTimer(p1);

           }else if(string.equals("4")){
               System.exit(0);
           }
       }
    }

    public static void printManager(Manager manager){
        System.out.println(manager.getName() + "'s salary is " + manager.pay());
    }

    public static void printWorker(Worker worker){
        System.out.println(worker.getName() + "'s salary is " + worker.pay());
    }

    public static void printPartTimer(PartTimer partTimer){
        System.out.println(partTimer.getName() + "'s salary is " + partTimer.pay());
    }
}
