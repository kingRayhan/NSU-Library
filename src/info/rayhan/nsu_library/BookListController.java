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
public class BookListController implements Initializable {
    private DbConnection dc;
    
    
    @FXML
    private TableView<BookList> BookListTable;
    @FXML
    private TableColumn<BookList, String> IdColumn;
    @FXML
    private TableColumn<BookList, String> bookNameColumn;
    @FXML
    private TableColumn<BookList, String> AuthorNameColumn;
    
    private ObservableList<BookList> data;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new DbConnection();
        
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM books");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new BookList(rs.getString(1) ,rs.getString(2) , rs.getString(3) ));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        AuthorNameColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        
        BookListTable.setItems(null);
        BookListTable.setItems(data);
    }    

    @FXML
    private void BACK(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/ManageBooks.fxml")); 
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
