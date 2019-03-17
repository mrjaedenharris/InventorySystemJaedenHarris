package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class Product

{
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private SimpleIntegerProperty productId;
    private SimpleStringProperty productName;
    private SimpleDoubleProperty productPrice;
    private SimpleIntegerProperty productQuantity;
    private SimpleIntegerProperty minimum;
    private SimpleIntegerProperty maximum;

    //default constructor
    public Product()
    {

    }

    public Product(String name, Double price, Integer quantity, Integer min, Integer max)
    {
        Random rand = new Random();

        int tempPartId;

        //do while to verify we don't have this product ID already
        tempPartId = rand.nextInt(1000);

        this.associatedParts = FXCollections.observableArrayList();
        this.productId = new SimpleIntegerProperty(tempPartId);
        this.productName = new SimpleStringProperty(name);
        this.productPrice = new SimpleDoubleProperty(price);
        this.productQuantity = new SimpleIntegerProperty(quantity);
        this.minimum = new SimpleIntegerProperty(min);
        this.maximum = new SimpleIntegerProperty(max);
    }

    //constructor
    public Product(ObservableList<Part> tempParts,String name, Double price, Integer quantity, Integer min, Integer max)
    {
        Random rand = new Random();

        int tempPartId;

        //do while to verify we don't have this product ID already
        tempPartId = rand.nextInt(1000);

        this.associatedParts = tempParts;
        this.productId = new SimpleIntegerProperty(tempPartId);
        this.productName = new SimpleStringProperty(name);
        this.productPrice = new SimpleDoubleProperty(price);
        this.productQuantity = new SimpleIntegerProperty(quantity);
        this.minimum = new SimpleIntegerProperty(min);
        this.maximum = new SimpleIntegerProperty(max);
    }

    public ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }

    public void setAssociatedParts(ObservableList<Part> associatedParts) {
        this.associatedParts = associatedParts;
    }

    public int getProductId() {
        return productId.get();
    }

    public SimpleIntegerProperty productIdProperty() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId.set(productId);
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public double getProductPrice() {
        return productPrice.get();
    }

    public SimpleDoubleProperty productPriceProperty() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice.set(productPrice);
    }

    public int getProductQuantity() {
        return productQuantity.get();
    }

    public SimpleIntegerProperty productQuantityProperty() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity.set(productQuantity);
    }

    public int getMinimum() {
        return minimum.get();
    }

    public SimpleIntegerProperty minimumProperty() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum.set(minimum);
    }

    public int getMaximum() {
        return maximum.get();
    }

    public SimpleIntegerProperty maximumProperty() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum.set(maximum);
    }
}
