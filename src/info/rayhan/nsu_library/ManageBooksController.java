/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rayhan.nsu_library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kingRayhan
 */
public class ManageBooksController implements Initializable {

    @FXML
    private Label errorMsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void addBook(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/AddNewBook.fxml")); 
        Scene  M= new Scene(x);
        Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
        app.setScene (M);
        app.show();
    }

    @FXML
    private void editBook(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/EditBook.fxml")); 
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
    private void BookList(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/BookList.fxml")); 
        Scene  M= new Scene(x);
        Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
        app.setScene (M);
        app.show();
    }
    
}
