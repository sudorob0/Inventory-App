package app.prgm.model;

/**
 * This Class extends the part call for In-House parts
 */
public class Outsourced extends Part {

    private String companyName;

    /**
     * Method for extending the part objects to include company name if the outsourced radio button was selected
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param companyName
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * getter for company name (string)
     * @return
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * setter for company name (string)
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

