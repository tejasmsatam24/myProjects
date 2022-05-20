package com.example.tejasassugnment1.niu.cdu.tejas_explicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/********************************************************************
 CSCI 522 - Portfolio 4 - Spring 2019

 Programmer(s): Tejas Satam

 TA: Harshith Desamsetti

 Purpose:

 The purpose of the application to understand the concept of Explicit
 intents. Explicits intents means calling multiple activities within
 same application.
 *********************************************************************/
public class oMainActivity extends AppCompatActivity {

    //declaring the variables
    private TextView nameTV;
    static final int REQUEST_CODE = 13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assigning objects to variables
        nameTV = findViewById(R.id.textView);

    }
    //so when the "GET NAME" button is clicked the following function will be called
    public void getName(View view)
    {
        //Here we will create a new intent refering to Name.class
        Intent nameIntent = new Intent(MainActivity.this,Name.class);
        startActivityForResult(nameIntent, REQUEST_CODE);
    }


    //This function will be called when we return to the same activity again.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String returnedName;

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            //retrieve the name from the intent
            returnedName = data.getStringExtra("nameID");

            nameTV.setText("Your name is  " +  returnedName );
        }
    }
}
