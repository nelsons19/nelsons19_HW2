package com.example.hw2_nelsons;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * This class defines the listener for the custom surface view as well as the
 * seek bars. It handles all on touch and progress changed events from the user.
 *
 * @author Spencer Nelson
 * @version Spring 2019
 *
 */
public class Listener implements View.OnTouchListener,
        SeekBar.OnSeekBarChangeListener {

    /* Instance variables for the listener class */
    private SurfaceController SurfaceController;

    private CustomElement selectedElement;

    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;

    private TextView drawingName;
    private TextView redTV;
    private TextView greenTV;
    private TextView blueTV;

    private int red;
    private int green;
    private int blue;

    /**
     * The constructor takes a surface controller and all of the views that are
     * visible on the surface view
     */
    public Listener(SurfaceController passedInSurfaceController,
                    SeekBar redSB, SeekBar greenSB, SeekBar blueSB,
                    TextView passedInName, TextView passedRedTV,
                    TextView passedGreenTV, TextView passedBlueTV){

        /* set all the instance variables based on constructor values */
        SurfaceController = passedInSurfaceController;
        redBar = redSB;
        greenBar = greenSB;
        blueBar = blueSB;
        drawingName = passedInName;

        redBar = redSB;
        redTV = passedRedTV;
        redBar.setOnSeekBarChangeListener(this);

        greenBar = greenSB;
        greenTV = passedGreenTV;
        greenBar.setOnSeekBarChangeListener(this);

        blueBar = blueSB;
        blueTV = passedBlueTV;
        blueBar.setOnSeekBarChangeListener(this);

    }

    @Override
    /**
     * Method that is called when surface view is touched
     */
    public boolean onTouch(View v, MotionEvent event) {

        /* store the x,y coordinates of a touch in a local variable*/
        int xTap = (int)event.getX();
        int yTap = (int)event.getY();

        /* determine which drawing was touched by user and set it as the
         * selected element so it can be accessed later.Then adjust the seek
         * bars based in the color of the touched element */
        if( SurfaceController.lPupil.containsPoint(xTap, yTap)){
            selectedElement = SurfaceController.lPupil;
            setSeekBars(SurfaceController.lPupil);
        }
        else if (SurfaceController.lEye.containsPoint(xTap, yTap)){
            selectedElement = SurfaceController.lEye;
            setSeekBars(SurfaceController.lEye);
        }
        else if (SurfaceController.rPupil.containsPoint(xTap, yTap)){
            selectedElement = SurfaceController.rPupil;
            setSeekBars(SurfaceController.rPupil);
        }
        else if (SurfaceController.rEye.containsPoint(xTap, yTap)){
            selectedElement = SurfaceController.rEye;
            setSeekBars(SurfaceController.rEye);
        }
        else if (SurfaceController.mouth.containsPoint(xTap, yTap)){
            selectedElement = SurfaceController.mouth;
            setSeekBars(SurfaceController.mouth);
        }
        else if (SurfaceController.head.containsPoint(xTap, yTap)){
            selectedElement = SurfaceController.head;
            setSeekBars(SurfaceController.head);
        }

        /* Force a redraw after seek bar modifications */
        SurfaceController.invalidate();
        return true;
    }
    /**
     * Custom method to set the seek bar progress and display the name of the
     * touched drawing.
     */
    private void setSeekBars(CustomElement passedInElement){

        /**
         External Citation
         Date: 18 February 2019
         Problem: I didn't know how to get RGB values from an int.
         Resource: https://stackoverflow.com/questions/20326784
         /how-can-i-get-red-value-from-rgb-value-android
         Solution: I used the example code from this post.
         */
        /* create a temporary color integer so I can obtain the RGB values */
        int tempColor = passedInElement.getColor();

        /* set the RGB values based on the selected element. These values will
         * be used later to adjust the color of the selected element based on
         * seek bar positions */
        red = (tempColor >> 16) & 0xFF;
        green = (tempColor >> 8) & 0xFF;
        blue = (tempColor >> 0) & 0xFF;

        redBar.setProgress(red);
        greenBar.setProgress(green);
        blueBar.setProgress(blue);
        drawingName.setText(selectedElement.myName);

    }


    @Override
    /**
     * Method that is called when seek bars are moved
     */
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {

        /* Determine which bar was moved and set the text of the appropriate
         * text view to display the value. Also set the value of the appropriate
         * local variable so that a new color can be generated based on seek bar
         * values */
        if(seekBar == redBar) {
            redTV.setText("" + progress );
            red = progress;
        }
        else if (seekBar == greenBar){
            greenTV.setText("" + progress);
            green = progress;
        }
        else if (seekBar == blueBar ){
            blueTV.setText("" + progress );
            blue = progress;
        }

        /* create a new color based on values set by the seek bar*/
        int returnColor = Color.rgb(red, green, blue);

        /* set the color of the selected element to the color based of the seek
         * bars */
        selectedElement.setColor(returnColor);

        SurfaceController.invalidate();
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //IGNORE
    }


    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //IGNORE
    }


}


