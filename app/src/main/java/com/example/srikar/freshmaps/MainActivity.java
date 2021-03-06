package com.example.srikar.freshmaps;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The main menu that changes the view to the one clicked
 */
public class MainActivity extends AppCompatActivity {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);


    /**
     * Method that creates the view and "listens" for a click and does the appropiate actions
     *
     * @param savedInstanceState the state of the app before the create call
     */
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final Button schedule = findViewById(R.id.bellSchedule);
        final Button name = (Button) findViewById(R.id.searchByTeacher);
        final Button room = (Button) findViewById(R.id.searchByRoom);
        final Button info = findViewById(R.id.info);
        final Button phone = findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that is called when a button is clicked
             * @param view the view that was clicked
             */
            public void onClick(View view) {
                phone.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), Phone.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that is called when a button is clicked
             * @param view the view that was clicked
             */
            public void onClick(View view) {
                info.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), Info.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that is called when a button is clicked
             * @param view the view that was clicked
             */
            public void onClick(View view) {
                schedule.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), NewBellSchedule.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        room.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that is called when a button is clicked
             * @param view the view that was clicked
             */
            @Override
            public void onClick(View view) {
                room.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), searchByRoom.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that is called when a button is clicked
             * @param view the view that was clicked
             */
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
