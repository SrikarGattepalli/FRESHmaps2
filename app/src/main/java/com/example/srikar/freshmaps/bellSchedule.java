package com.example.srikar.freshmaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class bellSchedule extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bellschedule);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    }
