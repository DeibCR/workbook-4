package dealershipApp;

import java.util.Scanner;

public class UserInterface {
    private DealershipFileManager fileManager;
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        fileManager = new DealershipFileManager();
        scanner = new Scanner(System.in);
    }

    private void init() {
        dealership = fileManager.getDealership("./src/main/resources/inventory.csv", "D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555");
    }

    public void display() {
        init();

        boolean exit = false;
        while (!exit) {


            displayMenu();
            int input = getUserInput();
            exit = processInput(input);
        }
    }

    private void displayMenu() {
        System.out.println("\n================================================");
        System.out.println("\n               Dealership Menu                  ");
        System.out.println(String.format("%s-%s-%s\n",dealership.getName(),dealership.getAddress(),dealership.getPhone()));
        System.out.println("\n================================================");
        System.out.printf("║ %-45s ║%n", "1. View all vehicles");
        System.out.printf("║ %-45s ║%n", "2. Add a vehicle");
        System.out.printf("║ %-45s ║%n", "3. Remove a vehicle");
        System.out.printf("║ %-45s ║%n", "4. Search vehicles by price");
        System.out.printf("║ %-45s ║%n", "5. Search vehicles by make and model");
        System.out.printf("║ %-45s ║%n", "6. Search vehicles by color");
        System.out.printf("║ %-45s ║%n", "7. Search vehicles by type");
        System.out.printf("║ %-45s ║%n", "8. Search vehicles by mileage");
        System.out.printf("║ %-45s ║%n", "9. Search vehicles by year");
        System.out.printf("║ %-45s ║%n", "10. Exit");
        System.out.print("Please type an option to continue:");
    }

    private int getUserInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    private boolean processInput(int input) {
        switch (input) {
            case 1:

                getAllVehicles();
                return false;
            case 2:
                addVehicleRequest();
                return false;
            case 3:
                removeVehicle();
                return false;
            case 4:
                searchByPrice();
                return false;
            case 5:
                searchByMakeAndModel();
                return false;
            case 6:
                searchByColor();
                return false;
            case 7:
                searchByType();
                return false;
            case 8:
                searchByMileage();
                return false;
            case 9:
                searchByYear();
                return false;
            case 10:
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
    }

    public void getAllVehicles() {
        System.out.println("""
                --------------------------------------------------------------------------------------------
                                              All Vehicles
                Vin      Year     Make        Model        Type      Color     Mileage     Price
                --------------------------------------------------------------------------------------------
                """);
        dealership.getAllVehicles().forEach(System.out::println);
    }

    private void addVehicleRequest() {
        System.out.print("Enter vehicle vin: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter vehicle year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();
        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();
        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();
        System.out.print("Enter vehicle mileage: ");
        int mileage = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter vehicle price: ");
        Double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(id, year, make, model, type, color, mileage, price);
        dealership.addVehicle(newVehicle);
        System.out.println("A new vehicle has been added");
        fileManager.saveDealership(dealership, "./src/main/resources/inventory.csv");


    }

    private void removeVehicle() {
        try {
            System.out.println("Enter a vehicle VIN to remove: ");
            int vin = Integer.parseInt(scanner.nextLine());

            Vehicle vehicleRemove = dealership.getAllVehicles().stream().filter(vehicle -> vehicle.getVin() == vin)
                    .findFirst().orElse(null);
            dealership.removeVehicle(vehicleRemove);
            System.out.println("Vehicle with the VIN: " + vin + " has been removed");
            fileManager.saveDealership(dealership, "./src/main/resources/inventory.csv");


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //handle vehicle not found
        }


    }

    private void searchByPrice() {
        System.out.println("Enter a minimum price: ");
        Double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a maximum price: ");
        Double maxPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("""
                --------------------------------------------------------------------------------------------
                                              All Vehicles
                Vin      Year     Make        Model        Type      Color     Mileage     Price
                --------------------------------------------------------------------------------------------
                """);
        dealership.getVehiclesByPrice(minPrice, maxPrice).forEach(System.out::println);

    }

    private void searchByMakeAndModel() {
        System.out.print("Enter a vehicle make: ");
        String make = scanner.nextLine();
        System.out.print("Enter a vehicle model: ");
        String model = scanner.nextLine();
        System.out.println("""
                --------------------------------------------------------------------------------------------
                                              All Vehicles
                Vin      Year     Make        Model        Type      Color     Mileage     Price
                --------------------------------------------------------------------------------------------
                """);
        dealership.getVehiclesByMakeModel(make, model).forEach(System.out::println);
    }

    private void searchByColor() {
        System.out.print("Enter a vehicle color: ");
        String color = scanner.nextLine();
        System.out.println("""
                --------------------------------------------------------------------------------------------
                                              All Vehicles
                Vin      Year     Make        Model        Type      Color     Mileage     Price
                --------------------------------------------------------------------------------------------
                """);
        dealership.getVehiclesByColor(color).forEach(System.out::println);
    }

    private void searchByType() {
        System.out.print("Enter a vehicle type: ");
        String type = scanner.nextLine();
        System.out.println("""
                --------------------------------------------------------------------------------------------
                                              All Vehicles
                Vin      Year     Make        Model        Type      Color     Mileage     Price
                --------------------------------------------------------------------------------------------
                """);
        dealership.getVehiclesByType(type).forEach(System.out::println);
    }

    private void searchByMileage() {
        System.out.println("Enter a minimum mileage: ");
        int minMileage = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter a maximum mileage: ");
        int maxMileage = Integer.parseInt(scanner.nextLine());
        System.out.println("""
                --------------------------------------------------------------------------------------------
                                              All Vehicles
                Vin      Year     Make        Model        Type      Color     Mileage     Price
                --------------------------------------------------------------------------------------------
                """);
        dealership.getVehiclesByMileage(minMileage, maxMileage).forEach(System.out::println);

    }

    private void searchByYear() {
        System.out.print("Enter the year of the vehicles to search for: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("""
                --------------------------------------------------------------------------------------------
                                              All Vehicles
                Vin      Year     Make        Model        Type      Color     Mileage     Price
                --------------------------------------------------------------------------------------------
                """);
        dealership.getVehiclesByYear(year).forEach(System.out::println);
    }


}
