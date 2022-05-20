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
import android.widget.Toast;

import java.text.DecimalFormat;

//This class will calculate the area of Triangle
public class TriangleArea extends AppCompatActivity {


    private EditText ht,bs,ans;
    private Button btn;
    public double height,base,area;
    public String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_area);
        ht=findViewById(R.id.height);
        bs = findViewById(R.id.Base);
        btn = findViewById(R.id.btn);
        //when the button is selected the following function will be executed
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the user has not entered any value then we will display a toast message
                if(ht.getText().toString().matches("")|| bs.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),"cannot have an empty field",Toast.LENGTH_LONG).show();;
                    return;
                }
                else {
                    height = Double.parseDouble(ht.getText().toString());
                    base = Double.parseDouble(bs.getText().toString());
                    area = (0.5 * base) * height;
                    //this formatting will allow only four digits after the decimal point
                    area = Double.parseDouble(new DecimalFormat("#.####").format(area));
                    //we will put the value in the string a pass the string to the main activity
                    s = String.valueOf("The area of Triangle is " + area);
                    //create an Intent to pass the value to the main activity
                    Intent intent = new Intent(TriangleArea.this, MainActivity.class);
                    intent.putExtra("area", s);
                    startActivity(intent);
                }
            }
        });
    }
}
