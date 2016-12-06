/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rayhan.nsu_library;

import database.DbConnection;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kingRayhan
 */
public class DeleteStudentController implements Initializable {
    private DbConnection dc;
    
    
    @FXML
    private TextField student_id_field;
    @FXML
    private Label username;
    @FXML
    private Label username_label;
    @FXML
    private Label student_id_label;
    @FXML
    private Label email_label;
    @FXML
    private Label department_label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BACK(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/ManageStudents.fxml")); 
        Scene  M= new Scene(x);
        Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
        app.setScene (M);
        app.show();
    }

    @FXML
    private void BackToAdminPanel(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml")); 
        Scene  M= new Scene(x);
        Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
        app.setScene (M);
        app.show();
    }

    @FXML
    private void fetch_btn(ActionEvent event) {
        /**
         * Instantiate database class
         */
        dc = new DbConnection();
        try {
            Connection conn = dc.Connect();
            int Student_id = Integer.parseInt(student_id_field.getText());
            
            String sql = "SELECT * FROM `students` WHERE `student_id` = "+Student_id;
            
            ResultSet rs = conn.createStatement().executeQuery(sql);

            if(rs.next()){
                username_label.setText(rs.getString(2));
                student_id_label.setText(rs.getString(4));
                email_label.setText(rs.getString(5));
                department_label.setText(rs.getString(6));
            }else{
                JOptionPane.showMessageDialog(null, "Doesn't find any student associating with given student id","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }  
    }

    @FXML
    private void deleteStudent(ActionEvent event) throws IOException {
        dc = new DbConnection();
        try {
            Connection conn = dc.Connect();
            int Student_id = Integer.parseInt(student_id_field.getText());
            String sql = "DELETE FROM `students` WHERE `students`.`student_id` = "+Student_id;            
            conn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Student Deleted","Success",JOptionPane.ERROR_MESSAGE);

            Parent x=FXMLLoader.load(getClass().getResource("/views/ManageStudents.fxml")); 
            Scene  M= new Scene(x);
            Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
            app.setScene (M);
            app.show();
            
        } catch (SQLException ex){
            System.err.println("Error"+ex);
        }  
    }
    
}
    