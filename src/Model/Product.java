package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product

{
    private SimpleStringProperty productName;
    private SimpleDoubleProperty productPrice;

    public Product(String name, Double price)
    {

        this.productName = new SimpleStringProperty(name);
        this.productPrice = new SimpleDoubleProperty(price);
    }

    public String getName()
    {

        return productName.get();
    }

    public void setName(String name)
    {
        productName.set(name);
    }

    public Double getPrice()
    {
        return productPrice.get();
    }

    public void setPrice(double price)
    {
        productPrice.set(price);
    }



}
