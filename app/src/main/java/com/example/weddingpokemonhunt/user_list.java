package com.example.weddingpokemonhunt;

public class user_list {
    private String user_name;
    private int user_pokemon;

    public user_list(String user_name, int user_pokemon)
    {
        this.user_name = user_name;
        this.user_pokemon = user_pokemon;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_pokemon() {
        return user_pokemon;
    }

    public void setUser_pokemon(int user_pokemon) {
        this.user_pokemon = user_pokemon;
    }

}
