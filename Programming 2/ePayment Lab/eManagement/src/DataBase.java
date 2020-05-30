public class DataBase {

    //fields
    static Employee DB [] = new Employee[10];

    static int db1 = 0;

    //methods
    public Employee register(Employee emp){
        DB[db1] = emp;

        db1 ++;

        return DB [db1-1];


    }

    public void searchID(int id) {
        for (int x = 0; x < db1; x++) {
            if (id == DB[x].getiD()) {
                System.out.println("Employee Found");
                System.out.println("Employee: " + "Name: " + DB[x].getName() + " DOB: " + DB[x].getdOB());
                System.out.println("");
                break;
            }
            System.out.println("");
        }
    }

    public int getEmployeeCount(){
        return db1;
    }

    public void printEmployees(){
        System.out.println("Employee List-----------");
        for(int x = 0; x < db1; x++){
            System.out.println("Name: " + DB [x].getName());
            System.out.println("DOB: " + DB [x].getdOB());
            System.out.println("ID: " + DB[x].getiD());
            System.out.println("");

        }
    }
}