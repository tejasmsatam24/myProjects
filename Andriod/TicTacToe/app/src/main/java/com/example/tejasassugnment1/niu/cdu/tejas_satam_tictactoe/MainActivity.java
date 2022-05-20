package com.example.tejasassugnment1.niu.cdu.tejas_satam_tictactoe;

/********************************************************************
 CSCI 522 - Portfolio 11 - Spring 2019

 Programmer): Tejas Satam

 TA: Harshith Desamsetti

 Purpose:
 To design a TicTacToe game where layout is created programmatically.
 *********************************************************************/


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    private Button[][] buttons;
    private TicTacToe game;
    private TextView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //create the TicTacToe game
        game = new TicTacToe();

        buildGUI();


    }// ends onCreate

    public void buildGUI()
    {
        // Get the width of the screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        // Calculate the width of 1/3 of the Screen
        int width = size.x / TicTacToe.SIDE;

        // Create a gridLayout to hold buttons for the game
        GridLayout gridLayout = new GridLayout(this);

        // set the number of rows and columns for the grid
        gridLayout.setRowCount(TicTacToe.SIDE + 1);
        gridLayout.setColumnCount(TicTacToe.SIDE);

        // Create the 2-D array of buttons
        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];

        // handle the button clicks
        ButtonHandler buttonHandler = new ButtonHandler();


        // add the buttons to the grid layout.
        for(int row = 0; row < TicTacToe.SIDE; row++)
        {
            for (int col = 0; col < TicTacToe.SIDE; col++)
            {
                // generate the button to go into the 2-D array of Buttons
                buttons[row][col] = new Button(this);

                // set the textsize for the information on the button
                buttons[row][col].setTextSize((int)(width * 0.2));

                // add the handler to the button
                buttons[row][col].setOnClickListener(buttonHandler);

                // add the button to the grid layout
                gridLayout.addView(buttons[row][col],width,width);


            }


        }

        // create the textView
        banner = new TextView(this);

        // set the size for the textView
        GridLayout.Spec rowSpec = GridLayout.spec(TicTacToe.SIDE,1) , colSpec = GridLayout.spec(0,TicTacToe.SIDE);


        GridLayout.LayoutParams layoutParamsStatus = new GridLayout.LayoutParams(rowSpec,colSpec);

        //attach the layout parameters to the text view
        banner.setLayoutParams(layoutParamsStatus);

        // create the width and height for the textView;
        banner.setWidth(TicTacToe.SIDE*width);
        banner.setHeight(width);

        // center the textView
        banner.setGravity(Gravity.CENTER);

        //set the background Color
        banner.setBackgroundColor(Color.BLUE);

        // set the text size
        banner.setTextSize((int)(width * 0.15));

        // put the text in the textview
        banner.setText( game.result() );

        //add the textview to the gridlayout
        gridLayout.addView(banner);


        // display the view that was created
        setContentView(gridLayout);


    }// ends buildGUI

    // The button handler
    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {

            // Display a toast message to indicate what has been clicked.
            //Toast.makeText(MainActivity.this, "ButtonHandler onClick, view is " + view, Toast.LENGTH_SHORT).show();

            // Determine which button was clicked
            for(int row = 0; row < TicTacToe.SIDE; row++)
            {
                for (int col = 0; col < TicTacToe.SIDE; col++)
                {
                    if(view == buttons[row][col])
                    {
                        update(row,col);
                    }
                }

            }

        }
    }// ends ButtonHandler


    public void update(int row, int column)
    {
        // Display a message
        //Toast.makeText(this,"Update: " + row + " , " + column ,Toast.LENGTH_SHORT).show();

        // Put a symbol on the button that was clicked
        //buttons[row][column].setText("X");

        // Find the player
        int currentPlayer = game.play(row, column);

        // Put X or O on the board based on the player

        if (currentPlayer==1){
            buttons[row][column].setText("X");
        }
        else if(currentPlayer==2){
            buttons[row][column].setText("O");
        }

        // Check if the game is over
        boolean check = game.isGameOver();
        if(check){
            //change the background color of the textview
            banner.setBackgroundColor(Color.CYAN);

            //update the text view
            banner.setText(game.result());

            enableButtons(false);

            showNewGameDialog();
        }

    }// ends Update

    public void enableButtons(boolean check)
    {
        for(int row = 0; row < TicTacToe.SIDE; row++)
        {
            for (int col = 0; col < TicTacToe.SIDE; col++)
            {
                buttons[row][col].setEnabled(check);
            }

        }


    }// ends enableButtons


    public void showNewGameDialog()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        //set the title and the message for the dialog box
        alert.setTitle("Tic Tac Toe");
        alert.setMessage("Do you want to play again?");

        //Create the positive button
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // reset the game

                game.resetGame();

                // re-enable the buttons
                enableButtons(true);

                resetButtons();

                // change the textview background back to original
                banner.setBackgroundColor(Color.BLUE);

                // update the text in the textview
                banner.setText(game.result());
            }
        });

        // create the negative button

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //close the application
                MainActivity.this.finish();

            }
        });
        // display the dialog box
        alert.show();

    }//ends showNewGameDialog

    public void resetButtons()
    {
        for(int row = 0; row < TicTacToe.SIDE; row++)
        {
            for (int col = 0; col < TicTacToe.SIDE; col++)
            {
                buttons[row][col].setText("");
            }
        }

    }// ends resetButtons




}//end MainActivity
