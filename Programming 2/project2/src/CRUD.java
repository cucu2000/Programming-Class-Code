public class CRUD {

    //fields
    Database db = new Database();

    //methods
    public Employee register(Employee emp){
        Employee result = db.register(emp);
        return result;
    }

    public Employee searchID(int id){
        return db.searchID(id);
    }

    public int returnEmployeeCount(){
        return db.getEmployeeCount();
    }

    public Employee[] printEmployees(){
        return db.printEmployees();
    }
}