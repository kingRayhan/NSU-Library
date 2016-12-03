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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kingRayhan
 */
public class EditStudentController implements Initializable {
    private DbConnection dc;
    
    @FXML
    private TextField student_id_fetch_field;
    @FXML
    private Label username;
    @FXML
    private TextField username_field;
    @FXML
    private TextField student_id_field;
    @FXML
    private TextField email_field;
    @FXML
    private TextField department_field;
    @FXML
    private Label hideen_student_id;
    @FXML
    private Label headerLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BACK(ActionEvent event) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("/views/ManageStudents.fxml"));
        Scene M = new Scene(x);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(M);
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
            int Student_id = Integer.parseInt(student_id_fetch_field.getText());
            
            String sql = "SELECT * FROM `students` WHERE `student_id` = "+Student_id;
            
            ResultSet rs = conn.createStatement().executeQuery(sql);

            if(rs.next()){
                username_field.setText(rs.getString(2));
                student_id_field.setText(rs.getString(4));
                email_field.setText(rs.getString(5));
                department_field.setText(rs.getString(6));
                hideen_student_id.setText(""+rs.getString(1));

            }else{
                JOptionPane.showMessageDialog(null, "Doesn't find any student associating with given student id","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }  
    }

    @FXML
    private void updateBtn(ActionEvent event) {
        dc = new DbConnection();
        try {
            Connection conn = dc.Connect();
            String new_username = username_field.getText();
            String new_email = email_field.getText();
            String new_department = department_field.getText();
            String new_student_id = student_id_field.getText();
            String row_id = hideen_student_id.getText();
            
            String sql;
            sql = "UPDATE `students` SET "
                    + "`username` = '"+ new_username +"', "
                    + "`student_id` = '"+ new_student_id +"', "
                    + "`email` = '"+ new_email +"', "
                    + "`department` = '"+ new_department +"' "
                    + "WHERE "
                    + "`students`.`id` = "+ row_id +"";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Updated","SUCCESS",JOptionPane.PLAIN_MESSAGE);
            
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }  
    }
    
}
