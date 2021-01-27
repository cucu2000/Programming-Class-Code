package Models;

import javafx.beans.property.SimpleStringProperty;

public class CourseInstructorStudent {
    private SimpleStringProperty studentID;
    private SimpleStringProperty instructorID;
    private SimpleStringProperty courseID;

   public CourseInstructorStudent() {

    }

   public CourseInstructorStudent(String courseID, String instructorID, String studentID) {
        this.studentID = new SimpleStringProperty(studentID);
        this.instructorID = new SimpleStringProperty(instructorID);
        this.courseID = new SimpleStringProperty(courseID);
    }

    public String getStudentID() {
        return studentID.get();
    }

    public void setStudentID(String id) {
        this.studentID.set(id);
    }

    public void setCourseID(String courseID) {
        this.courseID.set(courseID);
    }

    public String getCourseID() {
        return courseID.get();
    }

    public String getInstructorID() {
        return instructorID.get();
    }

    public void setInstructorID(String id) {
        this.instructorID.set(id);
    }
}
