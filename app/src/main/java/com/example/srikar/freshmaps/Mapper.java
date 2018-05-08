package com.example.srikar.freshmaps;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class Mapper extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);

        String total = getIntent().getExtras().getString("total");
        ((TextView) findViewById(R.id.RoomDisplay)).setText(total);

        Button back = findViewById(R.id.BackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });

        ImageButton mapButton = (ImageButton) findViewById(R.id.evhsMap);
        mapButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean OnTouch(View v, MotionEvent event) {

            }
        });

    }
}
