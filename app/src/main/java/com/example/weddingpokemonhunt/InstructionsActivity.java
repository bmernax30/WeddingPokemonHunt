package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        RelativeLayout timer_refresh = findViewById(R.id.instructions_layout);
        int timer_seconds = 50;
        //Init Timer
        CountDownTimer main_timer;
        main_timer = new CountDownTimer(20000,300){
            public void onTick(long millisUntilFinished){
                //Do Nothing
            }
            public void onFinish(){
                this.cancel();
                Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityMain);
            }
        }.start();

        timer_refresh.setOnClickListener(view -> {
            main_timer.cancel();
            main_timer.start();
        });
    }
    @Override public void onBackPressed()
    {
        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(activityMain);
        super.onBackPressed();
    }
}
