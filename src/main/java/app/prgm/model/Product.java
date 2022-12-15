package app.prgm.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Creates Product object
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
     * Constructor
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
     * Returns ID number
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Set ID number
     */
    public void setID(int productID) {
        this.productID = productID;
    }

    /**
     * Get Product Name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets Product Name
     */
    public void setName(String productName) {
        this.productName = productName;
    }

    /**
     *Returns Product Price
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     *Set Product price
     */
    public void setPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     *Return Produce Stock
     */
    public int getProductStock() {
        return productStock;
    }

    /**
     *Set Product stock level
     */
    public void setStock(int productStock) {
        this.productStock = productStock;
    }

    /**
     *Returns minimum stock
     */
    public int getMin() {
        return min;
    }

    /**
     *Set Minimum stock
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     *Return Maximun stock
     */
    public int getMax() {
        return max;
    }

    /**
     *Set maximum stock level
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     *Add part to associated part list
     */
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }

    /**
     *Remove a part from the associate part list
     */
    public boolean deleteAssociatedPart(Part selectedAssociatePart){
        associatedParts.remove(selectedAssociatePart);
        return true;
    }

    /**
     *Return list of associate parts
     */
    public ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }
}
