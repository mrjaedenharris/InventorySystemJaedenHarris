package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

    public class AddProductController implements Initializable
    {

        private ObservableList<Part> tempList = FXCollections.observableArrayList();

        @FXML private TextField productNameTextField;
        @FXML private TextField productQuantityTextField;
        @FXML private TextField productPriceTextField;
        @FXML private TextField productMaximumTextField;
        @FXML private TextField productMinimumTextField;


        //All Parts TableView
        @FXML private TableView<Part> allPartsTableView;
        @FXML private TableColumn<Part, Integer> partIdTableColumn;
        @FXML private TableColumn<Part, String> partNameTableColumn;
        @FXML private TableColumn<Part, Integer> partQuantityTableColumn;
        @FXML private TableColumn<Part, Double> partPriceTableColumn;

        //Associated parts TableView
        @FXML private TableView<Part> associatedPartTableView;
        @FXML private TableColumn<Part, Integer> associatedPartIdTableColumn;
        @FXML private TableColumn<Part, String> associatedPartNameTableColumn;
        @FXML private TableColumn<Part, Integer> associatedPartQuantityTableColumn;
        @FXML private TableColumn<Part, Double> associatedPartPriceTableColumn;

        public void saveButtonClicked (ActionEvent actionEvent) throws IOException
        {

            String tempProductName = productNameTextField.getText();
            Integer tempProductQuantity = Integer.parseInt(productQuantityTextField.getText());
            Double tempProductPrice= Double.parseDouble(productPriceTextField.getText());
            Integer tempProductMaximum = Integer.parseInt(productMaximumTextField.getText());
            Integer tempProductMinimum = Integer.parseInt(productMinimumTextField.getText());


            Inventory.addProduct(new Product(tempList, tempProductName, tempProductPrice, tempProductQuantity, tempProductMinimum, tempProductMaximum));


            //Loads the main window (stage) and MainScreen fxml
            Parent saveButtonParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

            Scene mainScreenScene = new Scene(saveButtonParent);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            window.setScene(mainScreenScene);
            window.show();
        }

        public void cancelButtonClicked (ActionEvent actionEvent) throws IOException
        {

            tempList.clear();

            Parent saveButtonParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

            Scene mainScreenScene = new Scene(saveButtonParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            window.setScene(mainScreenScene);
            window.show();
        }

        public void addPartButtonClicked (ActionEvent actionEvent)
        {

            Part tempPart = allPartsTableView.getSelectionModel().getSelectedItem();

            if(tempList.contains(tempPart) == false)
            {
                tempList.add(tempPart);
            }



        }

        public void deletePartButtonClicked (ActionEvent actionEvent)
        {

            Part tempPart = associatedPartTableView.getSelectionModel().getSelectedItem();

            if(tempList.contains(tempPart))
            {
                tempList.remove(tempPart);
            }

        }

        /*
        @FXML private TableView<Part> allPartsTableView;
        @FXML private TableColumn<Part, Integer> partIdTableColumn;
        @FXML private TableColumn<Part, String> partNameTableColumn;
        @FXML private TableColumn<Part, Integer> partQuantityTableColumn;
        @FXML private TableColumn<Part, Double> partPriceTableColumn;

        @FXML private TableView<Part> associatedPartsTableView;
        @FXML private TableColumn<Part, Integer> associatedPartIdTableColumn;
        @FXML private TableColumn<Part, String> associatedPartNameTableColumn;
        @FXML private TableColumn<Part, Integer> associatedPartQuantityTableColumn;
        @FXML private TableColumn<Part, Double> associatedPartPricetableColumn;
        */

        @Override
        public void initialize(URL location, ResourceBundle resources)
        {

            partIdTableColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partId"));
            partNameTableColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
            partQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("quantityPart"));
            partPriceTableColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
            allPartsTableView.setItems(Inventory.getAllParts());


            associatedPartIdTableColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partId"));
            associatedPartNameTableColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
            associatedPartQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("quantityPart"));
            associatedPartPriceTableColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
            associatedPartTableView.setItems(tempList);

            System.out.println("Initializing of add product page done");
        }

    }

