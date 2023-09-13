package com.example.weddingpokemonhunt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class user_list_adapter extends ArrayAdapter<user_list> {
    private final ArrayList<user_list> user_list;

    public user_list_adapter(@NonNull Context context, int resource, ArrayList<user_list> user_list) {
        super(context, resource);
        this.user_list = user_list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.user_list_item, parent, false);
        }
        //get GUI Items
        LinearLayout user_info = convertView.findViewById(R.id.pokemon_info);
        TextView user_name = convertView.findViewById(R.id.user_list_user_name);
        TextView user_pokemon_count = convertView.findViewById(R.id.user_list_pokemon_count);
        ProgressBar user_progress = convertView.findViewById(R.id.user_list_user_progress);
        Intent activity_pokedex = new Intent(getContext(), PokedexActivity.class);
        user_name.setText(user_list.get(position).getUser_name());
        user_pokemon_count.setText(String.valueOf(user_list.get(position).getUser_pokemon()));
        user_progress.setProgress(user_list.get(position).getUser_pokemon());

        user_info.setOnClickListener(View-> {
            activity_pokedex.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity_pokedex.putExtra("key_user_id",position);
            getContext().startActivity(activity_pokedex);
        });
        return convertView;
    }
    @Override
    public int getCount(){
        return user_list.size();
    }
    @Override
    public user_list getItem(int position) {return user_list.get(position);}
}
