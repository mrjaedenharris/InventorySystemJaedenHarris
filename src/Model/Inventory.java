package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory
{

    static ObservableList<Product> products = FXCollections.observableArrayList();
    static ObservableList<Part> allParts = FXCollections.observableArrayList();

    public Inventory()
    {

    }

    public static ObservableList<Part> getAllParts(){
        return allParts;
    }



    public void addProduct(Product newProduct)
    {
        products.add(newProduct);
    }

    public boolean removeProduct(int index)
    { //try/catch for index out of bounds
        products.remove(index);

        return true;
    }

    public Product lookupProduct(int index)
    {
        //try.catch for index out of bounds
        return products.get(index);
    }

    public static void addPart(Part newPart)
    {
        allParts.add(newPart);
    }

    public static boolean deletePart(Part part)
    {
        int partIndex = allParts.indexOf(part);

        if (partIndex >= 0)
        {
            allParts.remove(partIndex);
            return true;
        }

        else {

            return false;
        }

    }

    public Part lookupPart(int index)
    {
        //try.catch for index out of bounds

        return allParts.get(index);
    }

    public void updatePart(Part newPart)
    {
        //to do
    }




}
