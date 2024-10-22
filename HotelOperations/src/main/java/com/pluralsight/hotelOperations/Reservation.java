package com.pluralsight.hotelOperations;

public class Reservation {
    private int numberOFNights;
    private boolean isWeekend;
    private String roomType;

    public Reservation(int numberOFNights, boolean isWeekend, String roomType) {
        this.numberOFNights = numberOFNights;
        this.isWeekend = isWeekend;
        this.roomType = roomType;
    }

    public int getNumberOFNights() {
        return numberOFNights;
    }

    public void setNumberOFNights(int numberOFNights) {
        this.numberOFNights = numberOFNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    //method for calculate the price, depends on room type and the number of night that a guess is staying
    public double getPrice(){
        double pricePerNight;
        if (roomType.equalsIgnoreCase("King")){
            pricePerNight= 139.00;
        } else {
            pricePerNight= 124.00;
        }
        if (isWeekend){
            pricePerNight *=1.10;
        }
        return pricePerNight * numberOFNights;
    }

    public double getReservationTotal(){
        return getPrice();
    }
}
