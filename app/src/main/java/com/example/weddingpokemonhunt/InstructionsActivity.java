package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class InstructionsActivity extends AppCompatActivity {

    CountDownTimer main_timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        ImageButton home_button = findViewById(R.id.instructions_home_button);
        home_button.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                home_button.setImageResource(0);
                home_button.setImageResource(R.drawable.home_button_v2_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                home_button.setImageResource(0);
                home_button.setImageResource(R.drawable.home_button_v2);
                Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityMain);
            }
            return false;
        });
    }
    @Override public void onBackPressed()
    {
        main_timer.cancel();
        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(activityMain);
        super.onBackPressed();
    }
}
