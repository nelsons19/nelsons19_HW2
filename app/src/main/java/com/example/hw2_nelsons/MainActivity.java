package com.example.hw2_nelsons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Main Activity file for my app. I just find all the XML objects and set the
 * listeners in this class.
 *
 * @author Spencer Nelson
 * @version Spring 2019
 *
 */
public class MainActivity extends AppCompatActivity {

    /* Create instances of all objects that will be used */
    private SeekBar redValueSB = null;
    private SeekBar greenValueSB = null;
    private SeekBar blueValueSB = null;

    private TextView redValue = null;
    private TextView greenValue = null;
    private TextView blueValue = null;
    private TextView name = null;

    private SurfaceController surface;

    private Listener theListener = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surface_layout);

        /* Find and initialize all seek bars so values can be changed */
        redValueSB = (findViewById(R.id.redValueSB));
        greenValueSB = (findViewById(R.id.greenValueSB));
        blueValueSB = (findViewById(R.id.blueValueSB));

        /* Find and initialize all seek bars so values can be changed */
        redValue = (findViewById(R.id.redValue));
        greenValue = (findViewById(R.id.greenValue));
        blueValue = (findViewById(R.id.blueValue));
        name = (findViewById(R.id.drawingName));

        /* Find and initialize the surface view I will be using */
        surface = (findViewById(R.id.mySurfaceview));

        /* Create a listener object */
        theListener = new Listener(surface, redValueSB, greenValueSB,
                blueValueSB, name, redValue, greenValue,
                blueValue);

        /* Set the surface view's listener to the custom Listener object */
        surface.setOnTouchListener(theListener);

    }
}
