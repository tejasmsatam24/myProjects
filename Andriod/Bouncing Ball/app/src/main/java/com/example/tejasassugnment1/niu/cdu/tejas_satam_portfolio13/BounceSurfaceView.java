package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio13;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BounceSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private BounceThread bounceThread;

    public BounceSurfaceView(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);

        // create a surface holder
        SurfaceHolder holder = getHolder();

        // attach the callback method to surface holder
        holder.addCallback(this);

        // attach the surface holder to the bouncethread
        bounceThread = new BounceThread(holder);

    }// ends BounceSurfaceView

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        // start Thread execution
        bounceThread.start();

    }// ends surfaceCreated

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }// ends surfaceChanged

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        //stop execution of thread and end animation
        bounceThread.endBounce();

        //nullify the thread
        Thread dummyThread = bounceThread;
        bounceThread = null;
        dummyThread.interrupt();

    }// ends surfaceDestroyed
}// ends BounceSurfaceView

