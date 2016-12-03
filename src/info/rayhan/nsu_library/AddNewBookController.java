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
public class AddNewBookController implements Initializable {
    private DbConnection dc;
    @FXML
    private Label add_txt;
    @FXML
    private TextField BookName_field;
    @FXML
    private TextField AuthorName_field;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) {
        /**
         * Instantiate database class
         */
        dc = new DbConnection();
        try {
            /**
             * Get values from fields
             */
            String bookName = BookName_field.getText();
            String authorName = AuthorName_field.getText();


            Connection conn = dc.Connect();
            String sql = "INSERT INTO `books` (`id`, `name`, `Author`) VALUES (NULL , ? , ? )";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, bookName);
            statement.setString(2, authorName);
            statement.executeUpdate();
            
            
            /**
             * Show success popup message by JOption Pane
             */
            JOptionPane.showMessageDialog(null, "NEW BOOK ADDED TO THE DATABASE","SUCCESS",JOptionPane.PLAIN_MESSAGE);
            /**
             * Clear all filds
             */
            BookName_field.setText("");
            AuthorName_field.setText("");

            
            
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
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
    
}
