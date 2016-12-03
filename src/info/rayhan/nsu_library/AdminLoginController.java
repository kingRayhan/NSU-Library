/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rayhan.nsu_library;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kingRayhan
 */
public class AdminLoginController implements Initializable {
    private DbConnection dc;
    
    
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
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
    private void Login(ActionEvent event) throws SQLException, IOException {
        dc = new DbConnection();
        try {
            String name =  username.getText();
            String pass =  password.getText();
            
            
            Connection conn = dc.Connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM admins WHERE username = '"+ name +"'");
            
            
        
        
        if(rs.next()){
            String database_name = rs.getString(2);
            String database_pass = rs.getString(3); 
            
            if(name.equals(database_name) && pass.equals(database_pass)){
                Parent x=FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml")); 
                Scene  M= new Scene(x);
                Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
                app.setScene (M);
                app.show();
            }else{
                errorMsg.setText("Sorry!! username or password didn't match");
            }
            
            
            
        }
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }  
    }
    
}
