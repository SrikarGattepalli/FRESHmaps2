package com.example.srikar.freshmaps;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.info_page);
        ((TextView) findViewById(R.id.instructions)).setMovementMethod(new ScrollingMovementMethod());
    }
}
