package com.pluralsight.hotelOperations;

public class HotelApp {
    public static void main(String[] args) {
        Room r= new Room(1,99.99);

        ///System.out.println(r);
        if (r.isAvailable())
        System.out.println("The Room is  available");
    }

}
