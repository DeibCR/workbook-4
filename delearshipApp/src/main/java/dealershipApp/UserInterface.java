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
        displayMenu();
        int input = getUserInput();
        exit = processInput(input);
    }

    private void displayMenu() {
        System.out.println("\n--- Dealership Menu ---");
        System.out.println("1. View all vehicles");
        System.out.println("2. Add a vehicle");
        System.out.println("3. Remove a vehicle");
        System.out.println("4. Search vehicles by price");
        System.out.println("5. Search vehicles by make and model");
        System.out.println("6. Search vehicles by color");
        System.out.println("7. Search vehicles by type");
        System.out.println("8. Search vehicles by mileage");
        System.out.println("9. Exit");
        System.out.print("Please select an option to continue:");
    }

    private int getUserInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    private boolean processInput(int input) {
        switch (input) {
            case 1:
                dealership.getAllVehicles().forEach(System.out::println);
                return false;
            case 2:
                addVehicleRequest();
                return false;
            case 3:
               // removeVehicle();
                return false;
            case 4:
               // searchByPrice();
                return false;
            case 5:
               // searchByMakeAndModel();
                return false;
            case 6:
                //searchByColor();
                return false;
            case 7:
               // searchByType();
                return false;
            case 8:
                //searchByMileage();
                return false;
            case 9:
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
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
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(id, year , make, model, type, color, mileage, price);
        dealership.addVehicle(newVehicle);
        System.out.println("A new vehicle has been added");


    }




}
