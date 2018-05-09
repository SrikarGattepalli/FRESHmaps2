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
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button schedule = findViewById(R.id.bellSchedule);
        final Button name = (Button) findViewById(R.id.searchByTeacher);
        final Button room = (Button) findViewById(R.id.searchByRoom);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schedule.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), bellSchedule.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), searchByRoom.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), searchByTeacher.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


    }



}
