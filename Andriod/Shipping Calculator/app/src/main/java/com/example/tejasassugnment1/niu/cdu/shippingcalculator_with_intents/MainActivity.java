package com.example.tejasassugnment1.niu.cdu.shippingcalculator_with_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


/********************************************************************
 CSCI 522 - Portfolio 4 Application1  - Semester Spring 2019

 Programmer: Tejas Satam

 TA: Harshith Desamsetti

 Purpose:

 The purpose of the application is to update the Shipping Calcuator
 and add a button that will take to the help page and from help page
 we can return back.
 *********************************************************************/
public class MainActivity extends AppCompatActivity {


    ShippingItem item;

    EditText weightET;
    TextView baseTV, addedTV, totalTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // connect the EditText and Textviews

        weightET = findViewById(R.id.weightEditText);
        baseTV = findViewById(R.id.baseCostTextView);
        addedTV = findViewById(R.id.addedCostTextView);
        totalTV = findViewById(R.id.totalCostTextView);

        item = new ShippingItem();

        //put the focus on editText

        weightET.requestFocus();

        // add a TextWatcher to the EditText field

        weightET.addTextChangedListener(weightWatcher);

    }//ends onCreate

    TextWatcher weightWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {

                item.setWeight( Integer.parseInt(s.toString()) );


            }

            catch (NumberFormatException nfe){

                item.setWeight(0);

            }

            DecimalFormat df = new DecimalFormat("#0.00");

            // put the costs in the textviews

            baseTV.setText("$"+ df.format(item.getBaseCost()));
            addedTV.setText("$"+df.format(item.getAddedCost()));
            totalTV.setText("$"+df.format(item.getTotalCost()));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    //When the button is pressed we will navigate to main activity
    public void getHelp(View view)
    {
        Intent helpIntent = new Intent(MainActivity.this,Help.class);

        // go to Help
        startActivity(helpIntent);

    }
}
