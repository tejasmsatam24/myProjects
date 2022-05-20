package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio13;

import android.graphics.Canvas;

public class AnimationArena {

    private Ball myBall;


    public AnimationArena()
    {
        //create the ball object
        myBall = new Ball();
    }// end constructor

    // method to update location of the ball
    public void update(int width, int height)
    {
        myBall.move(0,0,width,height);

    }// ends update

    // method to draw
    public void draw(Canvas canvas)
    {
        // set the background color for the canvas
        canvas.drawRGB(156,174,216);

        // draw the ball
        myBall.draw(canvas);

    }// ends draw

}// ends AnimationArena


