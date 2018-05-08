package com.example.srikar.freshmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button name = (Button) findViewById(R.id.searchByTeacher);
        Button room = (Button) findViewById(R.id.searchByRoom);
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
