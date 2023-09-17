package com.example.weddingpokemonhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;

public class NewUserActivity extends AppCompatActivity {

    CountDownTimer main_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        LinearLayout main_timer_refresh = findViewById(R.id.new_user_layout);

        ImageButton start_adv_button = findViewById(R.id.new_user_start_button);
        EditText user_name = findViewById(R.id.new_user_name_input);
        TextView user_description = findViewById(R.id.new_user_description);
        TextView user_instructions = findViewById(R.id.new_user_instructions);

        start_adv_button.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                start_adv_button.setImageResource(0);
                start_adv_button.setImageResource(R.drawable.gotta_catchemall_button_pressed);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                start_adv_button.setImageResource(0);
                start_adv_button.setImageResource(R.drawable.gotta_catchemall_button);
                //Don't do anything if no user name is selected
                String new_user = user_name.getText().toString();
                if (new_user.isEmpty()) {
                    return false;
                }

                String pokemon_file_name = File_Util.GetFileName(1);
                File pokemon_file = new File(getApplicationContext().getFilesDir(), pokemon_file_name);
                boolean user_found_flag = false;
                String test = File_Util.ReadFile(pokemon_file);

                //Check if User Exists
                int total_players = File_Util.getTotalPlayers(pokemon_file);
                String tmp_saved_user = "";

                for (int i = 0; i < total_players; i++) {
                    tmp_saved_user = File_Util.getUser(pokemon_file, i + 1);
                    if (tmp_saved_user.equals(new_user)) {
                        user_found_flag = true;
                        break;
                    }
                }

                if (user_found_flag) {
                    view.performClick();
                    user_description.setVisibility(View.INVISIBLE);
                    user_instructions.setText(getResources().getString(R.string.new_user_input_error));
                } else {
                    File_Util.addUser(pokemon_file, new_user);
                    Intent activityInstructions = new Intent(getApplicationContext(), InstructionsActivity.class);
                    startActivity(activityInstructions);
                }
            }
            return false;
        });
        ImageButton home_button = findViewById(R.id.new_user_home_button);
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
        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(activityMain);
        super.onBackPressed();
    }
}