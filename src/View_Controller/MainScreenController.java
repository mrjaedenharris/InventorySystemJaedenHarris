package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private TextField partSearchTextfield;

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Integer> productStockColumn;
    @FXML
    private TableColumn<Product, Double> productPriceColumn;



    //Display Parts In Tableview/table cols
    @FXML TableView<Part> partsMainTableView;
    @FXML TableColumn<Part, Integer> partsMainPartIdColumn;
    @FXML TableColumn<Part, String> partsMainPartNameColumn;
    @FXML
    TableColumn<Part, Integer> partsMainPartInventoryColumn;
    @FXML TableColumn<Part, Double> partsMainPartPriceColumn;


    public void partSearchButtonClicked(ActionEvent actionEvent) {
        System.out.println("Button Pushed");
    }

    public void addPartButtonClicked(ActionEvent actionEvent) throws IOException
    {
        Parent addPartButtonParent = FXMLLoader.load(getClass().getResource("AddPart.fxml")); // load the other page

        Scene addPartScene = new Scene(addPartButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(addPartScene);
        window.show();
    }

    public void modifyPartButtonClicked(ActionEvent actionEvent) throws IOException
    {
        Parent modifyPartButtonParent = FXMLLoader.load(getClass().getResource("ModifyPart.fxml"));

        Scene modifyPartScene = new Scene(modifyPartButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(modifyPartScene);
        window.show();
    }

    public void deletePartButtonClicked(ActionEvent actionEvent)
    {
        Part toDeletePart = partsMainTableView.getSelectionModel().getSelectedItem();

        System.out.println(toDeletePart.getPartId());

        Inventory.deletePart(toDeletePart);


    }


    public void addProductButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent addProductButtonParent = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));

        Scene addProductScene = new Scene(addProductButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(addProductScene);
        window.show();
    }

    public void modifyProductButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent modifyProductButtonParent = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));

        Scene modifyProductScene = new Scene(modifyProductButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(modifyProductScene);
        window.show();
    }

    public void exitButtonClicked (ActionEvent actionEvent) throws IOException
    {
        Platform.exit();
        System.exit(0);
    }

    /*
    @FXML TableView<Part> partsMainTableView;
    @FXML TableColumn<Part, Integer> partsMainPartIdColumn;
    @FXML TableColumn<Part, String> partsMainPartNameColumn;
    @FXML TableColumn<Part, String> partsMainPartInventoryColumn;
    @FXML TableColumn<Part, Double> partsMainPartPriceColumn;



     */


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        partsMainPartIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partId"));
        partsMainPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
        partsMainPartInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("quantityPart"));
        partsMainPartPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
        partsMainTableView.setItems(Inventory.getAllParts());
    }
}
