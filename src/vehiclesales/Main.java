package vehiclesales;

import java.util.ArrayList;
import uod.gla.menu.MenuBuilder;
import uod.gla.menu.MenuItem;

/**
 * @author Michael Sitarz
 */
public class Main {

    static Main menu = new Main();
    private static ArrayList<Vehicle> listOfVehicles = new ArrayList<Vehicle>();

    public static void main(String[] args) {

        loadDataSample();
        displayMenu_MainMenu();

    }

    // display MENU methods:
    /*
     * Methods named with "displayMenu_" word on the front 
     * are only for displaying menu options and lead to run proper methods
     * that are coded beneath the mentioned "menu" methods
     */
    // menu: Main Menu
    public static void displayMenu_MainMenu() {
        //Menu display and items
        System.out.println("Welcome in the interactive Vehicle Sales system.");
        MenuItem n = new MenuItem("N", "New Vehicle", menu, "displayMenu_NewVehicle");
        MenuItem o = new MenuItem("O", "Optional accessories", menu, "displayMenu_OptionalAccessories");
        MenuItem s = new MenuItem("S", "Sold/Transferred vehicle", menu, "displayMenu_SoldTransferredVehicle");
        MenuItem d = new MenuItem("D", "Dispaly details", menu, "displayMenu_DisplayDetails");
        MenuBuilder.displayMenu(n, o, s, d);
    }

    // menu: New Vehicle
    public static void displayMenu_NewVehicle() {
        MenuItem a = new MenuItem("A", "Add new vehicle", menu, "addNewVehicle");
        MenuBuilder.displayMenuOnce(a);
    }

    public static void addNewVehicle() {
        System.out.println("[test] addNewVehicle [test]");
    }

    // menu: Optional accessories
    public static void displayMenu_OptionalAccessories() {
        MenuItem a = new MenuItem("A", "Add optional accessories", menu, "addAccessories");
        MenuItem e = new MenuItem("E", "Remove optional accessories", menu, "removeAccessories");
        MenuBuilder.displayMenuOnce(a, e);
    }

    public static void addAccessories() {
        System.out.println("[test] addAccessories [test]");
    }

    public static void removeAccessories() {
        System.out.println("[test] removeAccessories [test]");
    }

    // menu: Sold/Transferred vehicle
    public static void displayMenu_SoldTransferredVehicle() {
        MenuItem m = new MenuItem("M", "Mark vehicle as \"sold\"", menu, "markVehicleAsSold");
        MenuItem e = new MenuItem("E", "Remove vehicle entirely from the system (unreversible)", menu, "removeVehicleEntryFromSystem");
        MenuBuilder.displayMenuOnce(m, e);
    }

    public static void markVehicleAsSold() {
        System.out.println("[test] markVehicleAsSold [test]");
    }

    public static void removeVehicleEntryFromSystem() {
        System.out.println("[test] removeVehicleEntryFromSystem [test]");
    }

    // menu: Dispaly details
    public static void displayMenu_DisplayDetails() {
        MenuItem s = new MenuItem("S", "Search for a vehicle (and display the details of)", menu, "searchForVehicle");
        MenuItem a = new MenuItem("A", "Display details of ALL AVAILABLE vehicles", menu, "displayAllAvailableVehicles");
        MenuItem d = new MenuItem("D", "Display details of ALL sold vehicles", menu, "displayAllSoldVehicles");
        MenuBuilder.displayMenuOnce(s, a, d);
    }

    public static void searchForVehicle() {
        System.out.println("[test] searchForVehicle [test]");
    }

    public static void displayAllAvailableVehicles() {
        System.out.println("[test] displayAllAvailableVehicles [test]");
        
        //display ALL vehicles (available+sold) >>> fix this!
        listOfVehicles.forEach((a)->System.out.println(a.toString()));
    }

    public static void displayAllSoldVehicles() {
        System.out.println("[test] displayAllSoldVehicles [test]");
    }

    // OTHER methods
    public static void loadDataSample() {
        Vehicle v1h = new Hatchback("Honda", "Civic", 2004, Gearbox.manual, "HON200404CIV48275", "golden", 135505);
        v1h.setIsSold(true);
        listOfVehicles.add(v1h);
        Vehicle v2h = new Hatchback("Suzuki", "Ignis", 2018, Gearbox.auto, "SUZ201808IGN55392", "orange", 20);
        listOfVehicles.add(v2h);
        Vehicle v3s = new Saloon("Toyota", "Chaser", 1998, Gearbox.manual, "TOY199808CHA29380", "white", 220000);
        v3s.setIsSold(true);
        listOfVehicles.add(v3s);
        Vehicle v4s = new Saloon("BMW", "525i Executive", 2008, Gearbox.auto, "BMW200808525EX285", "red", 66200);
        listOfVehicles.add(v4s);
        Vehicle v5e = new Estate("Honda", "Odyssey", 2017, Gearbox.auto, "HON201707ODY12209", "silver", 5, true);
        listOfVehicles.add(v5e);
        Vehicle v6e = new Estate("Nissan", "Stagea", 2002, Gearbox.manual, "NIS200212STA97211", "black", 15005, false);
        listOfVehicles.add(v6e);
        Vehicle v7sv = new SUV("Subaru", "Forester", 2003, Gearbox.manual, "SUB200303FRS34034", "blue metallic", 170700, true);
        v7sv.setIsSold(true);
        listOfVehicles.add(v7sv);
        Vehicle v8sv = new SUV("Honda", "CRV", 2018, Gearbox.auto, "HON201808CRV98782", "purple", 5, false);
        listOfVehicles.add(v8sv);
        Vehicle v9m = new Motorbike("Suzuki", "Hayabusa", 2016, Gearbox.manual, "SUZ201601HAY23310", "pearl red", 2000, false);
        listOfVehicles.add(v9m);
        Vehicle v10m = new Motorbike("BMW", "GS650", 2014, Gearbox.manual, "BMW201404GS602922", "yellow", 12000, true);
        listOfVehicles.add(v10m);
    }

}
