package com.example.tejasassugnment1.niu.cdu.tejas_explicit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Name extends AppCompatActivity {


    //declaring the variables
    private EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        //assigning objects to variables
        nameET = findViewById(R.id.editText2);
    }

    //so when the "GO BACK" button is clicked the following function will be called
    public void goBack(View view)
    {
        //declaring the string variable to store the value
        String nameInput;
        nameInput = nameET.getText().toString();


        Intent intent;
        intent = getIntent();

        intent.putExtra("nameID",nameInput);

        ((Activity)view.getContext()).setResult(RESULT_OK,intent);

        //goback

        finish();
    }
}
