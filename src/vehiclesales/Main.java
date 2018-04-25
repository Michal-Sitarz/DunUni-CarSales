package vehiclesales;

import java.util.ArrayList;
import java.util.Random;
import uod.gla.menu.MenuBuilder;
import uod.gla.menu.MenuItem;
import uod.gla.util.Reader;

/**
 * @author Michael Sitarz
 */
public class Main {

    static Main menu = new Main();
    private static ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

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
        MenuItem t = new MenuItem("T", "Sold/Transferred vehicle", menu, "displayMenu_SoldTransferredVehicle");
        MenuItem d = new MenuItem("D", "Dispaly details", menu, "displayMenu_DisplayDetails");
        MenuItem s = new MenuItem("S", "Search for a vehicle", menu, "displayMenu_SearchForVehicle");
        MenuBuilder.displayMenu(n, o, t, d, s);
    }

    // menu: New Vehicle
    public static void displayMenu_NewVehicle() {
        MenuItem a = new MenuItem("A", "Add new vehicle", menu, "addNewVehicle");
        MenuBuilder.displayMenuOnce(a);
    }

    public static void addNewVehicle() {
        // user input - vehicle's attributes
        String newMake = Reader.readNameString("Please enter the vehicle's make.");
        String newModel = Reader.readNameString("Please enter the vehicle's model.");
        int newYear = Reader.readInt("Please enter the vehicle's year of production.", 1990, 2099);
        Gearbox newGearbox = Reader.readEnum("Please choose the gearbox type from 2 available options: auto, manual.", Gearbox.class);
        String newVIN_id = fakeVINGenerator(newMake, newModel, newYear).toUpperCase();
        String newColour = Reader.readNameString("Please enter vehicle's body colour.").toLowerCase();
        int newMileage = Reader.readInt("Please enter vehicle's current mileage.", 0, 1000000);

        VehicleType chosenVehicleType = Reader.readEnum("Please choose vehicle's type:", VehicleType.class);
        // create object using user's input data and correct Object type
        switch (chosenVehicleType) {
            case Hatchback:
                Hatchback vh = new Hatchback(newMake, newModel, newYear, newGearbox, newVIN_id, newColour, newMileage);
                if (listOfVehicles.add(vh)) {
                    System.out.println("Vehicle: " + vh.toStringBasicFields() + " has been succesfully added to the Vehicle List.");
                }
                break;

            case Saloon:
                Saloon vs = new Saloon(newMake, newModel, newYear, newGearbox, newVIN_id, newColour, newMileage);
                if (listOfVehicles.add(vs)) {
                    System.out.println("Vehicle: " + vs.toStringBasicFields() + " has been succesfully added to the Vehicle List.");
                }
                break;

            case Estate:
                Estate ve = new Estate(newMake, newModel, newYear, newGearbox, newVIN_id, newColour, newMileage);
                if (listOfVehicles.add(ve)) {
                    System.out.println("Vehicle: " + ve.toStringBasicFields() + " has been succesfully added to the Vehicle List.");
                }
                break;

            case SUV:
                SUV vu = new SUV(newMake, newModel, newYear, newGearbox, newVIN_id, newColour, newMileage);
                if (listOfVehicles.add(vu)) {
                    System.out.println("Vehicle: " + vu.toStringBasicFields() + " has been succesfully added to the Vehicle List.");
                }
                break;

            case Motorbike:
                Motorbike vm = new Motorbike(newMake, newModel, newYear, newGearbox, newVIN_id, newColour, newMileage);
                if (listOfVehicles.add(vm)) {
                    System.out.println("Vehicle: " + vm.toStringBasicFields() + " has been succesfully added to the Vehicle List.");
                }
                break;
        }

        /*
        // add record to the ArrayList
        boolean addToExistingChoice = Reader.readBoolean("Do you want to add this vehicle to the existing Vehicle Register List? (true/false)");
        if (!addToExistingChoice) {
            boolean deleteCurrentConfirm = Reader.readBoolean("This operation will delete current list. You won't be able to access its records anymore.\nPlease confirm that you want to delete existing list and create a new one. (true/false).");
            if (deleteCurrentConfirm) {
                //delete current, add new and confirm completion
            } else {
                System.out.println("Operation canceled.");
            }
        } else {
            //add new and confirm completion
        }
         */
    }

    // menu: Optional accessories
    public static void displayMenu_OptionalAccessories() {
        MenuItem a = new MenuItem("A", "Add optional accessories", menu, "addAccessories");
        MenuItem e = new MenuItem("E", "Remove optional accessories (motorbikes only)", menu, "removeAccessories");
        MenuBuilder.displayMenuOnce(a, e);
    }

    public static void addAccessories() {
        displayVehiclesAccessories();
        Object obj = listOfVehicles.get(Reader.readInt("\nPlease enter the index of a vehicle to add accessories.", 0, listOfVehicles.size() - 1));

        if (!(obj instanceof Motorbike) && Reader.readBoolean("You won't be able to remove them, when fitted. Continue? (Yes/No).")) {

            // Hatchback
            if (obj instanceof Hatchback) {
                Hatchback vh = (Hatchback) obj;
                System.out.println("\n"+vh.toStringBasicFields() + ": " + vh.toStringAllAccessories());
                switch (Reader.readInt("Which accessory do you want to fit: \n[1] Sat-Nav \n[2] Parking sensor \n[3] Tow-bar \n[4] Roof rack", 1, 4)) {
                    case 1:
                        if (!vh.hasSat_nav()) {
                            vh.setSat_nav();
                        } else {
                            System.out.println("*** This vehicle has Sat Nav already fitted. ***");
                        }
                        break;
                    case 2:
                        if (!vh.hasParking_sensor()) {
                            vh.setParking_sensor();
                        } else {
                            System.out.println("*** This vehicle has Parking sensor already fitted. ***");
                        }
                        break;
                    case 3:
                        if (!vh.hasTowbar()) {
                            vh.setTowbar();
                        } else {
                            System.out.println("*** This vehicle has Tow-bar already fitted.");
                        }
                        break;
                    case 4:
                        if (!vh.hasRoof_rack()) {
                            vh.setRoof_rack();
                        } else {
                            System.out.println("*** This vehicle has Roof rack already fitted.");
                        }
                        break;
                }
                System.out.println("\n"+vh.toStringBasicFields() + ": " + vh.toStringAllAccessories());

                // Saloon
            } else if (obj instanceof Saloon) {
                Saloon vs = (Saloon) obj;
                System.out.println("\n"+vs.toStringBasicFields() + ": " + vs.toStringAllAccessories());
                switch (Reader.readInt("Which accessory do you want to fit: \n[1] Sat-Nav \n[2] Parking sensor \n[3] Tow-bar \n[4] Roof rack", 1, 4)) {
                    case 1:
                        if (!vs.hasSat_nav()) {
                            vs.setSat_nav();
                        } else {
                            System.out.println("*** This vehicle has Sat Nav already fitted. ***");
                        }
                        break;
                    case 2:
                        if (!vs.hasParking_sensor()) {
                            vs.setParking_sensor();
                        } else {
                            System.out.println("*** This vehicle has Parking sensor already fitted. ***");
                        }
                        break;
                    case 3:
                        if (!vs.hasTowbar()) {
                            vs.setTowbar();
                        } else {
                            System.out.println("*** This vehicle has Tow-bar already fitted. ***");
                        }
                        break;
                    case 4:
                        if (!vs.hasRoof_rack()) {
                            vs.setRoof_rack();
                        } else {
                            System.out.println("*** This vehicle has Roof rack already fitted. ***");
                        }
                        break;
                }
                System.out.println("\n"+vs.toStringBasicFields() + ": " + vs.toStringAllAccessories());

                // Estate
            } else if (obj instanceof Estate) {
                Estate ve = (Estate) obj;
                System.out.println("\n"+ve.toStringBasicFields() + ": " + ve.toStringAllAccessories());
                switch (Reader.readInt("Which accessory do you want to fit: \n[1] Sat-Nav \n[2] Parking sensor \n[3] Tow-bar \n[4] Roof rack \n[5] Third row seats", 1, 5)) {
                    case 1:
                        if (!ve.hasSat_nav()) {
                            ve.setSat_nav();
                        } else {
                            System.out.println("*** This vehicle has Sat Nav already fitted. ***");
                        }
                        break;
                    case 2:
                        if (!ve.hasParking_sensor()) {
                            ve.setParking_sensor();
                        } else {
                            System.out.println("*** This vehicle has Parking sensor already fitted. ***");
                        }
                        break;
                    case 3:
                        if (!ve.hasTowbar()) {
                            ve.setTowbar();
                        } else {
                            System.out.println("*** This vehicle has Tow-bar already fitted. ***");
                        }
                        break;
                    case 4:
                        if (!ve.hasRoof_rack()) {
                            ve.setRoof_rack();
                        } else {
                            System.out.println("*** This vehicle has Roof rack already fitted. ***");
                        }
                        break;
                    case 5:
                        if (!ve.hasThird_row_seats()) {
                            ve.setThird_row_seats();
                        } else {
                            System.out.println("*** This vehicle has Third row seats already fitted. ***");
                        }
                        break;
                }
                System.out.println("\n"+ve.toStringBasicFields() + ": " + ve.toStringAllAccessories());

                // SUV
            } else if (obj instanceof SUV) {
                SUV vsu = (SUV) obj;
                System.out.println("\n"+vsu.toStringBasicFields() + ": " + vsu.toStringAllAccessories());
                switch (Reader.readInt("Which accessory do you want to fit: \n[1] Sat-Nav \n[2] Parking sensor \n[3] Tow-bar \n[4] Roof rack \n[5] Third row seats", 1, 5)) {
                    case 1:
                        if (!vsu.hasSat_nav()) {
                            vsu.setSat_nav();
                        } else {
                            System.out.println("*** This vehicle has Sat Nav already fitted. ***");
                        }
                        break;
                    case 2:
                        if (!vsu.hasParking_sensor()) {
                            vsu.setParking_sensor();
                        } else {
                            System.out.println("*** This vehicle has Parking sensor already fitted. ***");
                        }
                        break;
                    case 3:
                        if (!vsu.hasTowbar()) {
                            vsu.setTowbar();
                        } else {
                            System.out.println("*** This vehicle has Tow-bar already fitted. ***");
                        }
                        break;
                    case 4:
                        if (!vsu.hasRoof_rack()) {
                            vsu.setRoof_rack();
                        } else {
                            System.out.println("*** This vehicle has Roof rack already fitted. ***");
                        }
                        break;
                    case 5:
                        if (!vsu.hasAWD_drivetrain()) {
                            vsu.setAWD_drivetrain();
                        } else {
                            System.out.println("*** This vehicle has Third row seats already fitted. ***");
                        }
                        break;
                }
                System.out.println("\n"+vsu.toStringBasicFields() + ": " + vsu.toStringAllAccessories());
            }
        } else {
            Motorbike vm = (Motorbike) obj;
            System.out.println(vm.toStringBasicFields() + ": " + vm.toStringAllAccessories());
            if (!vm.hasLuggage_box()) {
                vm.setLuggage_box(true);
                System.out.println("The Luggage Box has been fitted.");
            } else {
                System.out.println("This motorbike has a Luggage Box fitted already.");
            }
            System.out.println(vm.toStringBasicFields() + ": " + vm.toStringAllAccessories());

        }

    }

    public static void removeAccessories() {
        System.out.println("\n*** Please note this option is only available for MOTORBIKES! ***\n");
        listOfVehicles.forEach((v) -> {
            if (v.getClass() == Motorbike.class) {
                System.out.println("[" + listOfVehicles.indexOf(v) + "] " + v.toStringBasicFields() + " " + v.toStringAllAccessories());
            }
        });

        Object obj = listOfVehicles.get(Reader.readInt("\nPlease enter the index of a vehicle to remove accessories.", 0, listOfVehicles.size() - 1));

        if (obj instanceof Motorbike) {
            Motorbike m = (Motorbike) obj;
            if (m.hasLuggage_box()) {
                m.setLuggage_box(false);
            } else {
                System.out.println("This motorbike doesn't have a Luggage Box fitted.");
            }
        } else {
            System.out.println("This index doesn't correspond to a motorbike.");
        }
    }

    // menu: Sold/Transferred vehicle
    public static void displayMenu_SoldTransferredVehicle() {
        MenuItem m = new MenuItem("M", "Mark vehicle as \"sold\"", menu, "markVehicleAsSold");
        MenuItem e = new MenuItem("E", "Remove vehicle entirely from the system (irreversibly)", menu, "removeVehicleEntryFromSystem");
        MenuBuilder.displayMenuOnce(m, e);
    }

    public static void markVehicleAsSold() {
        displayAllAvailableVehicles();

        int listIndexChoice = Reader.readInt("\nPlease enter the index of a vehicle to mark \"as sold\".", 0, listOfVehicles.size() - 1);
        if (Reader.readBoolean("This operation is irreversible. Do you want to continue? (Yes/No).") && !listOfVehicles.get(listIndexChoice).isSold()) {
            listOfVehicles.get(listIndexChoice).setAsSold();
        }
        if (listOfVehicles.get(listIndexChoice).isSold()) {
            System.out.println("\nThis vehicle is marked \"as sold\" >>> " + listOfVehicles.get(listIndexChoice).toString() + "\n");
        }

        displayAllSoldVehicles();

    }

    public static void removeVehicleEntryFromSystem() {
        displayAllVehicles();
        int listIndexChoice = Reader.readInt("\nPlease enter the index of a vehicle to remove from the list.", 0, listOfVehicles.size() - 1);
        if (Reader.readBoolean("This operation will irreversibly remove the entry: \n" + listOfVehicles.get(listIndexChoice).toString() + "\n from the list. Please confirm (Yes/No).")) {
            listOfVehicles.remove(listIndexChoice);
        }
        displayAllVehicles();
    }

    // menu: Display details
    public static void displayMenu_DisplayDetails() {
        MenuItem a = new MenuItem("A", "Display details of ALL vehicles", menu, "displayAllVehicles");
        MenuItem c = new MenuItem("C", "Display all vehicles' accessories", menu, "displayVehiclesAccessories");
        MenuItem v = new MenuItem("V", "Display details of all AVAILABLE vehicles", menu, "displayAllAvailableVehicles");
        MenuItem s = new MenuItem("S", "Display details of all SOLD vehicles", menu, "displayAllSoldVehicles");
        MenuBuilder.displayMenuOnce(a, c, v, s);
    }

    public static void displayAllVehicles() {
        listOfVehicles.forEach((v) -> {
            System.out.println("[" + listOfVehicles.indexOf(v) + "] " + v.toString());
        });
    }

    public static void displayVehiclesAccessories() {
        listOfVehicles.forEach((v) -> {
            System.out.println("[" + listOfVehicles.indexOf(v) + "] " + v.toStringBasicFields() + ": \t" + v.toStringAllAccessories());
        });
    }

    public static void displayAllAvailableVehicles() {
        listOfVehicles.forEach((v) -> {
            if (!v.isSold()) {
                System.out.println("[" + listOfVehicles.indexOf(v) + "] " + v.toString());
            }
        });
    }

    public static void displayAllSoldVehicles() {
        listOfVehicles.forEach((v) -> {
            if (v.isSold()) {
                System.out.println("[" + listOfVehicles.indexOf(v) + "] " + v.toString());
            }
        });
    }

    // menu: Search for a vehicle
    public static void displayMenu_SearchForVehicle() {
        MenuItem a = new MenuItem("A", "Search for a vehicle's make", menu, "searchForVehiclesMake");
        MenuItem o = new MenuItem("O", "Search for a vehicle's model", menu, "searchForVehiclesModel");
        MenuItem m = new MenuItem("M", "Search for a vehicle's make & model", menu, "searchForVehiclesMakeModel");
        MenuBuilder.displayMenuOnce(a, o, m);
    }

    public static void searchForVehiclesMake() {
        //user input
        String searchQueryMake = Reader.readNameString("Please enter vehicle's make that you're searching for.").toLowerCase();

        ArrayList<Vehicle> searchResults = new ArrayList<>();
        //array search
        listOfVehicles.forEach((v) -> {
            if (v.getMake().toLowerCase().equals(searchQueryMake)) {
                searchResults.add(v);
            }
        });

        //display results
        if (searchResults.isEmpty()) {
            System.out.println("[! Not found any vehicles that match your search criteria. !]");
        } else {
            searchResults.forEach((r) -> System.out.println(r.toString()));
        }
    }

    public static void searchForVehiclesModel() {
        //user input
        String searchQueryModel = Reader.readNameString("Please enter vehicle's model that you're searching for.").toLowerCase();

        ArrayList<Vehicle> searchResults = new ArrayList<>();
        //array search
        listOfVehicles.forEach((v) -> {
            if (v.getModel().toLowerCase().equals(searchQueryModel)) {
                searchResults.add(v);
            }

        });

        //display results
        if (searchResults.isEmpty()) {
            System.out.println("[! Not found any vehicles that match your search criteria. !]");
        } else {
            searchResults.forEach((r) -> System.out.println(r.toString()));
        }

    }

    public static void searchForVehiclesMakeModel() {
        //user input
        String searchQueryMake = Reader.readNameString("Please enter vehicle's make that you're searching for.").toLowerCase();
        String searchQueryModel = Reader.readNameString("Please enter vehicle's model that you're searching for.").toLowerCase();

        ArrayList<Vehicle> searchResults = new ArrayList<>();
        //array search
        listOfVehicles.forEach((v) -> {
            if (v.getMake().toLowerCase().equals(searchQueryMake) && v.getModel().toLowerCase().equals(searchQueryModel)) {
                searchResults.add(v);
            }
        });

        //display results
        if (searchResults.isEmpty()) {
            System.out.println("[! Not found any vehicles that match your search criteria. !]");
        } else {
            searchResults.forEach((r) -> System.out.println(r.toString()));
        }
    }

    // OTHER methods
    public static void loadDataSample() {
        Hatchback v1h = new Hatchback("Honda", "Civic", 2004, Gearbox.manual, "HON200404CIV48275", "golden", 135505);
        v1h.setAsSold();
        listOfVehicles.add(v1h);
        Hatchback v2h = new Hatchback("Suzuki", "Ignis", 2018, Gearbox.auto, "SUZ201808IGN55392", "orange", 20);
        listOfVehicles.add(v2h);
        Saloon v3s = new Saloon("Toyota", "Chaser", 1998, Gearbox.manual, "TOY199808CHA29380", "white", 220000);
        v3s.setAsSold();
        listOfVehicles.add(v3s);
        Saloon v4s = new Saloon("BMW", "525i Executive", 2008, Gearbox.auto, "BMW200808525EX285", "red", 66200);
        listOfVehicles.add(v4s);
        Estate v5e = new Estate("Honda", "Odyssey", 2017, Gearbox.auto, "HON201707ODY12209", "silver", 5);
        listOfVehicles.add(v5e);
        Estate v6e = new Estate("Nissan", "Stagea", 2002, Gearbox.manual, "NIS200212STA97211", "black", 15005);
        listOfVehicles.add(v6e);
        SUV v7sv = new SUV("Subaru", "Forester", 2003, Gearbox.manual, "SUB200303FRS34034", "blue metallic", 170700);
        v7sv.setAsSold();
        listOfVehicles.add(v7sv);
        SUV v8sv = new SUV("Honda", "CRV", 2018, Gearbox.auto, "HON201808CRV98782", "purple", 5);
        listOfVehicles.add(v8sv);
        Motorbike v9m = new Motorbike("Suzuki", "Hayabusa", 2016, Gearbox.manual, "SUZ201601HAY23310", "pearl red", 2000);
        listOfVehicles.add(v9m);
        Motorbike v10m = new Motorbike("BMW", "GS650", 2014, Gearbox.manual, "BMW201404GS602922", "yellow", 12000);
        listOfVehicles.add(v10m);
    }

    public static String fakeVINGenerator(String make, String model, int year) {

        Random randomEnding = new Random();
        return make.substring(0, 3) + Integer.toString(year) + Integer.toString(year).substring(2) + model.substring(0, 3) + Integer.toString(randomEnding.nextInt(99999));

    }

}
