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
    private boolean isSold;
    private String colour;
    private int mileage;

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
    public void setIsSold(boolean isSold) {
        if (!this.isSold) {
            this.isSold = isSold;
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
        return "Vehicle{" + "make=" + make + ", model=" + model + ", year=" + year + ", gearbox=" + gearbox + ", VIN_id=" + VIN_id + ", isSold=" + isSold + ", colour=" + colour + ", mileage=" + mileage + '}';
    }

}
