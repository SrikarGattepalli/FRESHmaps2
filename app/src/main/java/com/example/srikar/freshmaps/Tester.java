package com.example.srikar.freshmaps;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class to test the java classes
 */
public class Tester {
    Context context;

    /**
     * Default Constructor that takes in a context where it is called.
     * @param cont
     */
    public Tester(Context cont){
       context = cont;
    }

    /**
     * Method that returns the entire test runthrough as a string
     * @return
     */
    public String test(){
       String output = "";

       try {

            School main = new School(context.getAssets().open("teacherNames.txt"));
            output += "\tRaw-----------------------------------------------------------------------------------------\n";
            for (Room r : main.getTotalSchool()) {
                output += r.getTeacher() + "    " + r.getRoomNumber1() + "\n";
            }

            main.sortArrayByRoom();
            output += "\tSorting By Room-----------------------------------------------------------------------------\n";
            for (Room r : main.getTotalSchool()) {
                output += r.getTeacher() + "    " + r.getRoomNumber1() + "\n";
            }
            main.sortArraybyTeacher();
            output += "\tSorting by teacher--------------------------------------------------------------------------\n";
            for (Room r : main.getTotalSchool()) {
                output += r.getTeacher() + "    " + r.getRoomNumber1() + "\n";
            }

            output += "\tManual test for getting teacher/room--------------------------------------------------------------------------\n";
            output += "Room F115 is in use by " + main.getTeachersByRoom("F115") + "\n";
            output += "The Gym is in use by " + main.getTeachersByRoom("GYM") + "\n";
            output += "Room B138 is in use by " + main.getTeachersByRoom("B138") + "\n";

        } catch (Exception e) {
            output = e.getMessage();
        }
        return output;
    }
}
