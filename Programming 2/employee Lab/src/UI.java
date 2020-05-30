import java.util.Scanner;

public class UI {

    //fields
    static Scanner scan = new Scanner(System.in);

    //methods
    public void showMenu(){
        System.out.println("");
        System.out.print("Enter ID: ");
        int id = scan.nextInt();

        System.out.print("Enter Name: ");
        String nextLine = scan.nextLine();
        String name = scan.nextLine();

        System.out.print("Enter DOB: ");
        String dob = scan.nextLine();

        Employee emp = new Employee(id, name, dob);

        CRUD cr = new CRUD();

       Employee result = cr.register(emp);

       System.out.println(result.getName() + " was successfully registered.");
    }
}
