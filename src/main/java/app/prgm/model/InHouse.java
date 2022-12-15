package app.prgm.model;

/**
 * This Class extends the part call for In-House parts
 */
public class InHouse extends Part {

    private int machineID;


    public InHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        super(id, name, price, stock, min, max);
        this.machineID = machineID;
    }

    /**
     * Returns Machine ID
     */
    public int getMachineID() {
        return machineID;
    }

    /**
     * Sets Machine ID
     */
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
