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
    private int productMin;
    private int productMax;
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();


    /**
     * constructor for product objects
     * @param productID
     * @param productName
     * @param productPrice
     * @param productStock
     * @param productMin
     * @param productMax
     */
    public Product(int productID, String productName, double productPrice, int productStock, int productMin, int productMax){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productMin = productMin;
        this.productMax = productMax;
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
    public void setProductId(int productID) {
        this.productID = productID;
    }

    /**
     * getter for product name
     * @return
     */
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductMin() {
        return productMin;
    }

    public void setProductMin(int productMin) {
        this.productMin = productMin;
    }

    public int getProductMax() {
        return productMax;
    }

    public void setProductMax(int productMax) {
        this.productMax = productMax;
    }

    /**
     * Method adds part to an associated parts list
     * @param part
     */
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }

    /**
     * Method to remove a part form the associated parts list
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
