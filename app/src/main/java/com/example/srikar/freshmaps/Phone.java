package com.example.srikar.freshmaps;

import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.widget.TextView;

/**
 * This is the class for the activity of the phone numbers of EVHS.
 */
public class Phone extends AppCompatActivity {
    /**
     * onCreate method to handle popping up the phone numbers when the activity is created/started.
     *
     * @param savedInstanceState state of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_phone);
        ((TextView) findViewById(R.id.phone)).setMovementMethod(new ScrollingMovementMethod());
        ((TextView) findViewById(R.id.phone)).setKeyListener(null);
    }
}
