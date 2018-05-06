package com.example.srikar.freshmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button in = findViewById(R.id.sendButton);
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextName = findViewById(R.id.buildingInput);
                String str;
                if (editTextName.getText().toString().length() != 0) {
                    str = editTextName.getText().toString();
                } else {
                    str = "NoWhere";
                }

                Intent startIntent = new Intent(getApplicationContext(), Mapper.class);
                startIntent.putExtra("room", str);
                startActivity(startIntent);
            }
        });
    }
}
