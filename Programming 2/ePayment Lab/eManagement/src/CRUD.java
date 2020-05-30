public class CRUD {

    //fields
    DataBase db = new DataBase();

    //methods
    public Employee register(Employee emp){
        Employee result = db.register(emp);
        return result;
    }

    public void searchID(int id){
        db.searchID(id);
    }

    public int returnEmployeeCount(){
        return db.getEmployeeCount();
    }

    public void printEmployees(){
        db.printEmployees();
    }
}