package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio_6;


/********************************************************************
 CSCI 522 - Portfolio 6 - Spring 2019

 Programmer: Tejas Satam

 TA: Harshith Desamsetti

 Purpose:
 The purpouse of the application is to study the Life cycle of an
 Android Application.
 *********************************************************************/


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String MA_TAG = "Lifecycle";
    private String createMessage, startMessage, resumeMessage, pauseMessage, stopMessage, restartMessage, destroyMessage;
    static final int REQUEST_CODE = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //populate the strings from strings.xml file
        createMessage = (String)getResources().getText(R.string.createMsg);
        startMessage = (String)getResources().getText(R.string.startMsg);
        resumeMessage = (String)getResources().getText(R.string.resumeMsg);
        pauseMessage = (String)getResources().getText(R.string.pauseMsg);
        stopMessage = (String)getResources().getText(R.string.stopMsg);
        restartMessage = (String)getResources().getText(R.string.restartMsg);
        destroyMessage = (String)getResources().getText(R.string.destroyMsg);

        //display a toast message in log message
        Toast.makeText(getApplicationContext(),createMessage,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG,createMessage);

    }//end OnCreate

    @Override
    protected void onStart() {
        super.onStart();
        //on start function is called when a particular activity is called
        Toast.makeText(getApplicationContext(),startMessage,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG,startMessage);
    }//end on start

    @Override
    protected void onResume() {
        super.onResume();
        //on start function is called when a particular activity is resumed
        Toast.makeText(getApplicationContext(),resumeMessage,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG,resumeMessage);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //on start function is called when a particular activity is paused
        Toast.makeText(getApplicationContext(),pauseMessage,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG,pauseMessage);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //on start function is called when a particular activity is stopped
        Toast.makeText(getApplicationContext(),stopMessage,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG,stopMessage);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //on start function is called when a particular activity is restarted
        Toast.makeText(getApplicationContext(),restartMessage,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG,restartMessage);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //on start function is called when a particular activity is destroyed
        Toast.makeText(getApplicationContext(),destroyMessage,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG,destroyMessage);
    }



    public void goNext(View view)
    {
        //This function will be called when we press on the next button
        Intent intent = new Intent(MainActivity.this,second.class);
        startActivityForResult(intent, REQUEST_CODE);

    }
}//end MainActivity
