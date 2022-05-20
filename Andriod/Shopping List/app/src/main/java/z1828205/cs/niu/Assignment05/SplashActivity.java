package z1828205.cs.niu.Assignment05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //finish Activity
                finish();
                //Go to Main Activity
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        };
        //Create Timer Object
        Timer timer = new Timer();
        timer.schedule(task,5000);
    }
}

