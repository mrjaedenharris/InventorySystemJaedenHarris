package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory
{

    private ObservableList<Product> products = FXCollections.observableArrayList();

    public Inventory()
    {

    }

    public ObservableList<Product> getProducts()
    {
        return products;
    }

    public void addProduct(Product newProduct)
    {
        products.add(newProduct);
    }
}
