package vehiclesales;

import java.util.ArrayList;
import uod.gla.menu.MenuBuilder;
import uod.gla.menu.MenuItem;

/**
 * @author Michael Sitarz
 */
public class Main {

    static Main menu = new Main();
    private ArrayList<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
    
    public static void main(String[] args) {
        
        displayMenu_MainMenu();
        

    }

    
    // display MENU methods:
    /*
     * Methods named with "displayMenu_" word on the front 
     * are only for displaying menu options and lead to run proper methods
     * that are coded beneath the mentioned "menu" methods
     */
    // menu: Main Menu
    public static void displayMenu_MainMenu(){
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
        MenuBuilder.displayMenuOnce(m,e);
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
        MenuBuilder.displayMenuOnce(s,a,d);
    }

    public static void searchForVehicle() {
        System.out.println("[test] searchForVehicle [test]");
    }

    public static void displayAllAvailableVehicles() {
        System.out.println("[test] displayAllAvailableVehicles [test]");
    }

    public static void displayAllSoldVehicles() {
        System.out.println("[test] displayAllSoldVehicles [test]");
    }

}
