package com.example.weddingpokemonhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        ImageButton start_adv_button = findViewById(R.id.new_user_start_button);
        start_adv_button.setOnClickListener(view -> {
            String pokemon_file_name = File_Util.GetFileName(1);
            File pokemon_file = new File(getApplicationContext().getFilesDir(),pokemon_file_name);
            String test;
            TextView user_name = findViewById(R.id.new_user_name_input);
            String[] user_names = {"Liam","Barney","Mad Dawg","Ku-Ku","Lauren"};
            //Create a few users
            for(int i =0; i < 5; i++)
            {
                File_Util.addUser(pokemon_file,user_names[i]);
                test = File_Util.ReadFile(pokemon_file);
            }
            test = File_Util.ReadFile(pokemon_file);
            Intent activityInstructions = new Intent(getApplicationContext(), InstructionsActivity.class);
            startActivity(activityInstructions);

        });
    }
}