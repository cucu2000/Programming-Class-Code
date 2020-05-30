public class PartTImer extends Employee implements Payment {

    //field
    private long salary = 10;
    private long hours = 160;

    //method
    @Override
    public long setSalary() {
        return salary * hours;
    }

    //constructor
    PartTImer(int id, String Name, String dob){
        super(id, Name, dob);
    }
}
