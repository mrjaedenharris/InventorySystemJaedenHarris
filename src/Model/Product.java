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



}
