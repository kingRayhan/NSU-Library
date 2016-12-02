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
public class ManageStudentsController implements Initializable {

    @FXML
    private Label errorMsg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void BackToAdminPanel(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml")); 
        Scene  M= new Scene(x);
        Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
        app.setScene (M);
        app.show();
    }

    private void BACK(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/ManageStudents.fxml")); 
        Scene  M= new Scene(x);
        Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
        app.setScene (M);
        app.show();
    }

    @FXML
    private void studentList(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/studentList.fxml")); 
        Scene  M= new Scene(x);
        Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
        app.setScene (M);
        app.show();
    }

    @FXML
    private void addStudent(ActionEvent event) throws IOException {
        Parent x=FXMLLoader.load(getClass().getResource("/views/addNewStudent.fxml")); 
        Scene  M= new Scene(x);
        Stage app=(Stage)((Node)event.getSource()).getScene().getWindow();
        app.setScene (M);
        app.show();
    }
    
}
