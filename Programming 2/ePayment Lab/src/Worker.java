public class Worker extends Employee implements Payment {

    //field
    private long salary = 2000;
    private long performance = 500;

    //method
    @Override
    public long setSalary(){
        return salary + performance;
    }

    //constructor
    Worker(int id, String Name, String dob){
        super(id, Name, dob);
    }
}
