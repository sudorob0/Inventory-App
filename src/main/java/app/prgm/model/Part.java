package app.prgm.model;


/**
 * constructor for creating a part object
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
     * getter for id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * setter for id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for part name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for part name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for part price
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter for part price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * getter for part stock
     * @return
     */
    public int getStock() {
        return stock;
    }

    /**
     * setter for part stock
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * getter for part min inventory
     * @return
     */
    public int getMin() {
        return min;
    }

    /**
     * setter for min stock
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * getter for max stock
     * @return
     */
    public int getMax() {
        return max;
    }

    /**
     * setter for max stock
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }

}
