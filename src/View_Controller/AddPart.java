package View_Controller;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPart implements Initializable
{

    @FXML Label machineIdLabel;
    @FXML TextField machineIdTextField;

    @FXML Label companyNameLabel;
    @FXML TextField companyNameTextField;

    public void inHouseCheckboxClicked (ActionEvent actionEvent)
    {
        machineIdTextField.setVisible(true);
        machineIdLabel.setVisible(true);
        companyNameLabel.setVisible(false);
        companyNameTextField.setVisible(false);

    }

    public void outsourcedCheckboxClicked (ActionEvent actionEvent)
    {
        companyNameLabel.setVisible(true);
        companyNameTextField.setVisible(true);
        machineIdTextField.setVisible(false);
        machineIdLabel.setVisible(false);
    }

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
        machineIdTextField.setVisible(false);
        machineIdLabel.setVisible(false);
        companyNameLabel.setVisible(false);
        companyNameTextField.setVisible(false);
    }
}
