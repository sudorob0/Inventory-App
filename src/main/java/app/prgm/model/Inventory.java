package app.prgm.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    /**
     * Method creates a list of parts
     */
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();
    /**
     * This method creates a list of pruducts
     */
    public static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * This method adds a new part to the parts list
     * @param newPart
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     * Adds a new Product to allProducts list
     * @param newProduct
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * Iterate through list and if id is in list then return the ID
     * @param partID
     * @return
     */
    public static Part lookupPart(int partID) {
        for (Part ID : allParts) {
            if (ID.getId() == partID) {
                return ID;
            }
        }
        // return null if the ID is not found in the part list
        return null;
    }


}