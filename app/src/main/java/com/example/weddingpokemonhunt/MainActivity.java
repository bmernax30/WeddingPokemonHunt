package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;


import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String pokemon_file_name = File_Util.GetFileName(1);
        File pokemon_file = new File(getApplicationContext().getFilesDir(),pokemon_file_name);
        //File_Util.initFile(pokemon_file);

        boolean error_flag;

        if(pokemon_file.exists())
        {
            //File Exists, Check if there is a header
            if(File_Util.ReadFile(pokemon_file).equals("error"))
            {
                //Empty File, Write Header
                File_Util.initFile(pokemon_file);
            }
        }
        else
        {
            try {
                error_flag = pokemon_file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            File_Util.initFile(pokemon_file);
        }

        ImageButton new_button = findViewById(R.id.main_button_new);
        ImageButton resume_button = findViewById(R.id.main_button_resume);
        if(File_Util.getTotalPlayers(pokemon_file) == 0)
        {
            resume_button.setVisibility(View.INVISIBLE);
        }
        else
        {
            resume_button.setVisibility(View.VISIBLE);
        }
        new_button.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                new_button.setImageResource(0);
                new_button.setImageResource(R.drawable.new_button_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                new_button.setImageResource(0);
                new_button.setImageResource(R.drawable.new_button);
                Intent activityNewUser = new Intent(getApplicationContext(), NewUserActivity.class);
                startActivity(activityNewUser);
            }
            return false;
        });

        resume_button.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                resume_button.setImageResource(0);
                resume_button.setImageResource(R.drawable.resume_button_pressed);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                resume_button.setImageResource(0);
                resume_button.setImageResource(R.drawable.resume_button);
                Intent activityResumeUser = new Intent(getApplicationContext(), ResumeUserActivity.class);
                startActivity(activityResumeUser);
            }
            return false;
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(activityMain);
        super.onBackPressed();
    }
}