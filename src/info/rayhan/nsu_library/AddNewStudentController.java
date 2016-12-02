/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rayhan.nsu_library;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 * FXML Controller class
 *
 * @author kingRayhan
 */
public class AddNewStudentController implements Initializable {

    private DbConnection dc;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private TextField student_id;
    @FXML
    private TextField department;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void save(ActionEvent event) throws IOException, SQLException {
        dc = new DbConnection();

        String username_field   = username.getText();
        String password_field   = password.getText();
        String email_field      = email.getText();
        String student_id_field = student_id.getText();
        String department_field = department.getText();
        
        PreparedStatement statement;
        Connection conn = dc.Connect();
        String sql = "INSERT INTO `students` "
                + "(`id`, `username`, `password`, `student_id`, `email`, `department`) "
                + "VALUES "
                + "(NULL, ?, ?, ?, ?, ?)";
        
        statement = conn.prepareStatement(sql);
        
        statement.setString(1, username_field);
        statement.setString(2, password_field);
        statement.setString(3, student_id_field);
        statement.setString(4, department_field);
        statement.execute();
        statement.close();
        
//        try {
//            Connection conn = dc.Connect();
//            ResultSet rs;
//            rs = conn.createStatement().executeQuery("INSERT INTO `students` (`id`, `username`, `password`, `student_id`, `email`, `department`) VALUES (NULL, 'sfgsd', '?', '?', '?', '?')");
//
//        } catch (SQLException ex) {
//            System.err.println("Error" + ex);
//        }
    }
    
    /**
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("/views/ManageStudents.fxml"));
        Scene M = new Scene(x);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(M);
        app.show();
    }
    /**
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void backToAdmin(ActionEvent event) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml"));
        Scene M = new Scene(x);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(M);
        app.show();
    }

}
