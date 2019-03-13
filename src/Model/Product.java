package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product

{
    ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private SimpleIntegerProperty productId;
    private SimpleStringProperty productName;
    private SimpleDoubleProperty productPrice;
    private SimpleIntegerProperty quantityProduct;
    private SimpleIntegerProperty minimum;
    private SimpleIntegerProperty maximum;

    //default constructor
    public Product()
    {

    }
    //constructor
    public Product(String name, Double price, Integer quantity, Integer min, Integer max)
    {

        this.productName = new SimpleStringProperty(name);
        this.productPrice = new SimpleDoubleProperty(price);
        this.quantityProduct = new SimpleIntegerProperty(quantity);
        this.minimum = new SimpleIntegerProperty(min);
        this.maximum = new SimpleIntegerProperty(max);
    }

    public String getProductName()
    {

        return productName.get();
    }

    public void setProductName(String name)
    {
        productName.set(name);
    }



    public Double getProductPrice()
    {
        return productPrice.get();
    }

    public void setProductPrice(double price)
    {
        productPrice.set(price);
    }



    public Integer getQuantityProduct()
    {
        return quantityProduct.get();
    }

    public void setQuantityProduct (int quantity)
    {
        quantityProduct.set(quantity);
    }



    public Integer getMinimum()
    {
        return minimum.get();
    }

    public void setMinimum (int min)
    {
        minimum.set(min);
    }



    public Integer getMaximum()
    {
        return maximum.get();
    }

    public void setMaximum(int max)
    {
        maximum.set(max);
    }

    public void addAssociatedPart (Part newPart)
    {

    }





}
