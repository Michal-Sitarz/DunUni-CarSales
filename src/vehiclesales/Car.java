package vehiclesales;

/**
 * @author Michael Sitarz
 */
public abstract class Car extends Vehicle {

    private boolean sat_nav;
    private boolean parking_sensor;
    private boolean towbar;
    private boolean roof_rack;

    //default ctor
    public Car(String make, String model, int year, Gearbox gearbox, String VIN_id, String colour, int mileage) {
        super(make, model, year, gearbox, VIN_id, colour, mileage);
    }

    //SETters
    public void setSat_nav() {
        this.sat_nav = true;
    }

    public void setParking_sensor() {
        this.parking_sensor = true;
    }

    public void setTowbar() {
        this.towbar = true;
    }

    public void setRoof_rack() {
        this.roof_rack = true;
    }

    //GETters
    public boolean hasSat_nav() {
        return sat_nav;
    }

    public boolean hasParking_sensor() {
        return parking_sensor;
    }

    public boolean hasTowbar() {
        return towbar;
    }

    public boolean hasRoof_rack() {
        return roof_rack;
    }

    @Override
    public String toStringAllAccessories() {
        return "sat_nav=" + sat_nav + "\t parking_sensor=" + parking_sensor + "\t towbar=" + towbar + "\t roof_rack=" + roof_rack;
    }

}
