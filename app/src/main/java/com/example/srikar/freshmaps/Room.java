package com.example.srikar.freshmaps;

/**
 * Class that repersents a room and holds the room number and teacher name
 */
public class Room {
    private String teacher;
    private String roomNumber1;
    private String roomNumber2;

    /**
     * Constructor that initializes the name and room number
     *
     * @param teacher     name of teacher
     * @param roomNumber1 room number
     */

    public Room(String teacher, String roomNumber1) {
        this.teacher = teacher;
        this.roomNumber1 = roomNumber1;
    }

    /**
     * Constructor that initializes the name of the teacher and two classrooms
     * @param teacher the name of the teacher
     * @param roomNumber1 the first room number
     * @param roomNumber2 the second room number
     */
    public Room(String teacher, String roomNumber1, String roomNumber2) {
        this.teacher = teacher;
        this.roomNumber1 = roomNumber1;
        this.roomNumber2 = roomNumber2;
    }
// FIX ALL DIRECTORY NAMES TO MATCH ADAPTER

    /**
     * getter method for teacher name
     *
     * @return name of teacher
     */
    public String getTeacher() {
        return teacher;
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
     * Method that checks whether the teacher has two classrooms or not
     * @return true if the teacher has two classes, false otherwise
     */
    public boolean hasTwoRooms() {
        return roomNumber2 != null;
    }

    /**
     * Getter method for second classroom
     * @return the rooom number of the second classroom
     */
    public String getRoomNumber2() {
        return roomNumber2;
    }


}