package Models;

import javafx.beans.property.SimpleStringProperty;

public class Course {
    private SimpleStringProperty courseID;
    private SimpleStringProperty name;
    private SimpleStringProperty level;

    Course() {

    }

    Course(String ID, String nam, String lev) {
        this.courseID = new SimpleStringProperty(ID);
        this.name = new SimpleStringProperty(nam);
        this.level = new SimpleStringProperty(lev);
    }

    public void setCourseID(String courseID) {
        this.courseID.set(courseID);
    }

    public String getCourseID() {
        return courseID.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getName() {
        return this.name.get();
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public String getLevel() {
        return this.level.get();
    }
}
