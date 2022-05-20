package z1828205.cs.niu.Assignment05;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    private  DatabaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Create the database
        manager = new DatabaseManager(this);

        // update the view
        updateView();
    }


    public void updateView()
    {
        ArrayList<Item> items = manager.selectAll();

        // Check to see if there is info in the database
        if(items.size() > 0)
        {
            ScrollView scrollView = new ScrollView(this);
            GridLayout gridLayout = new GridLayout(this);

            // Set the number of rows and columns for the grid
            gridLayout.setRowCount(items.size());
            gridLayout.setColumnCount(3);

            // create some arrays to hold the info
            TextView [] ids = new TextView[items.size()];

            EditText [][] names = new EditText[items.size()][2];

            Button [] buttons = new Button[items.size()];

            ButtonHandler handler = new ButtonHandler();

            // Get the dimensions on screen

            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);

            int width = size.x;

            // loop to process the arrayList and build the layout
            int sub = 0;
            for ( Item item : items)
            {
                ids[sub] = new TextView(this);
                ids[sub].setGravity(Gravity.CENTER);
                ids[sub].setText("");

                // edittext fields [0] name [1] price
                names[sub][0] = new EditText(this);

                names[sub][0].setText(item.getItem());

                names[sub][0].setId(10 * item.getId());


                // Buttons
                buttons[sub] = new Button(this);
                buttons[sub].setText("Update");
                buttons[sub].setId(item.getId());
                buttons[sub].setOnClickListener(handler);
                // Add the items to gridlayout
                gridLayout.addView(ids[sub],(int)(width * 0.1), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(names[sub][0], (int)(width*0.4) , ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(buttons[sub], (int) ( width * .35), ViewGroup.LayoutParams.WRAP_CONTENT);

                sub++;

            }// ends for loop

            scrollView.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.index));
            gridLayout.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.index));
            // Add the gridlayout to the scroll view
            scrollView.addView(gridLayout);

            // Setting the background for the scroll view and grid layout

            // display the scrollview
            setContentView(scrollView);

        }// ends if

    }// ends updateview

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //get the name and price from the edit text fields
            int itemId = v.getId();

            EditText nameET = findViewById(10 * itemId);
            EditText typeET = findViewById(10 * itemId + 1);

            String nameStr = nameET.getText().toString();

            manager.updateByID(itemId,nameStr);

            Toast.makeText(UpdateActivity.this,"Pokemon updated: " + nameStr, Toast.LENGTH_SHORT).show();

            updateView();

        }
    }
}

