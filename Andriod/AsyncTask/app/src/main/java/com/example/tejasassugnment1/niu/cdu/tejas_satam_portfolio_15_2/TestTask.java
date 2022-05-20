package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio_15_2;


/********************************************************************
 CSCI 522 - Portfolio 15-2 - Semester Spring 2019

 Programmer: Tejas Satam (Z1854197)

 TA: Harshith Desamsetti

 Purpose:
 Design a simple application that will get a number from the user and
 use an asynchronous task to display the number on the screen.
 *********************************************************************/
import android.os.AsyncTask;
import android.os.AsyncTask;
import android.util.Log;

public class TestTask extends AsyncTask<Integer, Void, String>
{
    private MainActivity activity;

    public  TestTask(MainActivity fromActivity)
    {
        this.activity = fromActivity;
        Log.w("MainActivity", "Inside the TestTask constructor");

    }//end constructor

    @Override
    protected String doInBackground(Integer... integers) {

        Log.w("mainactivity", "inside doInBackground");
        //create a string to be displayed
        String displayStr = new String("Your favorite number is" + integers[0] + "\nChanged by asynctask");
        return displayStr;
    }//end doInbackground

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.w("MainActivity","Inside onPostExecute");
        activity.updateView(s);
    }//end onPostExecute
} //end TestTask

