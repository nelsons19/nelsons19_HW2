package com.example.hw2_nelsons;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * This class defines the Controller for the surface view. It purpose is to
 * create and draw the shapes that are present on the surface view.
 *
 * @author Spencer Nelson
 * @version Spring 2019
 *
 */
public class SurfaceController extends SurfaceView {

    /* Created all the shapes that will be drawn on the surface veiw */
    protected CustomCircle head = new CustomCircle("head",
            0xFFFFE0BD,600,600,600);
    protected CustomCircle lEye = new CustomCircle("left eye",
            0xFFFFFFFF,300,400,200);
    protected CustomCircle rEye = new CustomCircle("right eye",
            0xFFFFFFFF,900,400,200);
    protected CustomCircle lPupil = new CustomCircle( "left pupil",
            0xFF6C3483,350,450,75);
    protected CustomCircle rPupil = new CustomCircle( "right pupil",
            0xFF6C3483,950,450,75);
    protected CustomRect mouth = new CustomRect("mouth",0xFF000000,
            300, 800, 600, 900);

    public SurfaceController(Context context) {
        super(context);
        init();
    }

    public SurfaceController(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SurfaceController(Context context, AttributeSet attrs,
                             int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     External Citation
     Date: 18 February 2019
     Problem: Professor Nuxoll said we should'nt copy and paste code.
     Resource: Professor Nuxoll
     Solution: I used his idea of making and init method for constructors
     */
    private void init() {
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        /* Set canvas background color */
        canvas.drawColor(0xFFFFFFFF);

        /* Draw the elements */
        head.drawMe(canvas);
        lEye.drawMe(canvas);
        rEye.drawMe(canvas);
        lPupil.drawMe(canvas);
        rPupil.drawMe(canvas);
        mouth.drawMe(canvas);

    }

}
