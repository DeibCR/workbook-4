package com.pluralsight.hotelOperations;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfBasicRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfBasicRooms = numberOfRooms;
        this.bookedSuites=0;
        this.bookedBasicRooms=0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfBasicRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfBasicRooms() {
        return numberOfBasicRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    //derivated getters
    public int getAvailableSuites(){
        return numberOfSuites-bookedSuites;
    }

    public int getAvailableBasicRooms(){
        return numberOfBasicRooms-bookedBasicRooms;
    }

    //method to book room(s)

    public boolean bookRooms(int numberOfRooms, boolean isSuite){
        if (isSuite){
            if (numberOfRooms <= getAvailableSuites()){
                bookedSuites += numberOfRooms;
                return true; // Suites booked
            } else {
                return false; // not enough suites
            }

        } else {
            if (numberOfRooms<= getAvailableBasicRooms()){
                bookedBasicRooms += numberOfRooms;
                return true; //basic rooms booked
            } else {
                return false;// not enough Basic rooms
            }
        }
    }


}
