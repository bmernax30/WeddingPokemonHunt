package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity {
    private pokemon_list_adapter pokemon_adapter;
    private ArrayList<pokemon_list> pokemon;
    int LINES_OF_POKEMON = 5;
    //int LINES_OF_POKEMON = 30;
    int wedding_pokemon[] = {
        1,4,7,12,25,34,37,38,39,54,55,59,65,77,93,94,95,107,108,123,133,144,145,146,149
    };
    CountDownTimer main_timer;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        RelativeLayout main_timer_refresh = findViewById(R.id.pokedex_layout);

        //Init Timer
        CountDownTimer main_timer;
        main_timer = new CountDownTimer(10000,1000){
            public void onTick(long millisUntilFinished){
                //Do Nothing
            }
            public void onFinish(){
                this.cancel();
                Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityMain);
            }
        }.start();
        main_timer_refresh.setOnClickListener(view -> {
            main_timer.cancel();
            main_timer.start();
        });

        String pokemon_file_name = File_Util.GetFileName(1);
        File pokemon_file = new File(getApplicationContext().getFilesDir(),pokemon_file_name);

        TextView username_text = findViewById(R.id.pokedex_user_name);
        ListView pokemon_list_view = findViewById(R.id.pokedex_activity_pokemon_list);
        TextView pokemon_count_text = findViewById(R.id.pokedex_pokemon_caught);
        ProgressBar pokemon_count_progess = findViewById(R.id.pokedex_pokemon_progress);
        ImageButton catch_pokemon_button = findViewById(R.id.pokedex_catch_pokemon_button);

        int pokemon_count;
        int[] tmp_pokemon = new int[5];
        int[] tmp_found = new int[5];
        int user_id;
        String user_pokemon;
        byte[] user_pokemon_bytes;
        pokemon = new ArrayList<>();

        //Get Saved Vales
        Bundle extras = getIntent().getExtras();
        user_id = extras.getInt("key_user_id");
        //Init
        username_text.setText(File_Util.getUser(pokemon_file,user_id+1));
        pokemon_count = File_Util.getPokemonCount(pokemon_file,user_id+1);
        pokemon_count_text.setText(String.valueOf(pokemon_count));
        pokemon_count_progess.setProgress(pokemon_count);
        int tmp_pokemon0 = 0;
        int tmp_pokemon1 = 1;
        int tmp_pokemon2 = 2;
        int tmp_pokemon3 = 3;
        int tmp_pokemon4 = 4;
        user_pokemon = File_Util.getPokemonString(pokemon_file,user_id+1);
        user_pokemon_bytes = user_pokemon.getBytes();
        //Add to Array List
        //5 total lines
        for(int i=0; i < LINES_OF_POKEMON; i++)
        {
            if(user_pokemon_bytes[5*i] == 49)
            {
                tmp_found[0] = 1;
            }
            else
            {
                tmp_found[0] = 0;
            }
            if(user_pokemon_bytes[5*i+1] == 49)
            {
                tmp_found[1] = 1;
            }
            else
            {
                tmp_found[1] = 0;
            }
            if(user_pokemon_bytes[5*i+2] == 49)
            {
                tmp_found[2] = 1;
            }
            else
            {
                tmp_found[2] = 0;
            }
            if(user_pokemon_bytes[5*i+3] == 49)
            {
                tmp_found[3] = 1;
            }
            else
            {
                tmp_found[3] = 0;
            }
            if(user_pokemon_bytes[5*i+4] == 49)
            {
                tmp_found[4] = 1;
            }
            else
            {
                tmp_found[4] = 0;
            }
            tmp_pokemon[0] = wedding_pokemon[tmp_pokemon0] - 1;
            tmp_pokemon[1] = wedding_pokemon[tmp_pokemon1] - 1;
            tmp_pokemon[2] = wedding_pokemon[tmp_pokemon2] - 1;
            tmp_pokemon[3] = wedding_pokemon[tmp_pokemon3] - 1;
            tmp_pokemon[4] = wedding_pokemon[tmp_pokemon4] - 1;
            pokemon.add(new pokemon_list(tmp_pokemon, tmp_found));
            tmp_pokemon0 = tmp_pokemon0 + 5;
            tmp_pokemon1 = tmp_pokemon1 + 5;
            tmp_pokemon2 = tmp_pokemon2 + 5;
            tmp_pokemon3 = tmp_pokemon3 + 5;
            tmp_pokemon4 = tmp_pokemon4 + 5;
        }
        //Show the list
        pokemon_adapter = new pokemon_list_adapter(getApplicationContext(),R.layout.pokemon_list_item,pokemon);
        pokemon_list_view.setAdapter(pokemon_adapter);
        pokemon_adapter.notifyDataSetChanged();

        catch_pokemon_button.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                catch_pokemon_button.setImageResource(0);
                catch_pokemon_button.setImageResource(R.drawable.enter_pokemon_button_pressed);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                catch_pokemon_button.setImageResource(0);
                catch_pokemon_button.setImageResource(R.drawable.enter_pokemon_button);
                main_timer.cancel();
                Intent activity_catch_pokemon = new Intent(getApplicationContext(), CatchPokemon.class);
                activity_catch_pokemon.putExtra("key_user_id", user_id);
                startActivity(activity_catch_pokemon);
            }
            return false;
        });
    }
    @Override
    public void onBackPressed()
    {
        main_timer.cancel();
        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(activityMain);
        super.onBackPressed();
    }
}
