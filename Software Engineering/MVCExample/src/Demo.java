public class Demo {
    public static void main(String[] args) {
        //retrieve student record based on his ID no from the database
        Student model = retrieveStudentFromDatabase();
        //Create a view : to write student details on console
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        //update model data
        controller.setStudentName("Bob");
        controller.updateView();
    }
    private static Student retrieveStudentFromDatabase(){
        return new Student("George","B387299");
    }
}

