package com.example.srikar.freshmaps;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

/**
 * This class is related to the instruction/info page that can be accessed from the home screen
 *
 */
public class Info extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    /**
     * Method to deal with how the app responds when the Info activity is called.
     * @param savedInstanceState
     *          - the original state of this app
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.info_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ((TextView) findViewById(R.id.instructions)).setMovementMethod(new ScrollingMovementMethod());
        ((TextView) findViewById(R.id.instructions)).setKeyListener(null);
    }
}
