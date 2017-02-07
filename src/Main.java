/**
 * Created by Ben Maxwell on 2/6/17.
 * Inventory Tracking System for vehicles.
 * This is the main class.
 */

public class Main {

    public static void main(String[] args) throws Exception {

        VehicleInventory session = new VehicleInventory();
        session.loadInv();

        while (true) {
            session.userPrompt();
        }
    }
}
