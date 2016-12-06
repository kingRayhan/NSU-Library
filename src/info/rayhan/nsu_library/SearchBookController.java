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
public class SearchBookController implements Initializable {
    private DbConnection dc;
    @FXML
    private Label add_txt;
    @FXML
    private TextField book_id_field;
    @FXML
    private Label bookName_label;
    @FXML
    private Label authorName_label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("/views/ManageBooks.fxml"));
        Scene M = new Scene(x);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(M);
        app.show();
    }

    @FXML
    private void backToAdmin(ActionEvent event) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml"));
        Scene M = new Scene(x);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(M);
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
            
            
            String BookId = book_id_field.getText();
            
            String sql = "SELECT * FROM `books` WHERE `id` = "+ BookId;
            
            ResultSet rs = conn.createStatement().executeQuery(sql);

            if(rs.next()){
                bookName_label.setText(rs.getString(2));
                authorName_label.setText(rs.getString(3));


            }else{
                JOptionPane.showMessageDialog(null, "Doesn't find any student associating with given student id","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        } 
    }
    
}
