package com.example.srikar.freshmaps;

import android.content.Intent;

import com.example.srikar.freshmaps.Room;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class that represents entire school and holds room objects
 */
public class School {
    private ArrayList<Room> totalSchool = new ArrayList<Room>();

    /**
     * Constructor that takes in file and fills ArrayList with Rooms
     *
     * @param fName the file holding the information about teachers and their rooms
     */
    public School(InputStream fName) {
        Scanner scan = new Scanner(fName);
        while (scan.hasNext()) {
            String name = scan.next() + " " + scan.next();
            String room = scan.next();
            if (room.indexOf('/') == -1) {
                totalSchool.add(new Room(name, room));
            } else {
                totalSchool.add(new Room(name, room.substring(0, room.indexOf('/')), room.substring(room.indexOf('/') + 1)));
            }
        }

    }

    /**
     * getter method for the ArrayList of classes
     *
     * @return the ArrayList that holds all the classes as Room objects
     */
    public ArrayList<Room> getTotalSchool() {
        return totalSchool;
    }

    /**
     * Method that sorts the ArrayList of Rooms by teacher
     */
    public void sortArraybyTeacher() {
        totalSchool = mergeSortTeacher(totalSchool);
    }

    /**
     * Method that sorts the ArrayList of Rooms by room number
     */
    public void sortArrayByRoom() {
        totalSchool = mergeSortRoom(totalSchool);
    }

    /**
     * Method that merge sorts a given ArrayList by teacher
     *
     * @param whole the ArrayLiost to be sorted
     * @return the sorted ArrayList
     */
    public ArrayList<Room> mergeSortTeacher(ArrayList<Room> whole) {
        ArrayList<Room> left = new ArrayList<Room>();
        ArrayList<Room> right = new ArrayList<Room>();
        int center;

        if (whole.size() == 1) {
            return whole;
        } else {
            center = whole.size() / 2;
            // copy the left half of whole into the left.
            for (int i = 0; i < center; i++) {
                left.add(whole.get(i));
            }

            //copy the right half of whole into the new arraylist.
            for (int i = center; i < whole.size(); i++) {
                right.add(whole.get(i));
            }

            // Sort the left and right halves of the arraylist.
            left = mergeSortTeacher(left);
            right = mergeSortTeacher(right);

            // Merge the results back together.
            mergeTeacher(left, right, whole);
        }
        return whole;
    }

    /**
     * Method that merges two ArrayLists sorted by teacher name into one big sorted ArrayList by checking whether the first
     * element in each ArrayList is smaller than the first element in the other and adding the smallest into the big ArrayList
     *
     * @param left  One of the sorted by teacher ArrayLists
     * @param right One of the sorted by teacher ArrayList
     * @param whole The ArrayList that will house the both sorted lists combined into a larger sorted ArrayList
     */
    private void mergeTeacher(ArrayList<Room> left, ArrayList<Room> right, ArrayList<Room> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).getTeacher().compareTo(right.get(rightIndex).getTeacher())) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<Room> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }

        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }

    /**
     * Method that merge sorts a given ArrayList by room number
     *
     * @param whole the ArrayList to be sorted
     * @return the sorted ArrayList
     */
    public ArrayList<Room> mergeSortRoom(ArrayList<Room> whole) {
        ArrayList<Room> left = new ArrayList<Room>();
        ArrayList<Room> right = new ArrayList<Room>();
        int center;

        if (whole.size() == 1) {
            return whole;
        } else {
            center = whole.size() / 2;
            // copy the left half of whole into the left.
            for (int i = 0; i < center; i++) {
                left.add(whole.get(i));
            }

            //copy the right half of whole into the new arraylist.
            for (int i = center; i < whole.size(); i++) {
                right.add(whole.get(i));
            }

            // Sort the left and right halves of the arraylist.
            left = mergeSortRoom(left);
            right = mergeSortRoom(right);

            // Merge the results back together.
            mergeRoom(left, right, whole);
        }
        return whole;
    }

    /**
     * Method that gets the teacher given the room
     * @param clickedRoom room clicked on
     * @return the teacher of a given room
     */
    public String getTeachersByRoom(String clickedRoom) {
        ArrayList<Room> a = totalSchool;
        String teachers = "";
        Room next = null;

        Iterator iter = a.iterator();
        while (iter.hasNext()) {
            Room tra = (Room) iter.next();
            if (tra.hasTwoRooms()) {
                if (tra.getRoomNumber2().equals(clickedRoom) || tra.getRoomNumber1().equals(clickedRoom)) {
                    teachers += "[" + tra.getTeacher() + "] ";


                }
            } else {
                if (tra.getRoomNumber1().equals(clickedRoom)) {
                    teachers += "[" + tra.getTeacher() + "] ";
                }
            }

        }
        return teachers;
    }

    /**
     * Method that gets the room given teacher name
     * @param clickedName name clicked on
     * @return string array containing rooms
     */
    public String[] getRoomsByTeacher(String clickedName){
        ArrayList<Room> a = totalSchool;
        Room next = a.get(0);
        int first = 0;
        int last = a.size() - 1;
        while (first < last) {
            if (last - first == 1) {
                if (a.get(first).getTeacher().equals(clickedName)) {
                    next = a.get(first);
                    last = first;
                } else {
                    next = a.get(last);
                    last = first;
                }
            }
            int mid = (first + last) / 2;
            if (a.get(mid).getTeacher().equals(clickedName)) {
                next = a.get(mid);
                break;
            } else if (a.get(mid).getTeacher().compareTo(clickedName) < 0) {
                first = mid;
            } else {
                last = mid;
            }
        }

        String d = "";
        if (next.hasTwoRooms()) {
            d = next.getRoomNumber1() + "/" + next.getRoomNumber2();
        } else {
            d = next.getRoomNumber1();
        }
        String[] total = {clickedName + " is in room ", d, d};
        return total;
    }

    /**
     * Method that merges two ArrayLists sorted by room number into one big sorted ArrayList by checking whether the first
     * element in each ArrayList is smaller than the first element in the other and adding the smallest into the big ArrayList
     *
     * @param left  One of the sorted by rooom ArrayLists
     * @param right One of the sorted by room ArrayLists
     * @param whole The ArrayList that will house the both sorted lists combined into a larger sorted ArrayList
     */
    private void mergeRoom(ArrayList<Room> left, ArrayList<Room> right, ArrayList<Room> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).getRoomNumber1().compareTo(right.get(rightIndex).getRoomNumber1())) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<Room> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }

        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
}