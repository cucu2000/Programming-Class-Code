public class Manager extends Employee implements Payment{

    //methods
    @Override
    public int pay() {
        //variables
        return 3000;
    }

    //constructor
    public Manager(String Name){
        super(Name);
    }
}
