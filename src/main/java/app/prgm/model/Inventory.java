package app.prgm.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    // start numbering the partIds at 1 and the productIds at 1001
    private static int partId = 0;
    private static int productID = 1000;
    /**
     * Method creates a list of parts
     */
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();
    /**
     * This method creates a list of products
     */
    public static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * This method adds a new part object to the parts list
     * @param newPart
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     * Adds a new Product object to allProducts list
     * @param newProduct
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * This method generates unique non-overlapping partID numbers.
     * FUTURE ENHANCEMENT: Iterate through the part IDs and find the highest number, then add a 1 to that number
     * @return partId
     */
    public static int generatePartId() {
        partId += 1;
        return partId;
    }
    /**
     * This method generates unique non-overlapping productID numbers.
     * FUTURE ENHANCEMENT: Iterate through the product IDs and find the highest number, then add a 1 to that number
     * @return partId
     */
    public static int generateProductId() {
        productID += 1;
        return productID;
    }
    /**
     * Search for a partial text match in the allParts list and return the results.
     * @param searchText
     * @return search results
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

    /**
     * This method finds an exact match for part id and returns a list of that match.
     * If the input string can be converted to an integer then it iterates through the inventory list
     * and returns once it finds an exact match.
     * If the input string cant be converted to an integer then the catch will return null.
     * @param partId a number for the partId
     * @return results
     */
    public static ObservableList<Part> lookupPartId(String partId) {
        ObservableList<Part> partIdResult = FXCollections.observableArrayList();
        try {
            for (Part tempPart : allParts) {
                if (tempPart.getId() == Integer.valueOf(partId)) {
                    partIdResult.add(tempPart);
                    return partIdResult;
                }
            }
        }
        catch (NumberFormatException exception) {
            return null;
        }
        return null;
    }
    /**
     * Search for a partial text match in the allParts list and return the results.
     * @param searchText any string
     * @return search results
     */
    public static ObservableList<Product> lookupProduct(String searchText) {
        // Make a list of parts to hold search results
        ObservableList<Product> productSearchResults = FXCollections.observableArrayList();
        // Iterate through list
        for(Product tempProduct : allProducts) {
            String productName = tempProduct.getProductName().toLowerCase();
            // Check if search string is in the parts name
            if(productName.contains(searchText.toLowerCase())) {
                productSearchResults.add(tempProduct);
            }
        }
        return productSearchResults;
    }

    /**
     * This method finds an exact match for part id and returns a list of that match.
     * If the input string can be converted to an integer then it iterates through the inventory list
     * and returns once it finds an exact match.
     * If the input string cant be converted to an integer then the catch will return null.
     * @param productId
     * @return
     */
    public static ObservableList<Product> lookupProductId(String productId) {
        ObservableList<Product> productIdResult = FXCollections.observableArrayList();
        try {
            for (Product tempProduct : allProducts) {
                if (tempProduct.getProductID() == Integer.valueOf(productId)) {
                    productIdResult.add(tempProduct);
                    return productIdResult;
                }
            }
        }
        catch (NumberFormatException exception) {
            return null;
        }
        return null;
    }
}