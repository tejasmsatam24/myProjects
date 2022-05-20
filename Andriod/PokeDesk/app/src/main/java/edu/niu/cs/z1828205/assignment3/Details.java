package edu.niu.cs.z1828205.assignment3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends Activity {

    //declaring the variables
    private TextView type,name,details,height,weight;
    private ImageView img;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //assigning the objects to the variables
        name = findViewById(R.id.title);
        type = findViewById(R.id.type);
        details = findViewById(R.id.details);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        img = findViewById(R.id.imageView3);
        btn = findViewById(R.id.button2);

        //getting the intent from the main activity
        String xd = getIntent().getStringExtra("pokemon");
        //Log.d(xd,xd);

        switch (xd)
        {
            //we will set the contents of the activity as per the returned selection number
            case "0": name.setText(R.string.one_name);
                      type.setText(R.string.ome_type);
                      details.setText(R.string.one_detail);
                      height.setText(R.string.one_height);
                      weight.setText(R.string.one_weight);
                      img.setImageResource(R.drawable.pikachuu);
            break;
            case "1": name.setText(R.string.sec_name);
                type.setText(R.string.two_type);
                details.setText(R.string.two_detail);
                height.setText(R.string.one_height);
                weight.setText(R.string.one_weight);
                img.setImageResource(R.drawable.charmtwo);
            break;
            case "2": name.setText(R.string.third_name);
                type.setText(R.string.three_type);
                details.setText(R.string.three_detail);
                height.setText(R.string.three_height);
                weight.setText(R.string.three_weight);
                img.setImageResource(R.drawable.bulbasaur);
                break;
            case "3": name.setText(R.string.fourth_name);
                type.setText(R.string.four_type);
                details.setText(R.string.four_detail);
                height.setText(R.string.four_height);
                weight.setText(R.string.four_weight);
                img.setImageResource(R.drawable.squirtle);
                break;
            case "4": name.setText(R.string.fifth_name);
                type.setText(R.string.five_type);
                details.setText(R.string.five_detail);
                height.setText(R.string.five_height);
                weight.setText(R.string.five_weight);
                img.setImageResource(R.drawable.raichu);
                break;
            case "5": name.setText(R.string.sixth_name);
                type.setText(R.string.six_type);
                details.setText(R.string.six_detail);
                height.setText(R.string.six_height);
                weight.setText(R.string.six_weight);
                img.setImageResource(R.drawable.chariard);
                break;
            case "6": name.setText(R.string.seventh_name);
                type.setText(R.string.seven_type);
                details.setText(R.string.seven_detail);
                height.setText(R.string.seven_height);
                weight.setText(R.string.seven_weight);
                img.setImageResource(R.drawable.blast);
                break;
            case "7": name.setText(R.string.eight_name);
                type.setText(R.string.eight_type);
                details.setText(R.string.eight_detail);
                height.setText(R.string.eight_height);
                weight.setText(R.string.eight_weight);
                img.setImageResource(R.drawable.venus);
                break;

        }

        //when the button "Back is pressed, the following function will be executed
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //the finish function will take us back to the previous activity.
                finish();
            }
        });
    }// ends OnCreate


}// ends Details
