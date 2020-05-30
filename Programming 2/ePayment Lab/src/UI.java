import java.util.Scanner;
public class UI {

    //field
    Scanner scan = new Scanner(System.in);

    int x = 0;

    //method
    void showMenu() {
        System.out.println("");
        System.out.println("Employee Payment System");
        System.out.println("-----------------------");
        System.out.println("");

        while (x == 0) {
            System.out.println("1. for Manager");
            System.out.println("2. for Worker");
            System.out.println("3. for Part Timer");
            System.out.println("4. for Exit");
            int choice = scan.nextInt();

            begin:
            switch (choice) {
                case 1:  //manager
                    System.out.print("Enter ID: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("Input must be a number");
                        String garbage = scan.nextLine();

                    }
                    int id = scan.nextInt();

                    System.out.print("Enter Name: ");
                    String nextLine = scan.nextLine();
                    String name = scan.nextLine();

                    System.out.print("Enter DOB: ");
                    String dob = scan.nextLine();

                    Manager m1 = new Manager(id, name, dob);
                    System.out.println("Manager " + m1.getName() + " " + m1.getiD() + " " + m1.getdOB() + " Salary: $" + m1.setSalary());
                    System.out.println("");
                    break;

                case 2: // worker
                    System.out.print("Enter ID: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("Input must be a number");
                        String garbage = scan.nextLine();

                    }
                    id = scan.nextInt();

                    System.out.print("Enter Name: ");
                    nextLine = scan.nextLine();
                    name = scan.nextLine();

                    System.out.print("Enter DOB: ");
                    dob = scan.nextLine();

                    Worker w1 = new Worker(id, name, dob);
                    System.out.println("Worker " + w1.getName() + " " + w1.getiD() + " " + w1.getdOB() + " Salary: $" + w1.setSalary());
                    System.out.println("");
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("Input must be a number");
                        String garbage = scan.nextLine();

                    }
                    id = scan.nextInt();

                    System.out.print("Enter Name: ");
                    nextLine = scan.nextLine();
                    name = scan.nextLine();

                    System.out.print("Enter DOB: ");
                    dob = scan.nextLine();

                    PartTImer p1 = new PartTImer(id, name, dob);
                    System.out.println("Worker " + p1.getName() + " " + p1.getiD() + " " + p1.getdOB() + " Salary: $" + p1.setSalary());
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("System Shutting Down");
                    System.exit(0);

                default:
                    System.out.println("Invalid input");
                    System.out.println("");
                    continue;
            }
        }
    }
}
