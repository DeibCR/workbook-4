package com.pluralsight.hotelOperations;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = false;
        this.dirty = false;
    }

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    //A room is available just if it is not occupied and not dirty
    public boolean isAvailable(){
        return !occupied && !dirty;
    }

    //Setter to change the status of the room

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }


    public void cleanRoom(){
        if (dirty){
            dirty=false;
        }
    }

    public void checkIn(){
        if (!occupied && !dirty)
        occupied=true;
        dirty=true;
    }
    public void checkOut(){
        if (occupied){
            occupied=false;
            dirty=true;
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberOfBeds=" + numberOfBeds +
                ", price=" + price +
                ", occupied=" + occupied +
                ", dirty=" + dirty +
                '}';
    }

}
