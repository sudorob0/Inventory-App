package app.prgm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * class to create product object
 */
public class Product {

    private int productID;
    private String productName;
    private double productPrice;
    private int productStock;
    private int min;
    private int max;
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();


    /**
     * constructor
     * @param productID
     * @param productName
     * @param productPrice
     * @param productStock
     * @param min
     * @param max
     */
    public Product(int productID, String productName, double productPrice, int productStock, int min, int max){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.min = min;
        this.max = max;
    }

    /**
     * getter for product id
     * @return
     */
    public int getProductID() {
        return productID;
    }

    /**
     * setter for product id
     * @param productID
     */
    public void setID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setStock(int productStock) {
        this.productStock = productStock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Method adds part to an associated parts list
     * @param part
     */
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }

    /**
     * Metod to remove a part form the associated parts list
     * @param selectedAssociatePart
     * @return
     */
    public boolean deleteAssociatedPart(Part selectedAssociatePart){
        associatedParts.remove(selectedAssociatePart);
        return true;
    }

    /**
     * Returns a list of parts
     * @return
     */
    public ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }

}
