import java.lang.reflect.Array;
import java.util.ArrayList;

public class managementSystem {

    // fields
    private static ArrayList<Integer> ID_list = new ArrayList<Integer>();
    private static ArrayList<String> Name_list = new ArrayList<String>();
    private static ArrayList<String> DOB_list = new ArrayList<String>();


    private  int employeeID;

    private static int employeeCount;

    private String name;

    private String dateOfBirth;

    //methods

    public void searchID(int iD){

        for(int x = 0; x < ID_list.size(); x++){
            if(iD == ID_list.get(x)){
                System.out.println("ID " + iD + " was found");
                System.out.println("Name: " + Name_list.get(x));
                System.out.println("DOB: " + DOB_list.get(x));
                System.out.println(" ");
                break;
            }else{
                System.out.println("Employee not found");
                System.out.println(" ");
            }
        }
    }

    public int getEmployeeCount(){
        return employeeCount;
    }

    public void printEmployees(){
        System.out.println("Employee List------------");
        for(int x = 0; x < Name_list.size(); x++){
            System.out.println("Name: " + Name_list.get(x));
            System.out.println("DOB: " + DOB_list.get(x));
            System.out.println("ID: " + ID_list.get(x));
            System.out.println(" ");
        }
    }
    //constructors

    managementSystem(){

    }

    managementSystem(String EmName, String EmDateOfBirth, int EmID){
        if(employeeCount < 10){
            employeeCount ++;
            employeeID = EmID;
            name = EmName;
            dateOfBirth = EmDateOfBirth;

            ID_list.add(EmID);
            Name_list.add(EmName);
            DOB_list.add(EmDateOfBirth);

            System.out.println(EmName + ", " + EmDateOfBirth + ", " + EmID + " registered successfully");
            System.out.println(" ");

        }else{
            System.out.println("Database is full");
            System.out.println(" ");
        }
    }
}
