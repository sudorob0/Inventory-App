package app.prgm.model;

/**
 * This Class extends the part call for In-House parts
 */
public class Outsourced extends Part {

    private String companyName;


    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * Returns Machine ID
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets Machine ID
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

