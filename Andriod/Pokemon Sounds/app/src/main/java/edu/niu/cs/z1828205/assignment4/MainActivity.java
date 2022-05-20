package edu.niu.cs.z1828205.assignment4;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    // The six imageViews
    private ImageView pikaIV,bulbaIV,charIV,squirtleIV,blastoiseIV,pidgeotIV;

    // The six MediaPlayers
    private MediaPlayer pikaMP,bulbaMP,charMP,squirtleMP,blastoiseMP,pidgeotMP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Connect the ImageViews

        pikaIV = findViewById(R.id.pikachu);
        bulbaIV = findViewById(R.id.bulbasaur);
        charIV = findViewById(R.id.charmander);
        squirtleIV = findViewById(R.id.squirtle);
        blastoiseIV = findViewById(R.id.blastoise);
        pidgeotIV = findViewById(R.id.pidgeot);

        // Create the media player for each pokemon
        pikaMP = new MediaPlayer();
        pikaMP = MediaPlayer.create(this,R.raw.pikachusound);

        bulbaMP = new MediaPlayer();
        bulbaMP = MediaPlayer.create(this,R.raw.bulbasaursound);

        charMP = new MediaPlayer();
        charMP = MediaPlayer.create(this,R.raw.charsound);

        squirtleMP = new MediaPlayer();
        squirtleMP = MediaPlayer.create(this,R.raw.squirtlesound);

        blastoiseMP = new MediaPlayer();
        blastoiseMP = MediaPlayer.create(this,R.raw.blastoisesound);

        pidgeotMP = new MediaPlayer();
        pidgeotMP = MediaPlayer.create(this,R.raw.pidgeotsound);
    }


    // The various play sounds methods. one for each pokemon

    public void playPika(View view)
    {
        pikaMP.start();
    }

    public void playBulba(View view)
    {
        bulbaMP.start();
    }

    public void playChar(View view)
    {
        charMP.start();
    }

    public void playSquirtle(View view)
    {
        squirtleMP.start();
    }

    public void playBlastoise(View view)
    {
        blastoiseMP.start();
    }

    public void playPidgeot(View view)
    {
        pidgeotMP.start();
    }



}