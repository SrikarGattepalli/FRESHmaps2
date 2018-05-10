package com.example.srikar.freshmaps;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Class to test the java classes
 */
public class Tester {
    public static void main(String[] args){
        try{
            School test = new School("TestFile.txt");
            for(Room r : test.getTotalSchool()){
                System.out.println(r.getTeacher()+"    "+r.getRoomNumber());
            }
            System.out.println();
            test.sortArrayByRoom();
            for(Room r : test.getTotalSchool()){
                System.out.println(r.getTeacher()+"    "+r.getRoomNumber());
            }
            System.out.println();
            test.sortArraybyTeacher();
            for(Room r : test.getTotalSchool()){
                System.out.println(r.getTeacher()+"    "+r.getRoomNumber());
            }
        }
        catch(Exception e){
        System.out.println("woops");
        }


    }
}
