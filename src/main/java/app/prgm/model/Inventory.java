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
     * Search for a partial text match in the allParts list and return the results.
     * @param searchText
     * @return
     */
    public static ObservableList<Part> lookupPart(String searchText) {
        // Make a list of parts to hold search results
        ObservableList<Part> partSearchResults = FXCollections.observableArrayList();
        // Iterate through list
        for(Part tempPart : allParts) {
            String partName = tempPart.getName().toLowerCase();
            // Check if search string is in the parts name
            if(partName.contains(searchText.toLowerCase())) {
                partSearchResults.add(tempPart);
            }
        }
        return partSearchResults;
    }

}