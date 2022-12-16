package app.prgm.model;

/**
 * This Class extends the part call for In-House parts
 */
public class InHouse extends Part {

    private int machineID;

    /**
     * Method that extends the part object to include the machine id
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param machineID
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        super(id, name, price, stock, min, max);
        this.machineID = machineID;
    }

    /**
     * getter for machine ID
     * @return
     */
    public int getMachineID() {
        return machineID;
    }

    /**
     * setter for machine id
     * @param machineID
     */
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
