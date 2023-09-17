package com.example.weddingpokemonhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class ResumeUserActivity extends AppCompatActivity {
    private user_list_adapter user_adapter;
    private ArrayList<user_list> user;
   // CountDownTimer main_timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_user);

        String pokemon_file_name = File_Util.GetFileName(1);
        File pokemon_file = new File(getApplicationContext().getFilesDir(),pokemon_file_name);
        int total_players = File_Util.getTotalPlayers(pokemon_file);
        if(total_players == 0)
        {
            Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(activityMain);
        }
        ListView user_list_view = findViewById(R.id.resume_user_list);
        String user_name;
        int user_pokemon;

        user = new ArrayList<>();

        for(int i=0; i < total_players; i++)
        {
            user_name = File_Util.getUser(pokemon_file,i+1);
            user_pokemon = File_Util.getPokemonCount(pokemon_file,i+1);
            user.add(new user_list(user_name, user_pokemon));
        }

        //Show the list
        user_adapter = new user_list_adapter(getApplicationContext(),R.layout.user_list_item,user);
        user_list_view.setAdapter(user_adapter);
        user_adapter.notifyDataSetChanged();

        ImageButton home_button = findViewById(R.id.resume_user_home_button);
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
    @Override
    public void onBackPressed()
    {
        //main_timer.cancel();
        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(activityMain);
        super.onBackPressed();
    }
}