package com.example.srikar.freshmaps;

/**
 * Abstract class to define any kind of building or room within a school campus
 */
public abstract class GeneralRoom {
    private String roomNumber1;

    public GeneralRoom(String a) {
        roomNumber1 = a;
    }
    /**
     * getter method for room number
     *
     * @return the room number
     */
    public String getRoomNumber1() {
        return roomNumber1;
    }

    /**
     * Setter method for the room number
     * @param a
     *         - room number
     */
    public void setRoomNumber1(String a) {
        roomNumber1 = a;
    }
}
