package app.prgm.model;


/**
 * Creates a Part Object
 */
public abstract class Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * Returns ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns Name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns Price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets Price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the amount in stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock amount
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Returns the minimum amount
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets the minimum
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Returns the maximum
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets the maximum
     */
    public void setMax(int max) {
        this.max = max;
    }

}
