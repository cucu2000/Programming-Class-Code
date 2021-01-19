package Models;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty studentID;
    private SimpleStringProperty fName;
    private SimpleStringProperty lName;
    private SimpleStringProperty email;
    private SimpleStringProperty year;
    private SimpleStringProperty phone;
    private SimpleStringProperty major;

    public Student() {

    }

    public Student(String sID, String fName, String lName, String maj, String ye, String em, String pho) {
        this.studentID = new SimpleStringProperty(sID);
        this.fName = new SimpleStringProperty(fName);
        this.lName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(em);
        this.year = new SimpleStringProperty(ye);
        this.phone = new SimpleStringProperty(pho);
        this.major = new SimpleStringProperty(maj);
    }

    public void setMajor(String major) {
        this.major.set(major);
    }

    public String getMajor() {
        return major.get();
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getYear() {
        return year.get();
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getFirstName() {
        return fName.get();
    }

    public String getLastName() {
        return lName.get();
    }

    public String getStudentID() {
        return studentID.get();
    }

    public void setStudentID(String id) {
        this.studentID.set(id);
    }

    public void setFirstName(String name) {
        this.fName.set(name);
    }

    public void setLastName(String name) {
        this.lName.set(name);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

}
