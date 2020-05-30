public class Employee {

    //fields
    private int iD;

    private String name;

    private String dOB;

    //methods
    public int getiD(){
        return iD;
    }

    public String getName(){
        return name;
    }

    public String getdOB(){
        return dOB;
    }

    //constructor
    public Employee(int iD, String name, String dOB){
        this.iD = iD;

        this.name = name;

        this.dOB = dOB;
    }

}