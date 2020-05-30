public class Database {

    //fields
    static Employee DB [] = new Employee[10];

    static int db1 = 0;

    //methods
    public Employee register(Employee emp){
        DB[db1] = emp;

        db1 ++;

        return DB [db1-1];
    }

    public Employee searchID(int id) {
        for (int x = 0; x < db1; x++) {
            if (id == DB[x].getiD()) {
                return DB[x];
            }
        }
        return null;
    }

    public int getEmployeeCount(){
        return db1;
    }

    public Employee [] printEmployees() {
        return DB;
    }
}