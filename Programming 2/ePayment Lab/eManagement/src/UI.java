import java.util.Scanner;

public class UI {

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
            CRUD cr = new CRUD();
            switch (input) {
                case 1:
                    System.out.println("");
                    System.out.print("Enter ID: ");
                    while(!scan.hasNextInt()) {
                        System.out.println("Input must be a number");
                        String garbage = scan.nextLine();

                    }

                    int id = scan.nextInt();

                    System.out.print("Enter Name: ");
                    String nextLine = scan.nextLine();
                    String name = scan.nextLine();

                    System.out.print("Enter DOB: ");
                    String dob = scan.nextLine();

                    Employee emp = new Employee(id, name, dob);

                    Employee result = cr.register(emp);

                    System.out.println(result.getName() + " was successfully registered.");
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Enter a ID to search: ");
                    while(!scan.hasNextInt()){
                        System.out.println("ID must be a number");
                        String garbage = scan.nextLine();
                    }
                    int searchedID = scan.nextInt();
                    cr.searchID(searchedID);
                    break;

                case 3:
                    System.out.println("There are " + cr.returnEmployeeCount() + " Employees");
                    System.out.println(" ");
                    break;

                case 4:
                    cr.printEmployees();
                    break;

                case 5:
                    System.out.print("Exiting Database");
                    System.exit(0);
                    break;
            }
        }
    }