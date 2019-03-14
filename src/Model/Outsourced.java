package Model;

import javafx.beans.property.SimpleStringProperty;

public class Outsourced extends Part
{
    private SimpleStringProperty companyName;

    public Outsourced()
    {

    }

    public Outsourced(String partName, double partPrice, int partQuantity, int min, int max, String company)
    {
        super(partName, partPrice, partQuantity, min, max);

        this.companyName = new SimpleStringProperty(company);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public SimpleStringProperty companyNameProperty() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
}
