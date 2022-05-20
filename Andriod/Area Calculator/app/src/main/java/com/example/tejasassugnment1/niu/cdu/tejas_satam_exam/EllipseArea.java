package com.example.tejasassugnment1.niu.cdu.tejas_satam_exam;


/********************************************************************
 CSCI 522 - Exam - Spring 2019

 Programmer: Tejas Satam

 ZID:Z1854197

 TA: Harshith Desamsetti

 Purpose:
 This program contains radio buttons from which the user can select the
 shape and calculate area. The applicaion will display toast messages
 if the user does not enter the values or does not select any radio
 button.
 *********************************************************************/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

//This class will calculate the area of Ellipse
public class EllipseArea extends AppCompatActivity {


    private Button btn;
    private EditText a,b;
    public double aaxis,baxis,area;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipse_area);
        a=findViewById(R.id.a);
        b=findViewById(R.id.b);
        btn = findViewById(R.id.btn);
        //when the button is selected the following function will be executed
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if the user has not entered any value then we will display a toast message
                if(a.getText().toString().matches("")|| b.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),"cannot have an empty field",Toast.LENGTH_LONG).show();;
                    return;
                }
                else {
                    //getText Function is used to get the string from the edit text box, since the data will be taken in string format,so we will parese it
                    aaxis = Double.parseDouble(a.getText().toString());
                    baxis = Double.parseDouble(b.getText().toString());
                    area = 3.14159 * aaxis * baxis;
                    //this formatting will allow only four digits after the decimal point
                    area = Double.parseDouble(new DecimalFormat("#.####").format(area));
                    //we will put the value in the string a pass the string to the main activity
                    s = String.valueOf("The area of Ellipse is " + area);
                    Intent intent = new Intent(EllipseArea.this, MainActivity.class);
                    intent.putExtra("area", s);
                    startActivity(intent);
                }
            }
        });

    }
}
