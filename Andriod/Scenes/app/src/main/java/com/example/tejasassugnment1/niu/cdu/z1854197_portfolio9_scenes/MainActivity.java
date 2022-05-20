package com.example.tejasassugnment1.niu.cdu.z1854197_portfolio9_scenes;



/********************************************************************
 CSCI 522 - Portfolio 9 - Semester Spring 2019

 Programmer: Tejas Satam(Z1854197)

 TA: Harshith Desamsetti

 Purpose:
 The purpose of the application is the study animations and transitions.
 *********************************************************************/

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {

    private ViewGroup paintingContainer;

    private Transition transition;

    private Scene activeScene, passiveScene1, passiveScene2, passiveScene3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect tbe ViewGroup and the RelativeLayout from activity_main.xml
        paintingContainer = findViewById(R.id.painting_layout);

        //inflate the transition
        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        //populate the scene
        activeScene = Scene.getSceneForLayout( paintingContainer, R.layout.scene1, this );
        passiveScene1 = Scene.getSceneForLayout( paintingContainer, R.layout.scene2, this );
        passiveScene2 = Scene.getSceneForLayout( paintingContainer, R.layout.scene3, this );
        passiveScene3 = Scene.getSceneForLayout( paintingContainer, R.layout.scene4, this );

        //make the activeScene visible
        activeScene.enter();
    }//end onCreate

    public void changeScene(View view){
        Scene temp;

        temp = activeScene;

        activeScene = passiveScene1;
        passiveScene1 = passiveScene2;
        passiveScene2 = passiveScene3;
        passiveScene3 = temp;

        //make the new activeScene visible
        TransitionManager.go(activeScene, transition);
    }//end changeScene

}//end MainActivity