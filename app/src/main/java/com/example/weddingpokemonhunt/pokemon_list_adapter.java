package com.example.weddingpokemonhunt;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;



public class pokemon_list_adapter extends ArrayAdapter<pokemon_list> {
    private final ArrayList<pokemon_list> pokemon_list;
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
    public pokemon_list_adapter(@NonNull Context context, int resource, ArrayList<pokemon_list> pokemon_list)
    {
        super(context,resource);
        this.pokemon_list = pokemon_list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.pokemon_list_item,parent,false);
        }
        //Get GUI Items
        ImageView pokemon_image_1 = convertView.findViewById(R.id.pokemon1);
        ImageView pokemon_image_2 = convertView.findViewById(R.id.pokemon2);
        ImageView pokemon_image_3 = convertView.findViewById(R.id.pokemon3);
        ImageView pokemon_image_4 = convertView.findViewById(R.id.pokemon4);
        ImageView pokemon_image_5 = convertView.findViewById(R.id.pokemon5);
        TextView pokemon_name_1 = convertView.findViewById(R.id.pokemon1_title);
        TextView pokemon_name_2 = convertView.findViewById(R.id.pokemon2_title);
        TextView pokemon_name_3 = convertView.findViewById(R.id.pokemon3_title);
        TextView pokemon_name_4 = convertView.findViewById(R.id.pokemon4_title);
        TextView pokemon_name_5 = convertView.findViewById(R.id.pokemon5_title);
        int[] pokemon_ids = new int[5];
        int[] pokemon_found = new int[5];
        //Set Pokemon 1
        pokemon_ids = pokemon_list.get(position).getPokemon_id();
        pokemon_found = pokemon_list.get(position).getPokemon_found();

        //Search for Resid Based on Id and Found
        TypedArray pokemon_images = convertView.getResources().obtainTypedArray(R.array.pokemon_images);
        TypedArray no_pokemon_images = convertView.getResources().obtainTypedArray(R.array.no_pokemon_images);

        if(pokemon_found[0] == 1)
        {
            pokemon_image_1.setBackgroundResource(pokemon_images.getResourceId(pokemon_ids[0],0));
            pokemon_name_1.setText(pokemon_names[pokemon_ids[0]]);
        }
        else
        {
            pokemon_image_1.setBackgroundResource(no_pokemon_images.getResourceId(pokemon_ids[0],0));
            pokemon_name_1.setText(R.string.unknown_pokemon);
        }

        if(pokemon_found[1] == 1)
        {
            pokemon_image_2.setBackgroundResource(pokemon_images.getResourceId(pokemon_ids[1],0));
            pokemon_name_1.setText(pokemon_names[pokemon_ids[1]]);
        }
        else
        {
            pokemon_image_2.setBackgroundResource(no_pokemon_images.getResourceId(pokemon_ids[1],0));
            pokemon_name_1.setText(R.string.unknown_pokemon);
        }

        if(pokemon_found[2] == 1)
        {
            pokemon_image_3.setBackgroundResource(pokemon_images.getResourceId(pokemon_ids[2],0));
            pokemon_name_1.setText(pokemon_names[pokemon_ids[2]]);
        }
        else
        {
            pokemon_image_3.setBackgroundResource(no_pokemon_images.getResourceId(pokemon_ids[2],0));
            pokemon_name_1.setText(R.string.unknown_pokemon);
        }

        if(pokemon_found[3] == 1)
        {
            pokemon_image_4.setBackgroundResource(pokemon_images.getResourceId(pokemon_ids[3],0));
            pokemon_name_1.setText(pokemon_names[pokemon_ids[3]]);
        }
        else
        {
            pokemon_image_4.setBackgroundResource(no_pokemon_images.getResourceId(pokemon_ids[3],0));
            pokemon_name_1.setText(R.string.unknown_pokemon);
        }

        if(pokemon_found[4] == 1)
        {
            pokemon_image_5.setBackgroundResource(pokemon_images.getResourceId(pokemon_ids[4],0));
            pokemon_name_1.setText(pokemon_names[pokemon_ids[4]]);
        }
        else
        {
            pokemon_image_5.setBackgroundResource(no_pokemon_images.getResourceId(pokemon_ids[4],0));
            pokemon_name_1.setText(R.string.unknown_pokemon);
        }

        pokemon_images.recycle();
        no_pokemon_images.recycle();

        return convertView;
    }

    @Override
    public int getCount(){ return pokemon_list.size();
    }
    @Override
    public pokemon_list getItem(int position)
    {
        return pokemon_list.get(position);
    }

}
