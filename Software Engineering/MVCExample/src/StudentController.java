public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student Mmodel, StudentView Mview){
        model = Mmodel;
        view = Mview;
    }

    public void setStudentName(String name){
        model.setName(name);
    }

    public String getStudentName(){
        return model.getName();
    }

    public void setStudentIDno(String IDno){
        model.setIDno(IDno);
    }

    public String getStudentIDno(){
        return model.getIDno();
    }

    public void updateView(){
        view.printStudentDetails(model.getName(), model.getIDno());
    }
}