/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rayhan.nsu_library;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private void BACK(ActionEvent event) {
    }

    @FXML
    private void BackToAdminPanel(ActionEvent event) {
    }

    @FXML
    private void fetch_btn(ActionEvent event) {
        /**
         * Instantiate database class
         */
        dc = new DbConnection();
        try {
            /**
             * Get values from fields
             */
            int getStudentId = Integer.parseInt(student_id_field.getText());
            

            Connection conn = dc.Connect();
            String sql = "SELECT * FROM `students` WHERE `student_id` = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, getStudentId);
            statement.executeUpdate();        

            
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

    }
    
}
