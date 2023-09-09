package com.example.weddingpokemonhunt;

public class pokemon_list {
    private int[] pokemon_id = new int[5];
    private int[] pokemon_found = new int[5];

    public pokemon_list(int[] pokemon_id, int[] pokemon_found)
    {
        this.pokemon_id[0] = pokemon_id[0];
        this.pokemon_id[1] = pokemon_id[1];
        this.pokemon_id[2] = pokemon_id[2];
        this.pokemon_id[3] = pokemon_id[3];
        this.pokemon_id[4] = pokemon_id[4];
        this.pokemon_found[0] = pokemon_found[0];
        this.pokemon_found[1] = pokemon_found[1];
        this.pokemon_found[2] = pokemon_found[2];
        this.pokemon_found[3] = pokemon_found[3];
        this.pokemon_found[4] = pokemon_found[4];
    }

    public int[] getPokemon_id() {
        return pokemon_id.clone();
    }

    public void setPokemon_id(int[] pokemon_id) {
        this.pokemon_id = pokemon_id.clone();
    }

    public int[] getPokemon_found() {
        return pokemon_found.clone();
    }

    public void setPokemon_found(int[] pokemon_found) {
        this.pokemon_found = pokemon_found.clone();
    }
}
