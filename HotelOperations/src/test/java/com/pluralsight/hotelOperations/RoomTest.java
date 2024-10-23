package com.pluralsight.hotelOperations;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @org.junit.jupiter.api.Test
    void isAvailable() {
        boolean isDirt = false;
        boolean isOccupied= false;
        int numberOfBeds= 2;
        double price= 99.99;
       Room r = new Room(numberOfBeds,price);
       assertFalse(r.isAvailable());
    }


}