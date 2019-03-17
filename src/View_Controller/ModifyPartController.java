package View_Controller;

import Model.Inhouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable
{

    @FXML private Label machineIdLabel;
    @FXML private TextField machineIdTextField;

    @FXML private Label companyNameLabel;
    @FXML private TextField companyNameTextField;

    @FXML private TextField partNameTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField priceTextField;
    @FXML private TextField maxQuantityTextField;
    @FXML private TextField minQuantityTextField;

    @FXML private RadioButton inhouseRadioButton;
    @FXML private RadioButton outsourcedRadioButton;

     private Part selectedPart;

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

        String tempPartName = partNameTextField.getText();
        Integer tempPartQuantity = Integer.parseInt(quantityTextField.getText());
        Double tempPartPrice = Double.parseDouble(priceTextField.getText());
        Integer tempPartMax = Integer.parseInt(maxQuantityTextField.getText());
        Integer tempPartMin = Integer.parseInt(minQuantityTextField.getText());

        if (inhouseRadioButton.isSelected())
        {
            Integer tempMachineId = Integer.parseInt(machineIdTextField.getText());
            Inventory.updateInhousePart(selectedPart.getPartId(), tempPartName, tempPartQuantity, tempPartPrice, tempPartMax, tempPartMin, tempMachineId);
        }

        else if (outsourcedRadioButton.isSelected())
        {
            String tempCompanyName = companyNameTextField.getText();
            Inventory.updateOutsourcedPart(selectedPart.getPartId(), tempPartName, tempPartQuantity, tempPartPrice, tempPartMax, tempPartMin, tempCompanyName);
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
    /*
    @FXML TextField partNameTextField;
    @FXML TextField quantityTextField;
    @FXML TextField priceTextField;
    @FXML TextField maxQuantityTextField;
    @FXML TextField minQuantityTextField;
*/
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        machineIdTextField.setVisible(false);
        machineIdLabel.setVisible(false);
        companyNameLabel.setVisible(false);
        companyNameTextField.setVisible(false);



    }

    //This method accepts a part to initialize the view
    public void initData(Part passedPart)
    {

        selectedPart = passedPart;

        System.out.println("It Worked!");

        partNameTextField.setText(passedPart.getPartName());
        quantityTextField.setText(Integer.toString(passedPart.getQuantityPart()));
        priceTextField.setText(Double.toString(passedPart.getPartPrice()));
        maxQuantityTextField.setText(Integer.toString(passedPart.getMaximum()));
        minQuantityTextField.setText(Integer.toString(passedPart.getMinimum()));

        //if passedPart is Inhouse - check Inhouse box and display machine ID
        if (passedPart.getClass() == Inhouse.class)
        {
            Inhouse inhousePart = (Inhouse) passedPart;

            machineIdTextField.setVisible(true);
            machineIdLabel.setVisible(true);
            inhouseRadioButton.setSelected(true);

            machineIdTextField.setText(Integer.toString(inhousePart.getMachineId()));
        }

        else if (passedPart.getClass() == Outsourced.class)
        {
            Outsourced outsourcedPart = (Outsourced) passedPart;

            companyNameTextField.setVisible(true);
            companyNameLabel.setVisible(true);
            outsourcedRadioButton.setSelected(true);

            companyNameTextField.setText(outsourcedPart.getCompanyName());




        }
    }

}
