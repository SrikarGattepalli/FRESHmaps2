package com.example.srikar.freshmaps;

import java.util.ArrayList;

public class Room {
    private String teacher;
    private String roomNumber;


    public Room(String teacher, String roomNumber) {
        this.teacher = teacher;
        this.roomNumber = roomNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getRoomNumber() {
        return roomNumber;
    }


}
