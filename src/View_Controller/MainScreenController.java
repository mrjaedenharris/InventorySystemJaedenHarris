package View_Controller;

import Model.*;
import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import java.util.List;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    private static Integer initialDataLoadRan = 0;

    @FXML
    private TextField partSearchTextField;


    //Display Parts In Tableview/table cols
    @FXML private TableView<Part> partsMainTableView;
    @FXML private TableColumn<Part, Integer> partsMainPartIdColumn;
    @FXML private TableColumn<Part, String> partsMainPartNameColumn;
    @FXML private TableColumn<Part, Integer> partsMainPartInventoryColumn;
    @FXML private TableColumn<Part, Double> partsMainPartPriceColumn;

    //Display Products in TableView/table cols
    @FXML private TableView<Product> productsMainTableView;
    @FXML private TableColumn<Product, Integer> productsMainProductIdColumn;
    @FXML private TableColumn<Product, String> productsMainProductNameColumn;
    @FXML private TableColumn<Product, Integer> productsMainProductInventoryColumn;
    @FXML private TableColumn<Product, Double> productsMainProductPriceColumn;


    //Search Functionality
    @FXML RadioButton partNameRadioButton;
    @FXML RadioButton partIdRadioButton;


    public void partSearchButtonClicked(ActionEvent actionEvent) {

        if(partSearchTextField.getText().trim().isEmpty() == false) {
            String searchText = partSearchTextField.getText();
            System.out.println(searchText);


            FilteredList<Part> filteredData = new FilteredList<>(Inventory.getAllParts(), p -> true);

            partSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(part -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    if (part.getPartName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    else if ((Integer.toString(part.getPartId())).contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });

            SortedList<Part> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(partsMainTableView.comparatorProperty());

            partsMainTableView.setItems(sortedData);


        }
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifyPart.fxml"));
        Parent modifyPartButtonParent = loader.load();

        ModifyPartController tempModifyPartController = loader.getController();

        tempModifyPartController.initData(partsMainTableView.getSelectionModel().getSelectedItem());

        Scene modifyPartScene = new Scene(modifyPartButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(modifyPartScene);
        window.show();
    }


    public void deletePartButtonClicked(ActionEvent actionEvent)
    {
        try
        {
            Part toDeletePart = partsMainTableView.getSelectionModel().getSelectedItem();
            System.out.println(toDeletePart.getPartId());

            Inventory.deletePart(toDeletePart);
        }

        catch (NullPointerException e)
        {
            System.out.println("No item selected");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning: You must select a part before deletion.");
            alert.setContentText("Please choose a part before proceeding.");

            alert.showAndWait();
        }


    }


    public void addProductButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent addProductButtonParent = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));

        Scene addProductScene = new Scene(addProductButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(addProductScene);
        window.show();
    }

    /*

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifyPart.fxml"));
        Parent modifyPartButtonParent = loader.load();

        ModifyPartController tempModifyPartController = loader.getController();

        tempModifyPartController.initData(partsMainTableView.getSelectionModel().getSelectedItem());

        Scene modifyPartScene = new Scene(modifyPartButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(modifyPartScene);
        window.show();
     */

    public void modifyProductButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ModifyProduct.fxml"));
        Parent modifyProductButtonParent = loader.load();


        ModifyProductController tempModifyProductController = loader.getController();

        tempModifyProductController.initData(productsMainTableView.getSelectionModel().getSelectedItem());
        //This loads the stage and scene

        Scene modifyProductScene = new Scene(modifyProductButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(modifyProductScene);
        window.show();
    }

    public void deleteProductButtonClicked (ActionEvent actionEvent)
    {
        Product tempProduct = productsMainTableView.getSelectionModel().getSelectedItem();

        Inventory.getAllProducts().remove(tempProduct);

    }

    public void exitButtonClicked (ActionEvent actionEvent)
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


    @FXML private TableView<Product> productsMainTableView;
    @FXML private TableColumn<Product, Integer> productsMainProductIdColumn;
    @FXML private TableColumn<Product, String> productsMainProductNameColumn;
    @FXML private TableColumn<Product, Integer> productsMainProductInventoryColumn;
    @FXML private TableColumn<Product, Double> productsMainProductPriceColumn;



     */


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        partsMainPartIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partId"));
        partsMainPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
        partsMainPartInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("quantityPart"));
        partsMainPartPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
        partsMainTableView.setItems(Inventory.getAllParts());

        productsMainProductIdColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        productsMainProductNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        productsMainProductInventoryColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productQuantity"));
        productsMainProductPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("productPrice"));
        productsMainTableView.setItems(Inventory.getAllProducts());


        loadDummyPartData();

    }
    // public Inhouse (String partName, double partPrice, int partQuantity, int min, int max, int machineId)


    public void loadDummyPartData()
    {

        if (initialDataLoadRan == 0)
        {
            Part dummyPartOne = new Inhouse("Screw", 1.00, 50, 25, 100, 56390);
            Inventory.getAllParts().add(dummyPartOne);
            Part dummyPartTwo = new Inhouse("Nail", .50, 75, 50, 200, 35689);
            Inventory.getAllParts().add(dummyPartTwo);
            Part dummyPartThree = new Inhouse("Hammer", 15.00, 20, 10, 50, 98203);
            Inventory.getAllParts().add(dummyPartThree);
            Part dummyPartFour = new Outsourced("Screwdriver", 20.00, 15, 10, 50, "Google");
            Inventory.getAllParts().add(dummyPartFour);

            Product dummyProductOne = new Product("Truck", 1500.00, 5,1, 10);
            Inventory.getAllProducts().add(dummyProductOne);
            Product dummyProducttwo = new Product ("House", 200000.00, 3, 1, 3);
            Inventory.getAllProducts().add(dummyProducttwo);
            Product dummyProductThree = new Product("Shed", 20000.00, 5, 1, 15);
            Inventory.getAllProducts().add(dummyProductThree);

            initialDataLoadRan = 1;
        }
    }
}
