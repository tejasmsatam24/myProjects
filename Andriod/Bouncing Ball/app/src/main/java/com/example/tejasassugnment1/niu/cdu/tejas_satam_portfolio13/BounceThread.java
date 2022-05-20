package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio13;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;

public class BounceThread extends Thread
{
    private SurfaceHolder surfaceHolder;

    private AnimationArena animationArena;

    private boolean isRunning;

    public BounceThread( SurfaceHolder sh)
    {

        surfaceHolder = sh;

        // initialize Boolean variable to indicate application is running
        isRunning = true;

        // create the animation arena
        animationArena = new AnimationArena();


    }// ends Constructor

    public void run()
    {

        try
        {
            while (isRunning)
            {
                // Create the canvas object and lock it sho that nothing else can make a change to it
                Canvas canvas = surfaceHolder.lockCanvas();

                // update the ball location
                animationArena.update( canvas.getWidth(),canvas.getHeight() );

                // draw it
                animationArena.draw(canvas);

                //unlock the canvas so that it can be updated
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
        catch(NullPointerException npe)
        {
            npe.printStackTrace();
        }

    }// ends run

    public void endBounce()
    {
        isRunning = false;
    }

}// ends BounceThread
