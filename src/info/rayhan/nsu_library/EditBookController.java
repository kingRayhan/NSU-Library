/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rayhan.nsu_library;

import java.net.URL;
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
public class EditBookController implements Initializable {

    @FXML
    private Label add_txt;
    @FXML
    private TextField BookName_field;
    @FXML
    private TextField AuthorName_field;
    @FXML
    private TextField book_id_field;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void back(ActionEvent event) {
        
    }

    @FXML
    private void backToAdmin(ActionEvent event) {
        
    }

    @FXML
    private void update(ActionEvent event) {
        
    }
    
}
