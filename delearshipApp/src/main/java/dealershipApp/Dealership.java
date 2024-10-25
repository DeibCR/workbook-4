package dealershipApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }



    public List<Vehicle> getAllVehicles(){
        List<Vehicle> reversedVehicles = new ArrayList<>(inventory);
        Collections.reverse(reversedVehicles);
        return reversedVehicles;
    }

    public void addVehicle(Vehicle vehicle){
        if (vehicle == null){
            throw new IllegalArgumentException("a vehicle cannot be null");

        }
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        if (vehicle != null && inventory.contains(vehicle)){
            inventory.remove(vehicle);
        }else {
            throw  new IllegalArgumentException("Vehicle not found");
        }

    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> filterVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getPrice() >= min && vehicle.getPrice() <=max){
                filterVehicles.add(vehicle);
            }
        }

        return filterVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> filterVehicles = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                filterVehicles.add(vehicle);
            }
        }

        return filterVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> filterVehicles = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getYear() >=min && vehicle.getYear() <= max){
                filterVehicles.add(vehicle);
            }
        }

        return filterVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> filterVehicles = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                filterVehicles.add(vehicle);
            }
        }

        return filterVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> filterVehicles = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getOdometer() >=min && vehicle.getOdometer() <= max){
                filterVehicles.add(vehicle);
            }
        }

        return filterVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> filterVehicles = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                filterVehicles.add(vehicle);
            }
        }

        return filterVehicles;
    }



}


