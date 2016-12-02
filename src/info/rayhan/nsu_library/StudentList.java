package info.rayhan.nsu_library;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentList {
    private final StringProperty id;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty email;
    private final StringProperty student_id;
    private final StringProperty department;
    public StudentList(String id , String username , String password , String email , String department , String student_id){
        this.id          =  new SimpleStringProperty(id);
        this.username    =  new SimpleStringProperty(username);
        this.password    =  new SimpleStringProperty(password);
        this.email       =  new SimpleStringProperty(email);
        this.department  =  new SimpleStringProperty(department);
        this.student_id  =  new SimpleStringProperty(student_id);
    }
    //Getters
    public String getId() {
        return id.get();
    }
    public String getUsername() {
        return username.get();
    }
    public String getPassword() {
        return password.get();
    }
    public String getEmail() {
        return email.get();
    }
    public String getDepartment() {
        return department.get();
    }
    public String getStudent_id() {
        return student_id.get();
    }
    // Seters
    public void setUsername(String value) {
        username.set(value);
    }
    public void setPassword(String value) {
        password.set(value);
    }
    public void setEmail(String value) {
        email.set(value);
    }
    public void setDepartment(String value) {
        department.set(value);
    }
}
