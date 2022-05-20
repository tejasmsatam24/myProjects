package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio13;
/********************************************************************
 CSCI 522 - Portfolio 13 - Spring 2019

 Programmer: Tejas Satam

 TA: Harshith Desamsetti

 Purpose: To develop a program that will simulate a ball bouncing
 around the screen at constant velocity.
 *********************************************************************/


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a frame layout and connect it to the screen
        FrameLayout layout = findViewById(R.id.frameLayout);

        // create the bounce surface view
        BounceSurfaceView bounceSurfaceView = new BounceSurfaceView(this,null);

        // add the surface view to the frame layout
        layout.addView(bounceSurfaceView);


    }// ends onCreate
}// ends MainActivity