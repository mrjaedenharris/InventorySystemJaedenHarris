package View_Controller;

import Model.Inhouse;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import Model.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPartController implements Initializable
{

    //Radio Buttons
    @FXML RadioButton inhouseRadioButton;
    @FXML RadioButton outsourcedRadioButton;


    @FXML Label machineIdLabel;
    @FXML TextField machineIdTextField;

    @FXML Label companyNameLabel;
    @FXML TextField companyNameTextField;

    //Data Entry for new part
    @FXML TextField partName;
    @FXML TextField partQuantity;
    @FXML TextField partPrice;
    @FXML TextField partMax;
    @FXML TextField partMin;


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
        String textPartName = partName.getText();
        int textPartQuantity = Integer.parseInt(partQuantity.getText());
        double textPartPrice = Double.parseDouble(partPrice.getText());
        int textPartMax = Integer.parseInt(partMax.getText());
        int textPartMin = Integer.parseInt(partMin.getText());

        if (inhouseRadioButton.isSelected())
        {
            int textMachineId = Integer.parseInt(machineIdTextField.getText());

            Part newPart = new Inhouse(textPartName, textPartPrice, textPartQuantity, textPartMin, textPartMax, textMachineId);

            Inventory.addPart(newPart);

        }

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
