package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product

{
    private SimpleIntegerProperty productId;
    private SimpleStringProperty productName;
    private SimpleDoubleProperty productPrice;
    private SimpleIntegerProperty productStockQuantity;
    private SimpleIntegerProperty minQuantiy;
    private SimpleIntegerProperty maxQuantity;

    public Product(String name, double price)
    {

        this.productName = new SimpleStringProperty(name);
        this.productPrice = new SimpleDoubleProperty(price);
    }


    public void setName(SimpleStringProperty name)
    {
        this.productName = name;
    }

    public String getName()
    {

        return productName.get();
    }

    public void setPrice(SimpleDoubleProperty price)
    {
        this.productPrice = price;
    }

    public double getPrice()
    {
        return productPrice.get();
    }



}
