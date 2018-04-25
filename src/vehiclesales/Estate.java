package vehiclesales;

/**
 * @author Michael Sitarz
 */
public class Estate extends Car {

    private boolean third_row_seats;

    //default ctor
    public Estate(String make, String model, int year, Gearbox gearbox, String VIN_id, String colour, int mileage) {
        super(make, model, year, gearbox, VIN_id, colour, mileage);
    }

    //SETters
    public void setThird_row_seats() {
        this.third_row_seats = true;
    }

    //GETters
    public boolean hasThird_row_seats() {
        return third_row_seats;
    }

    @Override
    public String toStringAllAccessories() {
        return super.toStringAllAccessories()+"\t third_row_seats=" + third_row_seats;
    }
    
    

}
