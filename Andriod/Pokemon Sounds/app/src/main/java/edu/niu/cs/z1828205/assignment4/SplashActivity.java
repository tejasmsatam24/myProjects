package edu.niu.cs.z1828205.assignment4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Create the timer Task

        TimerTask task = new TimerTask()
        {
            @Override
            public void run () {
                // finish the activity
                finish();


                // go to the MainActivity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };

        // Create Timer Object
        Timer timer = new Timer();

        // create the schedule of the timer
        timer.schedule(task,5000);
    }
}