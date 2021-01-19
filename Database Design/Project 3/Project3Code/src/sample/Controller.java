package sample;

import Common.DBHelper;
import Models.CourseInstructorStudent;
import Models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Student table and columns
    @FXML public TableView<Student> tblStudent;
    @FXML public TableColumn<Student, String> colStudentID;
    @FXML public TableColumn<Student, String> colfName;
    @FXML public TableColumn<Student, String> collName;
    @FXML public TableColumn<Student, String> colMajor;
    @FXML public TableColumn<Student, String> colYear;
    @FXML public TableColumn<Student, String> colEmail;
    @FXML public TableColumn<Student, String> colPhone;

    // Classes table
    @FXML public TableView<CourseInstructorStudent> tblCourse;
    @FXML public TableColumn<CourseInstructorStudent, String> colCourseID;
    @FXML public TableColumn<CourseInstructorStudent, String> colInstructorID;
    @FXML public TableColumn<CourseInstructorStudent, String> colCStudentID;

    // text areas
    @FXML public TextField txtStudentID;
    @FXML public TextField txtfName;
    @FXML public TextField txtlName;
    @FXML public TextField txtMajor;
    @FXML public TextField txtYear;
    @FXML public TextField txtEmail;
    @FXML public TextField txtPhone;
    @FXML public TextField txtInstructorID;
    @FXML public TextField txtCourseID;

    // buttons
    @FXML public Button btnNew;
    @FXML public Button btnEdit;
    @FXML public Button btnDelete;
    @FXML public Button btnAddCourse;
    @FXML public Button btnDeleteCourse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupStudentTable();
        loadStudentTable();

       setupClassTable();

    }

    // initialize student table
    private void setupStudentTable() {
        // set up student columns
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colfName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        collName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMajor.setCellValueFactory(new PropertyValueFactory<>("major"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    // initialize class table
    private void setupClassTable() {
        colInstructorID.setCellValueFactory(new PropertyValueFactory<>("instructorID"));
        colCourseID.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        colCStudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
    }

    // load student table
    private void loadStudentTable() {
        try {
            tblStudent.setItems(null);
            Connection conn = DBHelper.connect();
            assert conn != null;
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM student;");

            ObservableList<Student> data =
                    FXCollections.observableArrayList();

            while(rs.next()) {
                Student st = new Student(
                        rs.getString("studentID"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("major"),
                        rs.getString("year"),
                        rs.getString("email"),
                        rs.getString("phone"));
                data.add(st);
            }


            tblStudent.setItems(data);
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Load course table
    private void loadCourseTable() {

        try {
            tblCourse.setItems(null);
            Connection conn = DBHelper.connect();
            assert conn != null;
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM courseinstructorstudent WHERE studentID = '" + getPosition() + "';");
            ObservableList<CourseInstructorStudent> data =
                    FXCollections.observableArrayList();

            while(rs.next()) {
                CourseInstructorStudent cis = new CourseInstructorStudent(
                        rs.getString("courseID"),
                        rs.getString("instructorID"),
                        rs.getString("studentID"));
                data.add(cis);
            }


            tblCourse.setItems(data);
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // update SQL database
    public void edit (ActionEvent actionEvent) throws IOException {
        try {
            Connection conn = DBHelper.connect();

            String SQL = "UPDATE student SET " + "studentID=?, " + "fName=?, " + "lName=?, " + "major=?, " +
                    "year=?, " + "email=?, " + "phone=? " + "WHERE studentID = ?";
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1, txtStudentID.getText());
            pst.setString(2, txtfName.getText());
            pst.setString(3, txtlName.getText());
            pst.setString(4, txtMajor.getText());
            pst.setString(5, txtYear.getText());
            pst.setString(6, txtEmail.getText());
            pst.setString(7, txtPhone.getText());
            pst.setString(8, getPosition());
            pst.executeUpdate();

            loadStudentTable();

            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void deleteStudent(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setHeaderText("Delete Record");
        alert.setContentText("Are you sure you want to delete?");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeYes){
            try {
                Connection conn = DBHelper.connect();

                String SQL = "DELETE FROM student WHERE studentID=?;";
                assert conn != null;
                PreparedStatement pst = conn.prepareStatement(SQL);
                pst.setString(1, getPosition());

                pst.execute();
                conn.close();
                loadStudentTable();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    // add new student to database
    public void newStudent (ActionEvent actionEvent) throws IOException {
        try {
            Connection conn = DBHelper.connect();

            String SQL = "INSERT INTO student " + "VALUES(?, ?, ?, ?, ?, ?, ?)";
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1, txtStudentID.getText());
            pst.setString(2, txtfName.getText());
            pst.setString(3, txtlName.getText());
            pst.setString(4, txtMajor.getText());
            pst.setString(5, txtYear.getText());
            pst.setString(6, txtEmail.getText());
            pst.setString(7, txtPhone.getText());
            pst.executeUpdate();

            loadStudentTable();

            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    // get student ID for SQL Queries
    private String getPosition() {
        TablePosition pos = (TablePosition)tblStudent.getSelectionModel().getSelectedCells().get(0);
        int index = pos.getRow();
        Student selected = tblStudent.getItems().get(index);
        String selectString = selected.getStudentID();
        return selectString;
    }

    // call selected student in table for value calls
    private Student getStudent() {
        TablePosition pos = (TablePosition)tblStudent.getSelectionModel().getSelectedCells().get(0);
        int index = pos.getRow();
        Student selected = tblStudent.getItems().get(index);
        return selected;
    }

    // get Course ID for SQL queries
    private String getCoursePosition() {
        TablePosition pos = (TablePosition)tblCourse.getSelectionModel().getSelectedCells().get(0);
        int index = pos.getRow();
        CourseInstructorStudent selected = tblCourse.getItems().get(index);
        String selectString = selected.getCourseID();
        return selectString;
    }

    public void deleteCourse(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setHeaderText("Delete Record");
        alert.setContentText("Are you sure you want to delete?");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeYes){
            try {
                Connection conn = DBHelper.connect();

                String SQL = "DELETE FROM courseinstructorstudent WHERE studentID=? AND courseID =?";
                assert conn != null;
                PreparedStatement pst = conn.prepareStatement(SQL);
                pst.setString(1, getPosition());
                pst.setString(2, getCoursePosition());

                pst.execute();
                conn.close();
                loadCourseTable();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    // add new course to selected student
    public void newCourse(ActionEvent actionEvent) {
        try {
            Connection conn = DBHelper.connect();

            String SQL = "INSERT INTO courseinstructorstudent " + "VALUES(?, ?, ?)";
            assert conn != null;
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1, txtCourseID.getText());
            pst.setString(2, txtInstructorID.getText());
            pst.setString(3, getPosition());
            pst.executeUpdate();

            loadCourseTable();

            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    // load the classes when clicking on a student, and putting info in text fields
    public void clickView() {
        tblStudent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                loadCourseTable();
                txtStudentID.setText(getStudent().getStudentID());
                txtfName.setText(getStudent().getFirstName());
                txtlName.setText(getStudent().getLastName());
                txtMajor.setText(getStudent().getMajor());
                txtEmail.setText(getStudent().getEmail());
                txtYear.setText(getStudent().getYear());
                txtPhone.setText(getStudent().getPhone());
            }
        });
    }

}
