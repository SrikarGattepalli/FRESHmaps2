package com.example.srikar.freshmaps;

/**
 * Class that repersents a room and holds the room number and teacher name
 */
public class Room {
    private String teacher;
    private String roomNumber;

    /**
     * Constructor that initializes the name and room number
     * @param teacher name of teacher
     * @param roomNumber room number
     */

    public Room(String teacher, String roomNumber) {
        this.teacher = teacher;
        this.roomNumber = roomNumber;
    }
// FIX ALL DIRECTORY NAMES TO MATCH ADAPTER

    /**
     * getter method for teacher name
     * @return name of teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * getter method for room number
     * @return the room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }


}
