import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ben Maxwell on 2/6/17.
 * This is the VehicleInventory class for
 * the Inventory Tracker
 */

public class VehicleInventory {

    String vehicleType;
    int quantity;
    ArrayList<VehicleInventory> vehicles = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    //VehicleInventory method overload
    public VehicleInventory() {

    }

    //Constructor
    public VehicleInventory(String vehicleType, int quantity) {
        this.vehicleType = vehicleType;
        this.quantity = quantity;
    }


    public void loadInv() {
        System.out.println("Welcome to the Music City Motors Inventory Tracker!");
        System.out.println("---------------------------------------------------");

        //Make existing vehicle inventory
        VehicleInventory v1 = new VehicleInventory("Car", 5);
        VehicleInventory v2 = new VehicleInventory("Truck", 10);
        VehicleInventory v3 = new VehicleInventory("SUV", 25);

        //Load existing vehicle inventory
        vehicles.add(0, v1);
        vehicles.add(1, v2);
        vehicles.add(2, v3);

        //This prints out inventory items
        printInv();
    }


    public boolean userPrompt() {


        while (true) {

            //Prompt user for input
            System.out.println("\nPlease select one of the following options: \n");
            System.out.println("[1] Create new item");
            System.out.println("[2] Remove an item");
            System.out.println("[3] Update an item's quantity");
            System.out.println("[4] View Inventory List");
            System.out.println("[5] Exit");
            int option = input.nextInt();
            input.nextLine(); //consumes new line leftover by nextInt

            switch (option) {

                case 1:
                    //Add vehicle type to inventory
                    addInv();
                    break;

                case 2:
                    removeInv();
                    break;

                case 3:
                    changeQty();
                    break;

                case 4:
                    printInv();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose an item or press 4 to exit!");

            }
            if (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) ;
            break;
        }

        return false;

    }


    public void addInv() {
        System.out.println("Please enter a vehicle type:");
        String vType = input.nextLine();
        VehicleInventory invType = new VehicleInventory(vType, 0);
        vehicles.add(invType);

    }

    public void removeInv() {
        System.out.println("Please select the item number of the vehicle that you would like to remove:");
        int itmNumb = input.nextInt();
        System.out.println("\nAre you sure that you would like to remove this item?");
        String rmvConfirm = input.next();
        if (rmvConfirm.toUpperCase().equals("Y")) {
            vehicles.remove(itmNumb - 1);
            System.out.println("\nItem was removed!");

        } else {

            System.out.println("Returning to main menu...");
        }
    }

    public void changeQty() {
        System.out.println("\nPlease select the item number of the vehicle whose quantity you would like to update: ");
        int qNumb = input.nextInt(); //holds item number
        System.out.println("\nPlease enter the new quantity of this vehicle: ");
        int vQty = input.nextInt();
        String vType = vehicles.get(qNumb - 1).vehicleType;
        vehicles.set(qNumb - 1, new VehicleInventory(vType, vQty));

    }


    public void printInv() {
        int i = 1;
        for (VehicleInventory vType : vehicles) {
            System.out.println(i + ". [" + vType.quantity + "] " + vType.vehicleType);
            i++;
        }
    }

}
