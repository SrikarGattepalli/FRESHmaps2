package com.example.srikar.freshmaps;

import com.example.srikar.freshmaps.Room;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class School {
    private ArrayList<Room> totalSchool = new ArrayList<Room>();

    public School(InputStream fName) {
        Scanner scan = new Scanner(fName);
        while (scan.hasNext()) {
            String name = scan.next() + " " + scan.next();
            String room = scan.next();
            totalSchool.add(new Room(name, room));
        }

    }

    public ArrayList<Room> getTotalSchool() {
        return totalSchool;
    }

    public void sortArraybyTeacher() {
        totalSchool=mergeSortTeacher(totalSchool);
    }

    public void sortArrayByRoom() {
        totalSchool=mergeSortRoom(totalSchool);
    }


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

    private void mergeRoom(ArrayList<Room> left, ArrayList<Room> right, ArrayList<Room> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).getRoomNumber().compareTo(right.get(rightIndex).getRoomNumber())) < 0) {
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
