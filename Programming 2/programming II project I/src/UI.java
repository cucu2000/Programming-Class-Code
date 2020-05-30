import java.util.Scanner;

public class UI extends managementSystem {

    //field
    static Scanner scan = new Scanner(System.in);
    //methods
    public void showUI(){
        System.out.println("MENU-----------------");
        System.out.println("1. Registration");
        System.out.println("2. Search by ID");
        System.out.println("3. Total Employees");
        System.out.println("4. Employee list");
        System.out.println("5. Exit");

        doAction(getInput());
    }

    public int getInput() {

        int input = 0;

        int x = 0;

        System.out.print("Select Option: ");

        while (x == 0) {

            while (!scan.hasNextInt()) {

                System.out.println("Input must be a number");
                String garbage = scan.next();
            }

            input = scan.nextInt();

            if (input >= 1 && input <=5){

                x = 1;

            }else{

                System.out.println("Number must be 1-5");
            }
        }
        return input;
    }

    public void doAction(int input){
        switch (input) {
            case 1:
                System.out.println(" ");
                System.out.print("Insert Name: ");

                //move to next line after reading input
                scan.nextLine();

                String name = scan.nextLine();

                System.out.print("Insert Date of Birth: ");
                String dOB = scan.nextLine();

                System.out.print("Insert Employee ID: ");
                while (!scan.hasNextInt()) {
                    System.out.println("Must be a number");
                    String garbage = scan.next();
                }
                int iD = scan.nextInt();

                managementSystem newEmployee = new managementSystem(name, dOB, iD);
                break;

            case 2:
                System.out.println("Enter a ID to search: ");
                while(!scan.hasNextInt()){
                    System.out.println("ID must be a number");
                    String garbage = scan.nextLine();
            }
                int searchedID = scan.nextInt();
                super.searchID(searchedID);
                break;

            case 3:
                System.out.println("Number of employees = " + super.getEmployeeCount());
                break;

            case 4:
                super.printEmployees();
                break;
            case 5:
                System.out.print("Exiting Database");
                System.exit(0);
                break;
        }
    }
}
