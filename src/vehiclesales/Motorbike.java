package vehiclesales;

/**
 * @author Michael Sitarz
 */
public class Motorbike extends Vehicle {

    private boolean luggage_box;

    //default ctor
    public Motorbike(boolean luggage_box, String make, String model, int year, Gearbox gearbox, String VIN_id, String colour) {
        super(make, model, year, gearbox, VIN_id, colour);
        this.luggage_box = luggage_box;
    }

    //SETters
    public void setLuggage_box(boolean luggage_box) {
        this.luggage_box = luggage_box;
    }

    //GETters
    public boolean isLuggage_box() {
        return luggage_box;
    }

}
