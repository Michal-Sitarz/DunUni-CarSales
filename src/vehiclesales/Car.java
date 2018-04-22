package vehiclesales;

/**
 * @author Michael Sitarz
 */
public class Car extends Vehicle {

    private boolean sat_nav;
    private boolean parking_sensor;
    private boolean towbar;
    private boolean roof_rack;

    //default ctor
    public Car(String make, String model, int year, Gearbox gearbox, String VIN_id, String colour, int mileage) {
        super(make, model, year, gearbox, VIN_id, colour, mileage);
    }

    //SETters
    public void setSat_nav(boolean sat_nav) {
        this.sat_nav = sat_nav;
    }

    public void setParking_sensor(boolean parking_sensor) {
        this.parking_sensor = parking_sensor;
    }

    public void setTowbar(boolean towbar) {
        this.towbar = towbar;
    }

    public void setRoof_rack(boolean roof_rack) {
        this.roof_rack = roof_rack;
    }

    //GETters
    public boolean isSat_nav() {
        return sat_nav;
    }

    public boolean isParking_sensor() {
        return parking_sensor;
    }

    public boolean isTowbar() {
        return towbar;
    }

    public boolean isRoof_rack() {
        return roof_rack;
    }

}
