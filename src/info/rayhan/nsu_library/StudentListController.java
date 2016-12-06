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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kingRayhan
 */
public class StudentListController implements Initializable {
    private DbConnection dc;
    
    
    @FXML
    private Label errorMsg;
    @FXML
    private TableView<StudentList> StudentListTable;
    @FXML
    private TableColumn<StudentList, String> IdColumn;
    @FXML
    private TableColumn<StudentList, String> usernameColumn;
    @FXML
    private TableColumn<StudentList, String> emailColumn;
    @FXML
    private TableColumn<StudentList, String> studentIdColumn;
    @FXML
    private TableColumn<StudentList, String> departmentColumn;
    
    private ObservableList<StudentList> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new DbConnection();
        
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new StudentList(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(5) , rs.getString(6) ,rs.getString(4) ));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        StudentListTable.setItems(null);
        StudentListTable.setItems(data);
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
    
}
