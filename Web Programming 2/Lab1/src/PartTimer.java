public class PartTimer extends Employee implements Payment{

    //variables
    private int time;

    //constructor
    public PartTimer(String name, int time) {
        super(name);
        this.time = time;
    }

    @Override
    public int pay() {
        return time * 10;
    }
}
