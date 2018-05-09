package com.example.srikar.freshmaps;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * The main menu that changes the view to the one clicked
 */
public class MainActivity extends AppCompatActivity {


    /**
     * Method that creates the view and "listens" for a click and does the appropiate actions
     * @param savedInstanceState the state of the app before the create call
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button schedule = findViewById(R.id.bellSchedule);
        Button name = (Button) findViewById(R.id.searchByTeacher);
        Button room = (Button) findViewById(R.id.searchByRoom);
        schedule.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that is called when a button is clicked
             * @param view the view that was clicked
             */
            public void onClick(View view) {

                Intent startIntent = new Intent(getApplicationContext(), bellSchedule.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent startIntent = new Intent(getApplicationContext(), searchByRoom.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent startIntent = new Intent(getApplicationContext(), searchByTeacher.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

}
