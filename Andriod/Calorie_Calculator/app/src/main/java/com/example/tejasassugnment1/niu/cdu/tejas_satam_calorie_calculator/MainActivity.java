package com.example.tejasassugnment1.niu.cdu.tejas_satam_calorie_calculator;



/********************************************************************
 CSCI 522 - Portfolio 3 - Spring 2019

 Programmer: Tejas Satam

 TA: Harshith Desamsetti

 Purpose:
 This application will calculate the calories according to the items
 added on the burger.
 *********************************************************************/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declaring the variables
    private RadioGroup pattyRG, cheeseRG;
    private CheckBox baconCB;
    private SeekBar sauceSB;
    private TextView caloriesTV;
    public Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        burger = new Burger();

        //assigning the objects to the variables
        pattyRG = findViewById(R.id.pattyRadioGroup);
        baconCB = findViewById(R.id.baconCheckBox);
        cheeseRG = findViewById(R.id.cheeseRadioGroup);
        sauceSB = findViewById(R.id.sauceSeekBar);
        caloriesTV = findViewById(R.id.calorieTextView);
        displayCalories();

        //set up a named listener for the radio group
        pattyRG.setOnCheckedChangeListener(pattyListener);

        //set up the anonymous listener for the cheese radio group
        cheeseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {

                    //if the user selects no cheese then no calories will be added.
                    case R.id.noCheeseRadioButton:
                        burger.setCheeseCalories(0);
                        break;
                        //if the user selects cheddar cheese then its calories will be added
                    case R.id.cheddarRadioButton:
                        burger.setCheeseCalories(Burger.CHEDDAR);
                        break;
                    //if the user selects mozzarella cheese then its calories will be added
                    case R.id.mozzRadioButton:
                        burger.setCheeseCalories(Burger.MOZZ);
                        break;

                }
                displayCalories();
            }
        });//end of cheese listener


        //set up a named listener for the bacon checkbox
        baconCB.setOnClickListener(baconListener);

        //set up a named listener for the sauce seekbar
        sauceSB.setOnSeekBarChangeListener(sauceListener);


    }//end onCreate

    //function will add the calories as we move the seekbar
    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            burger.setSauceCalories(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };//end of sauceListener


    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (((CheckBox) view).isChecked())
                burger.setBaconCalories(true);
            else
                burger.setBaconCalories(false);


            displayCalories();
        }
    };//end of baconListener


    private RadioGroup.OnCheckedChangeListener pattyListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
            switch (checkedID) {
                case R.id.beefRadioButton:
                    burger.setPattyCalories(Burger.BEEF);
                    break;

                case R.id.turkeyRadioButton:
                    burger.setPattyCalories(Burger.TURKEY);
                    break;
                case R.id.veggieRadioButton:
                    burger.setPattyCalories(Burger.VEGGIE);
                    break;

            }
            displayCalories();
        }
    };//end of pattyListener


    private void displayCalories() {
        String calorieText = "Calories: " + burger.getTotalCalories();
        caloriesTV.setText(calorieText);

    }
}//end MainActivity
