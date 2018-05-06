package com.example.srikar.freshmaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mapper extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        String input = getIntent().getExtras().getString("room");
        String total = "This room is in the " + input.charAt(0) + "-building and is Mr. Higgins room";
        TextView text = findViewById(R.id.RoomDisplay);
        text.setText(total);
        if (input.charAt(0) == 'A') {
            findViewById(R.id.Abuilding).setVisibility(View.VISIBLE);
        } else if (input.charAt(0) == 'B') {
            findViewById(R.id.Bbuilding).setVisibility(View.VISIBLE);
        }
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
