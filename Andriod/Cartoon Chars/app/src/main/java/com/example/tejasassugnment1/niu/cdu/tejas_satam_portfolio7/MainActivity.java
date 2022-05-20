package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio7;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
/********************************************************************
 CSCI 522 - Portfolio 7 - Spring 2019

 Programmer: Tejas Satam

 TA: Harshith Desamsetti,

 Purpose:
 The program contains set of images in a horizontal scroll view. When
 clicked on the image, a toast message will be displayed.
 *********************************************************************/

public class MainActivity extends AppCompatActivity {

    private LinearLayout gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = findViewById(R.id.characterLayout);

        fillGallery();
    }//end onCreate

    private void fillGallery(){
        ImageButton characterIB;

        for(int cnt = 0; cnt < CharacterInfo.description.length; cnt++){
            //create the imageButton
            characterIB = new ImageButton(this);

            //create a Character object
            Character character = new Character(CharacterInfo.description[cnt], CharacterInfo.id[cnt]);

            //Put the information for the Character on the ImageButton
            characterIB.setContentDescription( character.getCharacterDescription() );

            characterIB.setImageDrawable(ResourcesCompat.getDrawable(getResources(), character.getCharacterID(), null));

            //handle button click of the imageButton
            characterIB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String descrip = (String)v.getContentDescription();

                    Toast.makeText(getApplicationContext(), descrip, Toast.LENGTH_LONG).show();
                }
            });

            //Add the imagebutton to the LinearLayout
            gallery.addView(characterIB);
        }// end forLoop
    }//end fillGallery
}

