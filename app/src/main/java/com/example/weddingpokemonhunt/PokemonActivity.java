package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PokemonActivity extends AppCompatActivity {
    String[] wedding_pokemon_names = {
            "Bulbasaur",
            "Charmander",
            "Squirtle",
            "Butterfree",
            "Pikachu",
            "Nidoking",
            "Vulpix",
            "Ninetales",
            "Jigglypuff",
            "Psyduck",
            "Golduck",
            "Arcanine",
            "Alakazam",
            "Ponyta",
            "Haunter",
            "Gengar",
            "Onix",
            "Hitmonchan",
            "Lickitung",
            "Scyther",
            "Eevee",
            "Articuno",
            "Zapdos",
            "Moltres",
            "Dragonite",
    };
    String[] pokemon_names = {
            "Bulbasaur",
            "Ivysaur",
            "Venusaur",
            "Charmander",
            "Charmeleon",
            "Charizard",
            "Squirtle",
            "Wartortle",
            "Blastoise",
            "Caterpie",
            "Metapod",
            "Butterfree",
            "Weedle",
            "Kakuna",
            "Beedrill",
            "Pidgey",
            "Pidgeotto",
            "Pidgeot",
            "Rattata",
            "Raticate",
            "Spearow",
            "Fearow",
            "Ekans",
            "Arbok",
            "Pikachu",
            "Raichu",
            "Sandshrew",
            "Sandslash",
            "Nidoran",
            "Nidorina",
            "Nidoqueen",
            "Nidoran",
            "Nidorino",
            "Nidoking",
            "Clefairy",
            "Clefable",
            "Vulpix",
            "Ninetales",
            "Jigglypuff",
            "Wigglytuff",
            "Zubat",
            "Golbat",
            "Oddish",
            "Gloom",
            "Vileplume",
            "Paras",
            "Parasect",
            "Venonat",
            "Venomoth",
            "Diglett",
            "Dugtrio",
            "Meowth",
            "Persian",
            "Psyduck",
            "Golduck",
            "Mankey",
            "Primeape",
            "Growlithe",
            "Arcanine",
            "Poliwag",
            "Poliwhirl",
            "Poliwrath",
            "Abra",
            "Kadabra",
            "Alakazam",
            "Machop",
            "Machoke",
            "Machamp",
            "Bellsprout",
            "Weepinbell",
            "Victreebel",
            "Tentacool",
            "Tentacruel",
            "Geodude",
            "Graveler",
            "Golem",
            "Ponyta",
            "Rapidash",
            "Slowpoke",
            "Slowbro",
            "Magnemite",
            "Magneton",
            "Farfetchd",
            "Doduo",
            "Dodrio",
            "Seel",
            "Dewgong",
            "Grimer",
            "Muk",
            "Shellder",
            "Cloyster",
            "Gastly",
            "Haunter",
            "Gengar",
            "Onix",
            "Drowzee",
            "Hypno",
            "Krabby",
            "Kingler",
            "Voltorb",
            "Electrode",
            "Exeggcute",
            "Exeggutor",
            "Cubone",
            "Marowak",
            "Hitmonlee",
            "Hitmonchan",
            "Lickitung",
            "Koffing",
            "Weezing",
            "Rhyhorn",
            "Rhydon",
            "Chansey",
            "Tangela",
            "Kangaskhan",
            "Horsea",
            "Seadra",
            "Goldeen",
            "Seaking",
            "Staryu",
            "Starmie",
            "Mr.Mime",
            "Scyther",
            "Jynx",
            "Electabuzz",
            "Magmar",
            "Pinsir",
            "Tauros",
            "Magikarp",
            "Gyarados",
            "Lapras",
            "Ditto",
            "Eevee",
            "Vaporeon",
            "Jolteon",
            "Flareon",
            "Porygon",
            "Omanyte",
            "Omastar",
            "Kabuto",
            "Kabutops",
            "Aerodactyl",
            "Snorlax",
            "Articuno",
            "Zapdos",
            "Moltres",
            "Dratini",
            "Dragonair",
            "Dragonite",
            "Mewtwo",
            "Mew"
    };
    CountDownTimer main_timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        RelativeLayout main_timer_refresh = findViewById(R.id.pokemon_layout);

        //TypedArray pokemon_images = getResources().obtainTypedArray(R.array.pokemon_images);
        TypedArray pokemon_images = getResources().obtainTypedArray(R.array.wedding_pokemon_images_hq);

        //Keys
        //username
        Bundle extras = getIntent().getExtras();
        String user_name = extras.getString("key_user_name");
        int pokemon_id = extras.getInt("key_pokemon_id");
        //GUI
        TextView pokemon_info = findViewById(R.id.pokemon_info_string);
        TextView pokemon_name_text = findViewById(R.id.pokemon_name);
        TextView user_name_text = findViewById(R.id.pokemon_user);
        ImageView pokemon_image = findViewById(R.id.pokemon_pokemon);

        if(pokemon_id >= 100)
        {
            pokemon_info.setText("YOU ALREADY CAUGHT");
            pokemon_name_text.setText(wedding_pokemon_names[pokemon_id-100]);
            user_name_text.setText(user_name);
            pokemon_image.setImageResource(0);
            pokemon_image.setImageResource(R.drawable.pokeball);
        }
        else
        {
            pokemon_name_text.setText(wedding_pokemon_names[pokemon_id]);
            //pokemon_name_text.setText(pokemon_names[pokemon_id]);
            user_name_text.setText(user_name);
            pokemon_image.setImageResource(0);
            pokemon_image.setImageResource(pokemon_images.getResourceId(pokemon_id, 0));
        }
        pokemon_images.recycle();

        ImageButton home_button = findViewById(R.id.pokemon_home_button);
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
        Intent activityUser = new Intent(getApplicationContext(), ResumeUserActivity.class);
        startActivity(activityUser);
        super.onBackPressed();
    }
}
