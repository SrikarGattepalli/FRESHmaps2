package com.example.srikar.freshmaps;

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
   public static void main(String[] args) {
        try {
            School test = new School(new InputStream() {
                @Override
                public int read() throws IOException {
                    return 0;
                }
            });
            for (Room r : test.getTotalSchool()) {
                Log.d("testProgram", r.getTeacher() + "    " + r.getRoomNumber1());
            }
            System.out.println();
            test.sortArrayByRoom();
            for (Room r : test.getTotalSchool()) {
                Log.d("testProgram", r.getTeacher() + "    " + r.getRoomNumber1());
            }
            System.out.println();
            test.sortArraybyTeacher();
            for (Room r : test.getTotalSchool()) {
                Log.d("testProgram", r.getTeacher() + "    " + r.getRoomNumber1());
            }
        } catch (Exception e) {
            System.out.println("woops");
        }
    }
}
