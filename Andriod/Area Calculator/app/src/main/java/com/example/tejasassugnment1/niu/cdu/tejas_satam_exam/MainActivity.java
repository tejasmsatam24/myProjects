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




//importing the files
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private RadioGroup shapes;
    private Button btn;
    private TextView txtview;
    private String shapename;
    private RadioGroup shapeid;
    String area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shapes = findViewById(R.id.shapeRadioGroup);
        txtview = findViewById(R.id.areaTextView);
        shapeid = findViewById(R.id.shapeRadioGroup);

        //creating a listener
        shapes.setOnCheckedChangeListener(arealistener);
        area = getIntent().getStringExtra("area");
        txtview.setText(area);

        //if none of the buttons from the radio group is selected we will keep the shapename as null for reference that no button is selected.
        if(shapeid.getCheckedRadioButtonId()==-1)
        {
            shapename = "Null";
        }


    }
    public RadioGroup.OnCheckedChangeListener arealistener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {


            //according to the button selected we will change the shapename
            switch (checkedID) {
                case R.id.triangleRadioButton:
                    shapename = "Triangle";
                    break;

                case R.id.circleRadioButton:
                    shapename = "Circle";
                    break;
                case R.id.ellipseRadioButton:
                    shapename = "Ellipse";
                    break;

            }
        }
    };

    //when the button is clicked the following function will be executed
    public void doCalc(View view)
    {
        //depending on the shapename we will set the intent to start the new activity
        switch (shapename)
        {
            case "Triangle":

                //intent will help us nevigate from one activity to another
                Intent TriangleIntent = new Intent(MainActivity.this, TriangleArea.class);
                startActivity(TriangleIntent);
                break;

            case "Circle":
                Intent CircleIntent = new Intent(MainActivity.this, CircleArea.class);
                startActivity(CircleIntent);
                break;
            case "Ellipse":
                Intent EllipseIntent = new Intent(MainActivity.this, EllipseArea.class);
                startActivity(EllipseIntent);
                break;
            //if no button from the radio is selected we will display a toast message
            case "Null":
                Toast.makeText(getApplicationContext(), "Please select a Shape.", Toast.LENGTH_SHORT).show();
                break;

        }
    }






}
