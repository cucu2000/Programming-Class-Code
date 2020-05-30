public class dataBase {

    //fields
    Employee DB [] = new Employee[10];
    int db1 = 0;

    //methods
    public Employee register(Employee emp){
        DB[db1] = emp;

        db1 ++;

        return DB [db1-1];


    }
}
