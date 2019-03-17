package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory
{

    static private ObservableList<Product> products = FXCollections.observableArrayList();
    static private ObservableList<Part> allParts = FXCollections.observableArrayList();

    public Inventory()
    {

    }

    public static ObservableList<Part> getAllParts(){
        return allParts;
    }
    public static ObservableList<Product> getAllProducts() { return products;}

    public static void addProduct(Product newProduct)
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

    public static Part lookupPartById(int partId)
    {
        //try.catch for index out of bounds

        Part foundPart;

        for (Part x : allParts)
        {
            if (x.getPartId() == partId)
            {
                foundPart = x;

                System.out.println("Part was found in our partlist");

                return foundPart;

            }

        }

        System.out.println("Part was not found correctly");
        return new Outsourced();
    }

    public static void updateOutsourcedPart(int partId, String newName, Integer newQuantity, Double newPrice, Integer newMax, Integer newMin, String newCompanyName)
    {
        for (Part x : allParts)
        {

            if (x.getPartId() == partId)
            {
                int tempPartId = x.getPartId();
                Inventory.deletePart(x);

                Part newPart = new Outsourced(newName, newPrice, newQuantity, newMin, newMax, newCompanyName);
                newPart.setPartId(tempPartId);
                Inventory.addPart(newPart);
                break;
            }
        }
    }

    public static void updateInhousePart(int partId, String newName, Integer newQuantity, Double newPrice, Integer newMax, Integer newMin, Integer newMachineId)
    {
        for (Part x : allParts)
        {
            if (x.getPartId() == partId)
            {
                int tempPartId = x.getPartId();
                Inventory.deletePart(x);

                Part newPart = new Inhouse(newName, newPrice, newQuantity, newMin, newMax, newMachineId);
                newPart.setPartId(tempPartId);
                Inventory.addPart(newPart);
                break;
            }
        }
    }

    static boolean partIdExists(Integer testedPartId)
    {
        boolean idExists = false;

        for (Part x : allParts)
        {
            Integer testableId = x.getPartId();
            System.out.println("current part being tested: " + x.getPartName() + " Current ID being tested: " + x.getPartId());
            if (testableId == testedPartId)
            {
                System.out.println("Id was found in list please use another.");
                idExists = true;
            }
        }

        System.out.println("Id was not found in list.");
        return idExists;
    }



}
