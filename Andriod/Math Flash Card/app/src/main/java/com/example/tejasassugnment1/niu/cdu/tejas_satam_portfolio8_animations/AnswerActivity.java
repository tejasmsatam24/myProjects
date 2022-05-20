package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio8_animations;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnswerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);



    }// ends onCreate

    public void goQuestion(View view)
    {
        finish();
        overridePendingTransition(R.anim.question_on,R.anim.answer_off);
    }

}// ends AnswerActivity
