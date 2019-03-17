package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.util.Random;

public abstract class Part
{
    private SimpleIntegerProperty partId;
    private SimpleStringProperty partName;
    private SimpleDoubleProperty partPrice;
    private SimpleIntegerProperty quantityPart;
    private SimpleIntegerProperty minimum;
    private SimpleIntegerProperty maximum;

    protected Part()
    {

    }

    protected Part(String partName, double partPrice, int quantityPart, int min, int max)
    {


        Random rand = new Random();
        int tempPartId;

        do {
            tempPartId = rand.nextInt(1000);

            System.out.println("random integer selected: " + tempPartId);
        }
        while (Inventory.partIdExists(tempPartId));



        this.partId = new SimpleIntegerProperty(tempPartId);
        this.partName = new SimpleStringProperty(partName);
        this.partPrice = new SimpleDoubleProperty(partPrice);
        this.quantityPart = new SimpleIntegerProperty(quantityPart);
        this.minimum = new SimpleIntegerProperty(min);
        this.maximum = new SimpleIntegerProperty(max);
    }


    public int getPartId()
    {
        return partId.get();
    }

    public SimpleIntegerProperty partIdProperty()
    {
        return partId;
    }

    void setPartId(int partId)
    {
        this.partId.set(partId);
    }



    public String getPartName() {
        return partName.get();
    }

    public SimpleStringProperty partNameProperty() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName.set(partName);
    }



    public double getPartPrice() {
        return partPrice.get();
    }

    public SimpleDoubleProperty partPriceProperty() {
        return partPrice;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice.set(partPrice);
    }



    public int getQuantityPart() {
        return quantityPart.get();
    }

    public SimpleIntegerProperty quantityPartProperty() {
        return quantityPart;
    }

    public void setQuantityPart(int quantityPart) {
        this.quantityPart.set(quantityPart);
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
