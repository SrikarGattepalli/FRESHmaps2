package com.example.srikar.freshmaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Mapper extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // String clickedName = getIntent().getExtras().getString("teacherName");
        //  School find = new School("teacherNames.txt");
        // ArrayList<Room> a = find.getTotalSchool();
        //   Room next = a.get(0);
        // for (Room b : a) {
        // if (b.getTeacher().equals(clickedName)) {
        //  next = b;

        //       }
        // }
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

    }
}
