package dealershipApp;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

        public Dealership getDealership (String filename, String name, String address, String phone ){
            ArrayList<Vehicle> inventory = new ArrayList<>();

            try (BufferedReader br= new BufferedReader(new FileReader(filename))){
                String line;

                while ((line = br.readLine()) !=null){
                    String[] data = line.split("\\|");
                    int vin = Integer.parseInt(data[0]);
                    int year= Integer.parseInt(data[1]);
                    String make= data[2];
                    String model=data[3];
                    String type= data[4];
                    String color= data[5];
                    int odometer= Integer.parseInt(data[6]);
                    Double price =Double.parseDouble(data[7]);
                    inventory.add(new Vehicle(vin,year,make,model,type,color,odometer,price));

                }
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
            return new Dealership(name,address,phone,inventory);

        }

        public void saveDealership (Dealership dealerShip, String filename){

        }
}
