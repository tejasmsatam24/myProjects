package z1828205.cs.niu.Assignment05;

/********************************************************************
 CSCI 522 - Assignment 05 - Semester (Spring) Year-2019

 Programmer(s): Ashton Dsouza (Z1828205)
                Tejas Satam (Z1854197)


 TA: Harshith Desamsetti
 Date Due: 05/02/2019

 Purpose: This app uses SQLite database to create a note taking app.
 It consists of a splash screen which connects to the application in which
 we can enter new items, update and delete some or all items.
 *********************************************************************/

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseManager manager;//Initializing database manager
    private ScrollView scrollView;//Initializing scrollview



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Database manager
        manager = new DatabaseManager(this);

        //findingview by Id of scrollview
        scrollView = findViewById(R.id.contentLayout);
        //Caliing update view function
        updateView();

    }

    @Override
    protected void onResume()
    {
        //Calling updateview function after the app has been resumed.
        super.onResume();
        updateView();
        //getData();
    }
    public void getData() {
        Cursor res = manager.getAllData();
        if(res.getCount()==0)
        {
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();

        }
        else {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                StringBuffer sol = buffer.append(res.getString(0) + " " + res.getString(1)+"\n");
                showMessage(sol);
            }
        }
    }
    public void showMessage(StringBuffer sol)
    {
        String message = sol.toString();
        Log.d(message,message);
        LinearLayout layout = new LinearLayout(getApplicationContext());
        //ListTV.setText(message);
        for(int i = 0; i < message.length();i++)
        {
            CheckBox ch = new CheckBox(getApplicationContext());
            ch.setText(message);



        }


    }
    public void updateView()
    {   //an array list of all the Lists that are present in Database.
        ArrayList<Item> items = manager.selectAll();
        //Cursor res = manager.getAllData();
        Log.d("Lists", items.toString());
        if(items.size() > 0)
        {
            //Removing all the views in the scroll view
            scrollView.removeAllViewsInLayout();
            //By using Grid Layout showing the checkboxes on main activity.
            GridLayout gridLayout = new GridLayout(this);
            gridLayout.setRowCount(1);
            gridLayout.setColumnCount(1);

            final ItemsCheckBox[] cb = new ItemsCheckBox[items.size()];


            //Adding checkboxes
            for(Item item : items)
            {
                int sub = 0;
                boolean isChecked = false;
                cb[sub] = new ItemsCheckBox(this, item);
                cb[sub].setText(item.getItem());
                cb[sub].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        int sub = 0;
                        if(cb[sub].isChecked())
                        {
                            isChecked = true;
                        }
                        cb[sub].setChecked(isChecked);
                    }
                });

                gridLayout.addView(cb[sub],GridLayout.LayoutParams.WRAP_CONTENT);
                sub++;

            }


            scrollView.addView(gridLayout);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == R.id.action_add)
        {
            Intent insertIntent = new Intent(MainActivity.this,InsertActivity.class);
            startActivity(insertIntent);
            return true;
        }
        else if(id == R.id.action_delete)
        {
            Intent deleteIntent = new Intent(MainActivity.this,DeleteActivity.class);
            startActivity(deleteIntent);
            return true;
        }
        else if(id == R.id.action_deleteall)
        {
            manager.deleteAll();
            scrollView.removeAllViewsInLayout();
            //delete();
            Toast.makeText(this,"All the items have been deleted",Toast.LENGTH_SHORT).show();
            updateView();
            return true;
        }
        else if (id == R.id.action_update) {
            Toast.makeText(this,"Menu Option: update selected",Toast.LENGTH_SHORT).show();

            Intent updateIntent = new Intent(MainActivity.this, UpdateActivity.class);
            startActivity(updateIntent);
            return true;
        }

        //updateView();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
