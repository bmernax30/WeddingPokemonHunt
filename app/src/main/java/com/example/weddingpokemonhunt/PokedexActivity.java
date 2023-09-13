package com.example.weddingpokemonhunt;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity {
    private pokemon_list_adapter pokemon_adapter;
    private ArrayList<pokemon_list> pokemon;
    int LINES_OF_POKEMON = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        String pokemon_file_name = File_Util.GetFileName(1);
        File pokemon_file = new File(getApplicationContext().getFilesDir(),pokemon_file_name);

        TextView username_text = findViewById(R.id.pokedex_user_name);
        ListView pokemon_list_view = findViewById(R.id.activity_pokemon_list);
        TextView pokemon_count_text = findViewById(R.id.pokedex_pokemon_caught);
        ProgressBar pokemon_count_progess = findViewById(R.id.pokedex_pokemon_progress);

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
        tmp_pokemon[0] = 0;
        tmp_pokemon[1] = 1;
        tmp_pokemon[2] = 2;
        tmp_pokemon[3] = 3;
        tmp_pokemon[4] = 4;
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
            pokemon.add(new pokemon_list(tmp_pokemon, tmp_found));
            tmp_pokemon[0] = tmp_pokemon[0] + 5;
            tmp_pokemon[1] = tmp_pokemon[1] + 5;
            tmp_pokemon[2] = tmp_pokemon[2] + 5;
            tmp_pokemon[3] = tmp_pokemon[3] + 5;
            tmp_pokemon[4] = tmp_pokemon[4] + 5;
        }
        //Show the list
        pokemon_adapter = new pokemon_list_adapter(getApplicationContext(),R.layout.pokemon_list_item,pokemon);
        pokemon_list_view.setAdapter(pokemon_adapter);
        pokemon_adapter.notifyDataSetChanged();
    }

}
