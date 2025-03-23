public class Worker extends Employee implements Payment{

    //variables
    private int salary = 1000;
    private int performance;

    //Constructor
    public Worker(String name,int performance) {
        super(name);
        this.performance = performance;
    }

    //Variables
    @Override
    public int pay() {
        return salary + performance;
    }
}
