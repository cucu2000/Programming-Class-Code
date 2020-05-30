
public class Manager extends Employee implements Payment{

    //field
    private long salary = 3000;

    //method
    @Override
    public long setSalary(){
        return salary;
    }

    //constructor
    Manager(int id, String Name, String dob){
        super(id, Name, dob);

    }
}
