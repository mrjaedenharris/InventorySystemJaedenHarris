package View_Controller;

import Model.Inventory;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable
{

    @FXML private TableView<Product> addProductTableView;
    @FXML private TableColumn<Product, String>  addProductNameColumn;
    @FXML private TableColumn<Product, String> addProductPriceColumn;

    private final ObservableList<Product> data = FXCollections.observableArrayList(
            new Product("video game", 60.00));


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
        //Set up the columns in the table
        addProductNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        addProductPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productPrice"));

        addProductTableView.setItems(data);

        System.out.println("Initializing of add product page done");
    }

}
