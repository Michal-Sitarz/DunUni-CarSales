package vehiclesales;

/**
 * @author Michael Sitarz
 */
public abstract class Vehicle {

    //fields
    private String make;
    private String model;
    private int year;
    private Gearbox gearbox;
    private String VIN_id;
    private String colour;
    private int mileage;
    private boolean isSold;

    //default ctor
    public Vehicle(String make, String model, int year, Gearbox gearbox, String VIN_id, String colour, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.gearbox = gearbox;
        this.VIN_id = VIN_id;
        this.colour = colour;
        this.mileage = mileage;
    }

    //SETters (available)
    public void setAsSold() {
        if (!this.isSold) {
            this.isSold = true;
        }
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    //GETters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public String getVIN_id() {
        return VIN_id;
    }

    public boolean isSold() {
        return isSold;
    }

    public String getColour() {
        return colour;
    }

    public int getMileage() {
        return mileage;
    }

    //other methods
    @Override
    public String toString() {
        return "Vehicle{" + "make=" + make + "\t model=" + model + "\t year=" + year + "\t gearbox=" + gearbox + "\t VIN_id=" + VIN_id + "\t colour=" + colour + "\t mileage=" + mileage + "\t isSold=" + isSold + '}';
    }

    public String toStringBasicFields() {
        return year + " " + make + " " + model;
    }
    
    public String toStringAllAccessories(){
        return "";
    }

}
