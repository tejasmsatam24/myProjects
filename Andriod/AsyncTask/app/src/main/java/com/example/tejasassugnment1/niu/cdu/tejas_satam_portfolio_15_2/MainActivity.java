package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio_15_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end onCreate

    public void doChange(View view)
    {
        EditText dataET = findViewById(R.id.dataEditText);
        int faveNum = Integer.parseInt(dataET.getText().toString());

        Log.w("MainActivity", "Create the test task object");
        TestTask testTask = new TestTask(this);

        Log.w("MainActivity", "Starting test task");

        //start the asynctasl
        testTask.execute(faveNum);
    }//end doChange

    //Method to update the screem

    //method to update the screen
    public void updateView(String message)
    {
        Log.w("MainActivity", "In UpdateView" + message);
        TextView messageTV = findViewById(R.id.messageTextView);
        messageTV.setText(message);

    }//end updateView

}// end Activity
