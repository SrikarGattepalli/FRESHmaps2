package com.example.srikar.freshmaps;


public class Room {
    private String teacher;
    private String roomNumber;


    public Room(String teacher, String roomNumber) {
        this.teacher = teacher;
        this.roomNumber = roomNumber;
    }
// FIX ALL DIRECTORY NAMES TO MATCH ADAPTER
    public String getTeacher() {
        return teacher;
    }

    public String getRoomNumber() {
        return roomNumber;
    }




}
