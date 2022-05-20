package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio12;

/********************************************************************
 CSCI 522 - Portfolio 12 - Spring 2019

 Programmer: Tejas Satam

 TA: Harshith Desamsetti

 Purpose: To design a simple application that will use a thread to
 update and display a counter every second.
 *********************************************************************/


import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView countTV;
    private Integer counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // connect the TextView
        countTV = findViewById(R.id.countTextView);

        // init the counter to 0
        counter = 0;

        // create the thread and pass a runnable
        Thread thread = new Thread( countNumbers );

        // start execution of the thread
        thread.start();


    }// ends onCreate

    @Override
    protected void onStart() {
        super.onStart();
        //reset the counter to 0;
        counter = 0;

    }

    private Runnable countNumbers = new Runnable() {
        private static final int DELAY = 1000;
        @Override
        public void run() {

            while(true)
            {
                // increment the counter
                counter++;
                try
                {

                    Thread.sleep(DELAY);

                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

                //update the UI Thread by sending an empty message
                threadHandler.sendEmptyMessage(0);
            }// ends while

        }// ends run method


    };// ends countNumbers

    public Handler threadHandler = new Handler()
    {
        // code the handleMessage so the UI thread knows what to do
        public  void handleMessage(Message m)
        {
            countTV.setText(counter.toString());
        }
    };
}//ends MainActivity
