package Models;

import javafx.beans.property.SimpleStringProperty;

public class Instructor {
    private SimpleStringProperty instructorID;
    private SimpleStringProperty fName;
    private SimpleStringProperty lName;
    private SimpleStringProperty email;
    private SimpleStringProperty officeNumber;
    private SimpleStringProperty phone;

    public Instructor() {

    }

    public Instructor(String instructorID,
                      String firstName,
                      String lastName,
                      String email,
                      String officeNumber,
                      String phone) {
        this.instructorID = new SimpleStringProperty(instructorID);
        this.fName = new SimpleStringProperty(firstName);
        this.lName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.officeNumber = new SimpleStringProperty(officeNumber);
        this.phone = new SimpleStringProperty(phone);
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

    public String getInstructorID() {
        return instructorID.get();
    }

    public void setInstructorID(String id) {
        this.instructorID.set(id);
    }

    public void setFirstName(String name) {
        this.fName.set(name);
    }

    public void setLastName(String name) {
        this.lName.set(name);
    }

    public String getOffice() {
        return officeNumber.get();
    }

    public void setOffice(String office) {
        this.officeNumber.set(office);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }
}


