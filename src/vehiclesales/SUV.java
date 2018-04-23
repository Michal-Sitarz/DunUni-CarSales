package vehiclesales;

/**
 * @author Michael Sitarz
 */
public class SUV extends Car {

    private boolean AWD_drivetrain;

    //default ctor
    public SUV(String make, String model, int year, Gearbox gearbox, String VIN_id, String colour, int mileage) {
        super(make, model, year, gearbox, VIN_id, colour, mileage);
    }

    //SETters
    public void setAWD_drivetrain(boolean AWD_drivetrain) {
        this.AWD_drivetrain = AWD_drivetrain;
    }

    //GETters
    public boolean isAWD_drivetrain() {
        return AWD_drivetrain;
    }

}
