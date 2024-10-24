package dealershipApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DealerShip {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public DealerShip(String name, String address, String phone, ArrayList<Vehicle> inventory) {
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
        if (vehicle != null){
            inventory.add(vehicle);
        }throw new IllegalArgumentException("a vehicle cannot be null");
    }

    public void removeVehicle(Vehicle vehicle){

    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){

        return null;
    }

    public List<Vehicle> getVehiclesByMake(String make, String model){

        return null;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){

        return null;
    }

    public List<Vehicle> getVehiclesByColor(String color){

        return null;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){

        return null;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){

        return null;
    }



}
