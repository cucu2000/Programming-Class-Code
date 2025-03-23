public class Student {
    private String IDno;
    private String name;


    public String getIDno() {
        return IDno;
    }

    public void setIDno(String ID) {
        IDno = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String Mname) {
        name = Mname;
    }

    Student(String Mname, String ID){
        name = Mname;
        IDno = ID;
    }
}