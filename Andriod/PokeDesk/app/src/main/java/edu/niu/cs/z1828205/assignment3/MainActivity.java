package edu.niu.cs.z1828205.assignment3;

/********************************************************************
 CSCI 522 - Assignment 03 - Spring 2019

 Programmers: Tejas Satam (Z1854197)
              Ashton Dsouza (Z1828205)

 Purpose:
 This program makes the use of spinner to show list of items. When you
 click on the item the picture will change accordingly and when the
 view details option is clicked, the second activity will be called
 that will display the information of the item.
 *********************************************************************/
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {


    //declaring the variables
    private Spinner listSpin;
    private ImageView img;
    private Button btn;
    public int choice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning the objects to the variables
        img = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);
        listSpin = findViewById(R.id.spinner);

        // Populating the spinner using list


        //creating a list to hold the data elements
        List<String> listValues = new ArrayList<>();

        //adding the values to the list
        listValues.add("Pikachu");
        listValues.add("Charmander");
        listValues.add("Bulbasaur");
        listValues.add("Squirtle");
        listValues.add("Raichu");
        listValues.add("Charizard");
        listValues.add("Blastoise");
        listValues.add("Venusaur");

        //creating an array adapter
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getApplicationContext(),R.layout.spinner,listValues);

        //setting the items of the spinner to the content of the list
        listSpin.setAdapter(adapter3);

        //so when we select an item from the spinner, the spinner listener will listen to it
        listSpin.setOnItemSelectedListener( spinnerListener );

    }// ends onCreate


    //so this function will get the name selected from the list and change the images accordingly
    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //String selection;
            //selection = parent.getItemAtPosition(position).toString();

            //now here the position variable holds the index of the item selected in the spinner list

            //we will store the value of position in a variable so we can pass it to next activity
            choice = position;

            //we will use switch case to change the images, the images will change according to the selected index
            switch (position){
                case 0: img.setImageResource(R.drawable.pikachuu);
                break;
                case 1: img.setImageResource(R.drawable.charm);
                break;
                case 2: img.setImageResource(R.drawable.bulbasaur);
                    break;
                case 3: img.setImageResource(R.drawable.squirtle);
                    break;
                case 4: img.setImageResource(R.drawable.raichu);
                    break;
                case 5: img.setImageResource(R.drawable.chariard);
                    break;
                case 6: img.setImageResource(R.drawable.blastoise);
                    break;
                case 7: img.setImageResource(R.drawable.venusaur);
                    break;

            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    //When we click on the "View Details" Button the following function will be executed
    public void showDetails(View view)
    {

        //now to pass the choice variable that we declared earlier to the next activity we will create an Intent
        Intent answerIntent = new Intent(MainActivity.this, Details.class);
        //converting the value of choice from int to string
        String passer = Integer.toString(choice);
        //passing the string
        answerIntent.putExtra("pokemon",passer);

        //This will start thr next activity
        startActivity(answerIntent);
    }
    
}// ends MainActivity
