package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio15_1;

/********************************************************************
 CSCI 522 - Portfolio 15-1 - Semester Spring 2019

 Programmer: Tejas Satam (Z1854197)

 TA:  Harshith Desamsetti

 Purpose:
 Design a simple application that will demonstrate asynchronous tasks
 by simulating the downloading of information.
 *********************************************************************/


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView downloadTV, callbackTV;
    private ProgressBar downloadPB;
    private Button downloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the data members to the screen widgets
        downloadBtn = findViewById(R.id.downloadButton);
        downloadPB = findViewById(R.id.downloadProgressBar);
        downloadTV = findViewById(R.id.downloadTextView);
        callbackTV = findViewById(R.id.callbackTextView);


    } //end onCreate

    public void startDownload(View view){
        //disable the download button
        downloadBtn.setEnabled(false);

        //create asynctask object
        DownloadAsyncTask task = new DownloadAsyncTask();

        //start the asynctask
        task.execute();
    }//end startdownload

    //Reset Button
    public void doReset(View view){
        //Reset the textviews
        downloadTV.setText(R.string.download_start_label);
        callbackTV.setText(R.string.callbacks_label);

        //reset the progressbar
        downloadPB.setProgress(0);


        //unlock the screen orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }

    //Inner Async task class
    private class DownloadAsyncTask extends AsyncTask<Void, Integer, Void>{
        int progressStatus;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

            //append a message
            callbackTV.setText(callbackTV.getText() + "\n\nLock screen orientation");

            //lock the screen orientation
            int currentOrientation = getResources().getConfiguration().orientation;

            if(currentOrientation == Configuration.ORIENTATION_PORTRAIT)
            {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            else
            {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            //append another message
            callbackTV.setText(callbackTV.getText() + "\nInvoke onPreExecute()");

            //initialize the progress
            progressStatus = 0;

            //indicate the download progress
            downloadTV.setText(R.string.download_start_label);

            //append some messages before moving to doInBackGround
            callbackTV.setText( callbackTV.getText() + "\nCompleted onPreExecute");
            callbackTV.setText( callbackTV.getText() + "\nInvoke do inBackground");
            callbackTV.setText( callbackTV.getText() + "\nDoing Background Work");

        }//onPreExecute

        @Override
        protected Void doInBackground(Void... voids)
        {
            while (progressStatus < 100)
            {
                progressStatus += 2;

                //display the progress
                publishProgress(progressStatus);

                //delay
                SystemClock.sleep(300);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);

            //update the progressbar
            downloadPB.setProgress(values[0]);

            //update the textview for the download
            downloadTV.setText("downloading" + values[0] + "%");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //append messages to the middle textview
            callbackTV.setText(callbackTV.getText() + "\nCompleted Background work");
            callbackTV.setText(callbackTV.getText() + "Invoke onPostExecute");

            //complete the download message
            downloadTV.setText("download complete");

            //re-enable the download button
            downloadBtn.setEnabled(true);
        }//end onPost

    }//end Async Task

} //end MainActivity
