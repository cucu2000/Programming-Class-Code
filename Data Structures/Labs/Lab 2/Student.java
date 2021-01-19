public class Student {

    //variables
    private Name fullName;
    private String id;
    private double gpa;
    private String major;
    private String year;

    //methods
    public Name getFullName(){
        return fullName;
    }

    public void setFullName(String firstName, String lastName){
        fullName = new Name(firstName, lastName);
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public double getGpa(){
        return gpa;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    public String getMajor(){
        return major;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }

    public void printString(){
        System.out.println("ID: " + id + " Name: " + fullName.toString() + " Major: " + major + " Year: " + year + " GPA: " + gpa);
    }

    //constructors
    public Student(){
        fullName = new Name();
        id = " ";
        major = " ";
        gpa = 0.0;
        year = " ";
    }

    public Student(String firstName, String lastName, String id, String major, double gpa, String year){
        fullName = new Name(firstName, lastName);
        this.id = id;
        this.major = major;
        this.gpa = gpa;
        this.year = year;
    }

    //main
    public static void main(String [] args){
        Name Jim = new Name("Jim", "Grant");
        System.out.println(Jim.toString());

        Student Melissa = new Student("Melissa", "Parker", "001", "Biology", 3.4, "Senior");
        Melissa.printString();

        Student Kaleb = new Student("Kaleb", "Cosgrave", "002", "Computer Science", 3.8, "Sophomore");
        Kaleb.printString();
    }
}
