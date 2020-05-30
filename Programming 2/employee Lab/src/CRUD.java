public class CRUD {

    //fields
    dataBase db = new dataBase();

    //methods
    public Employee register(Employee emp){
        Employee result = db.register(emp);
        return result;
    }
}
