package View_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProduct implements Initializable {

    public void saveButtonClicked (ActionEvent actionEvent) throws IOException
    {
        Parent saveButtonParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

        Scene mainScreenScene = new Scene(saveButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(mainScreenScene);
        window.show();
    }

    public void cancelButtonClicked (ActionEvent actionEvent) throws IOException
    {
        Parent saveButtonParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

        Scene mainScreenScene = new Scene(saveButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(mainScreenScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
