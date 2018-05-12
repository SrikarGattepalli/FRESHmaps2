package com.example.srikar.freshmaps;

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

    public void setRoomNumber1(String a) {
        roomNumber1 = a;
    }
}
