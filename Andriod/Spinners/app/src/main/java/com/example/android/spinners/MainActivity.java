package com.example.android.spinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private Spinner xmlspin,classSpin,listSpin;
    List<String> listvalues= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner populated by data from strings.xml file
        xmlspin=findViewById(R.id.xmlspinner);

        //create the array adapter with the information
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getApplicationContext(),R.array.spinnerArray,R.layout.spinner_view);
        xmlspin.setAdapter(adapter1);

        xmlspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection1;

                selection1=parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),"The selection is " + selection1,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //populate the spinner using information from a class
        classSpin = findViewById(R.id.classspinner);

        ArrayAdapter<String> adapter2=new ArrayAdapter<>(getApplication(),R.layout.spinner_view,SpinnerInfo.valueArray);
        classSpin.setAdapter(adapter2);
        classSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection2;
                selection2=parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),"The 2nd selection is "+ selection2,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner populated from a list object

        listvalues.add("Wine");
        listvalues.add("Beer");
        listvalues.add("vodka");
        listvalues.add("Diet Pepsi");
        listvalues.add("Water");
        listSpin = findViewById(R.id.listspinner);
        //ArrayAdapter<String> adapter3= new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,listvalues);
        ArrayAdapter<String> adapt3 = new ArrayAdapter<>(getApplication(),R.layout.spinner_view,listvalues);
        listSpin.setAdapter(adapt3);

        listSpin.setOnItemSelectedListener(spinnerlistener);
    }//end on create
    AdapterView.OnItemSelectedListener spinnerlistener= new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,"The selection is : "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
