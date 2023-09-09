package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
        File_Util.initFile(pokemon_file);
        boolean error_flag;
        String test;
        if(pokemon_file.exists())
        {
            //File Exists, Check if there is a header
            if(File_Util.ReadFile(pokemon_file).equals("error"))
            {
                //Empty File, Write Header
                File_Util.initFile(pokemon_file);
            }
            test = File_Util.ReadFile(pokemon_file);
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
        new_button.setOnClickListener(view -> {
                Intent activityNewUser = new Intent(getApplicationContext(), NewUserActivity.class);
                startActivity(activityNewUser);
        });
        resume_button.setOnClickListener(view -> {
                //Intent activityResumeUser = new Intent(getApplicationContext(), ResumeUserActivity.class);
                //startActivity(activityResumeUser);
                Intent activityPokedex = new Intent(getApplicationContext(), PokedexActivity.class);
                startActivity(activityPokedex);
        });
    }
}