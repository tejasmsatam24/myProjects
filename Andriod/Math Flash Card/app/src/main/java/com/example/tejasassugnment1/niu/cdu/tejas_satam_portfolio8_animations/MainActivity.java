package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio8_animations;

/********************************************************************
 CSCI 522 - Portfolio 08 - Semester Spring 2019

 Programmer: Tejas Satam(Z1854197)

 TA: Harshith Desamsetti

 Purpose:
 The purpose of the application is to design an application to study
 animations.
 *********************************************************************/

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }//ends onCreate

    public void showAnswer(View view)
    {
        Intent answerIntent = new Intent(MainActivity.this, AnswerActivity.class);
        startActivity(answerIntent);

        overridePendingTransition(R.anim.answer_on,R.anim.question_off);

    }// ends showAnswer

}// ends MainActivity

