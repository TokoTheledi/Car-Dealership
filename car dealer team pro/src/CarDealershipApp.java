
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
 
// Main Application Class
public class CarDealershipApp {
 
    private ArrayList<Vehicle> vehicles;
 
    public CarDealershipApp() {
        vehicles = new ArrayList<>();
    }

 
    public static void main(String[] args) {
        CarDealershipApp system = new CarDealershipApp();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


 
        while (running) {
            System.out.println("\n--- Car Dealership Management System ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Display All Vehicles");
            System.out.println("4. Display All Categories");
            System.out.println("5. Vehicle Actions (Start/Stop/Turn)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
 
            int option = scanner.nextInt();
            scanner.nextLine();
 
            switch (option) {
                case 1:
                    system.addVehicle(scanner);
                    break;
                case 2:
                    system.removeVehicle(scanner);
                    break;
                case 3:
                    system.displayAllVehicles();
                    break;
                case 4:
                    system.displayAllCategories();
                    break;
                case 5:
                    system.vehicleActions(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

 
    // Add Vehicle to System
    public void addVehicle(Scanner scanner) {
        System.out.print("Enter Vehicle ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Vehicle Model: ");
        String model = scanner.nextLine();
        System.out.println("Choose Vehicle Category: ");
        for (VehicleCategory category : VehicleCategory.values()) {
            System.out.println((category.ordinal() + 1) + ". " + category);
        }
        int categoryIndex = scanner.nextInt() - 1;
        VehicleCategory category = VehicleCategory.values()[categoryIndex];
        Vehicle newVehicle = new Vehicle(id, model, category);
        vehicles.add(newVehicle);
        System.out.println("Vehicle added successfully!");
    }

 
    // Remove Vehicle by ID
    public void removeVehicle(Scanner scanner) {
        System.out.print("Enter Vehicle ID to remove: ");
        String id = scanner.nextLine();
        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getId().equals(id)) {
                iterator.remove();
                System.out.println("Vehicle with ID " + id + " removed.");
                return;
            }
        }
        System.out.println("Vehicle with ID " + id + " not found.");
    }

 
    // Display all vehicles
    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the system.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

 
    // Display all categories
    public void displayAllCategories() {
        System.out.println("Available Vehicle Categories:");
        for (VehicleCategory category : VehicleCategory.values()) {
            System.out.println((category.ordinal() + 1) + ". " + category);
        }
    }

 
    // Vehicle Actions: Start/Stop/Turn
    public void vehicleActions(Scanner scanner) {
        System.out.print("Enter Vehicle ID for action: ");
        String id = scanner.nextLine();
        Vehicle selectedVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                selectedVehicle = vehicle;
                break;
            }
        }
        if (selectedVehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }
        System.out.println("1. Start Vehicle");
        System.out.println("2. Stop Vehicle");
        System.out.println("3. Turn Vehicle");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                StartStopTurn.start();
                break;
            case 2:
                StartStopTurn.stop();
                break;
            case 3:
                StartStopTurn.turn();
                break;
            default:
                System.out.println("Invalid action.");
        }
    }
}

 
// Vehicle Class
class Vehicle {
    private String id;
    private String model;
    private VehicleCategory category;
 
    public Vehicle(String id, String model, VehicleCategory category) {
        this.id = id;
        this.model = model;
        this.category = category;
    }
 
    public String getId() {
        return id;
    }
 
    public String getModel() {
        return model;
    }
 
    public VehicleCategory getCategory() {
        return category;
    }
 
    @Override
    public String toString() {
        return "Vehicle ID: " + id + ", Model: " + model + ", Category: " + category;
    }
}
 

// Enum for Vehicle Categories
enum VehicleCategory {
    SEDAN,
    SUV,
    TRUCK,
    SPORTSCAR,
    CONVERTIBLE
}

 
// Start/Stop/Turn Functionality
class StartStopTurn {
    public static void start() {
        System.out.println("Vehicle is starting...");
    }
 
    public static void stop() {
        System.out.println("Vehicle is stopping...");
    }
 
    public static void turn() {
        System.out.println("Vehicle is turning...");
    }
}