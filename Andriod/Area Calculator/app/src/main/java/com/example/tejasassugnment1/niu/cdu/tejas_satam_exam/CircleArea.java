package com.example.tejasassugnment1.niu.cdu.tejas_satam_exam;

/********************************************************************
 CSCI 522 - Exam - Fall 2019

 Programmer: Tejas Satam

 ZID:Z1854197

 TA: Harshith Desamsetti

 Purpose:
 This program contains radio buttons from which the user can select the
 shape and calculate area. The applicaion will display toast messages
 if the user does not enter the values or does not select any radio
 button.
 *********************************************************************/


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;



//This class will calculate the area of Circle
public class CircleArea extends AppCompatActivity {
    private EditText radi;
    public double radius;
    public String r;
    public double area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_area);

        radi = findViewById(R.id.rad);

    }//end onCreate


    //when the button is selected the following function will be executed
    public void goBack(View view)
    {

        //if the user has not entered any value then we will display a toast message
        if(radi.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(),"cannot have an empty field",Toast.LENGTH_LONG).show();;
            return;
        }

        else {

            //create an Intent to pass the value to the main activity
            Intent intent = new Intent(CircleArea.this, MainActivity.class);
            radius = Double.parseDouble(radi.getText().toString());
            area = 3.14159 * radius * radius;
            //this formatting will allow only four digits after the decimal point
            area = Double.parseDouble(new DecimalFormat("#.####").format(area));
            //we will put the value in the string a pass the string to the main activity
            r = String.valueOf("The area of Circle is " + area);
            intent.putExtra("area", r);
            startActivity(intent);
        }
    }

}
