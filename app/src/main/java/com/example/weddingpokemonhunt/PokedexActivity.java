package com.example.weddingpokemonhunt;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity {
    private pokemon_list_adapter pokemon_adapter;
    private ArrayList<pokemon_list> pokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        ListView pokemon_list_view = findViewById(R.id.activity_pokemon_list);
        int[] tmp_pokemon = new int[5];
        int[] tmp_found = new int[5];

        pokemon = new ArrayList<>();

        //Init
        tmp_pokemon[0] = 0;
        tmp_pokemon[1] = 1;
        tmp_pokemon[2] = 2;
        tmp_pokemon[3] = 3;
        tmp_pokemon[4] = 4;
        tmp_found[0] = 1;
        tmp_found[1] = 1;
        tmp_found[2] = 1;
        tmp_found[3] = 1;
        tmp_found[4] = 1;
        //Add to Array List
        //5 total lines
        for(int i=0; i < 5; i++)
        {
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
