package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class second extends AppCompatActivity {
    private static final String SA_TAG = "Second Lifecycle";
    private String createMessage, startMessage, resumeMessage, pauseMessage, stopMessage, restartMessage, destroyMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //populate the strings from strings.xml file
        createMessage = (String)getResources().getText(R.string.createMsg2);
        startMessage = (String)getResources().getText(R.string.startMsg2);
        resumeMessage = (String)getResources().getText(R.string.resumeMsg2);
        pauseMessage = (String)getResources().getText(R.string.pauseMsg2);
        stopMessage = (String)getResources().getText(R.string.stopMsg2);
        restartMessage = (String)getResources().getText(R.string.restartMsg2);
        destroyMessage = (String)getResources().getText(R.string.destroyMsg2);

        //display a toast message in log message
        Toast.makeText(getApplicationContext(),createMessage,Toast.LENGTH_SHORT).show();
        Log.d(SA_TAG,createMessage);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),startMessage,Toast.LENGTH_SHORT).show();
        Log.d(SA_TAG,startMessage);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),restartMessage,Toast.LENGTH_SHORT).show();
        Log.d(SA_TAG,restartMessage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),resumeMessage,Toast.LENGTH_SHORT).show();
        Log.d(SA_TAG,resumeMessage);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),pauseMessage,Toast.LENGTH_SHORT).show();
        Log.d(SA_TAG,pauseMessage);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),stopMessage,Toast.LENGTH_SHORT).show();
        Log.d(SA_TAG,stopMessage);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),destroyMessage,Toast.LENGTH_SHORT).show();
        Log.d(SA_TAG,destroyMessage);
    }

    public void goBack(View view)
    {
        finish();
    }
}
