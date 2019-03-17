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

public class ModifyProductController implements Initializable {

    private Product selectedProduct;
    private ObservableList<Part> tempListAdded = FXCollections.observableArrayList();
    private ObservableList<Part> tempListDeleted = FXCollections.observableArrayList();

    @FXML private TextField productNameTextField;
    @FXML private TextField productQuantityTextField;
    @FXML private TextField productPriceTextField;
    @FXML private TextField productMaxTextField;
    @FXML private TextField productMinTextField;

    //All Parts Table
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
        Double tempProductPrice = Double.parseDouble(productPriceTextField.getText());
        Integer tempProductMax = Integer.parseInt(productMaxTextField.getText());
        Integer tempProductMin = Integer.parseInt(productMinTextField.getText());

        selectedProduct.setProductName(tempProductName);
        selectedProduct.setProductPrice(tempProductPrice);
        selectedProduct.setProductQuantity(tempProductQuantity);
        selectedProduct.setMaximum(tempProductMax);
        selectedProduct.setMinimum(tempProductMin);

        System.out.println(selectedProduct.getAssociatedParts());

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

        selectedProduct.getAssociatedParts().removeAll(tempListAdded);
        selectedProduct.getAssociatedParts().addAll(tempListDeleted);

        Scene mainScreenScene = new Scene(saveButtonParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(mainScreenScene);
        window.show();
    }

    public void addPartButtonClicked (ActionEvent actionEvent)
    {
        Part tempPart = allPartsTableView.getSelectionModel().getSelectedItem();

        System.out.println(tempPart.getPartName() + " was selected.");

        if(selectedProduct.getAssociatedParts().contains(tempPart) == false)
        {
            selectedProduct.getAssociatedParts().add(tempPart);
            tempListAdded.add(tempPart);
        }
        else {
            System.out.println("error message - alert later");
        }

    }

    public void removePartButtonClicked (ActionEvent actionEvent)
    {
        Part tempPart = associatedPartTableView.getSelectionModel().getSelectedItem();

        selectedProduct.getAssociatedParts().remove(tempPart);
        tempListDeleted.add(tempPart);

    }

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
        //associatedPartTableView.setItems(Inventory.getTempPartsList());

    }

    public void initData(Product passedProduct)
    {
        selectedProduct = passedProduct;

        System.out.println("It worked!");
        System.out.println(selectedProduct == passedProduct);
        System.out.println("Associated Parts with product selected " + passedProduct.getAssociatedParts());

        associatedPartTableView.setItems(passedProduct.getAssociatedParts());


        //test - not currently anything being added to the product
        //System.out.println(passedProduct.getAssociatedParts());

        productNameTextField.setText(passedProduct.getProductName());
        productQuantityTextField.setText(Integer.toString(passedProduct.getProductQuantity()));
        productPriceTextField.setText(Double.toString(passedProduct.getProductPrice()));
        productMaxTextField.setText(Integer.toString(passedProduct.getMaximum()));
        productMinTextField.setText(Integer.toString(passedProduct.getMinimum()));
    }
}
