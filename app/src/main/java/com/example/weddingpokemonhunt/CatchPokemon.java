package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class CatchPokemon extends AppCompatActivity{
    int input_count = 0;
    String input_code = "";
    String[] wedding_pokemon_codes = {
            "GXUWC",
            "SWFXU",
            "XGAFS",
            "WGLFS",
            "XSWCF",
            "CXLWA",
            "UWCSX",
            "GLXSC",
            "GFWSA",
            "GSXLC",
            "LXFSC",
            "GASWC",
            "XGLUS",
            "GCAUW",
            "ASFLX",
            "LUCFW",
            "FSWXC",
            "AUCSX",
            "GALCS",
            "UCLGX",
            "WSLUC",
            "GFAXU",
            "SFALC",
            "AFCUL",
            "UGLWA"
    };
    String[] pokemon_codes = {
            "GXUWC",
            "SWFXU",
            "XGAFS",
            "WGLFS",
            "XSWCF",
            "CXLWA",
            "UWCSX",
            "GLXSC",
            "GFWSA",
            "GSXLC",
            "LXFSC",
            "GASWC",
            "XGLUS",
            "GCAUW",
            "ASFLX",
            "LUCFW",
            "FSWXC",
            "AUCSX",
            "GALCS",
            "UCLGX",
            "WSLUC",
            "GFAXU",
            "SFALC",
            "AFCUL",
            "UGLWA",
            "CXSWU",
            "CFSXA",
            "CFGWX",
            "CXWFU",
            "AUSWC",
            "SLWFC",
            "CFXLA",
            "CUAWL",
            "XUCLF",
            "CFLGS",
            "ALGSC",
            "CFGWU",
            "AWUFL",
            "CSAXL",
            "SACUG",
            "AXWGU",
            "CFSXU",
            "UCFWX",
            "GLCSW",
            "SLGUF",
            "AFWLU",
            "XALFG",
            "WCAGL",
            "LFAGC",
            "CFUGL",
            "SCLWU",
            "FLGUW",
            "GWLFA",
            "UWASG",
            "FUCLW",
            "GXWUF",
            "SAULG",
            "SUCGA",
            "AGCLU",
            "FSWAG",
            "GUALF",
            "LFUCA",
            "FLXWU",
            "UXFAW",
            "GWULS",
            "XSAWC",
            "GWAUC",
            "WSFAL",
            "ACWFS",
            "UASXC",
            "UFCLX",
            "FGAWS",
            "LACSU",
            "AXFWU",
            "UAWXL",
            "FGCSL",
            "CUGSW",
            "GLUXA",
            "FGULX",
            "AWSCG",
            "ACSWG",
            "GAWUF",
            "UXLAC",
            "FXCSU",
            "CXAUF",
            "ASGFL",
            "CLSXW",
            "SUCLG",
            "GULAC",
            "FSULC",
            "UCGSX",
            "SWGFC",
            "GFCWU",
            "XUWCG",
            "XUFSL",
            "CFSLU",
            "LCGFU",
            "SXGAU",
            "FGLWS",
            "ULGXC",
            "ULWGA",
            "GAFLU",
            "GCSUW",
            "LWFCX",
            "LUFAC",
            "ACUSL",
            "LGUCW",
            "AUWCG",
            "FWSLA",
            "SFALG",
            "WXLCU",
            "SGLUW",
            "ALSUG",
            "WSGLU",
            "WXLAS",
            "UXGLA",
            "FLACS",
            "WXSUA",
            "FWCAU",
            "ACUFS",
            "FSLXW",
            "WSGCX",
            "WLFCU",
            "CFAWU",
            "XCWFS",
            "LCSXF",
            "FLCAX",
            "AGWXS",
            "SGCWU",
            "LGASX",
            "SCUGA",
            "LASXG",
            "LSGUX",
            "CWLSX",
            "UCFAX",
            "LACGS",
            "CFGAL",
            "CLXWS",
            "CALGF",
            "ASXCF",
            "CXWLA",
            "WXAFS",
            "FXSLC",
            "ASFUC",
            "CSWGX",
            "XLAGF",
            "ASCUX",
            "SLXGA",
            "CWASG",
            "ULCGW",
            "CFGLW"
            //"Bulbasaur",
            //"Ivysaur",
            //"Venusaur",
            //"Charmander",
            //"Charmeleon",
            //"Charizard",
            //"Squirtle",
            //"Wartortle",
            //"Blastoise",
            //"Caterpie",
            //"Metapod",
            //"Butterfree",
            //"Weedle",
            //"Kakuna",
            //"Beedrill",
            //"Pidgey",
            //"Pidgeotto",
            //"Pidgeot",
            //"Rattata",
            //"Raticate",
            //"Spearow",
            //"Fearow",
            //"Ekans",
            //"Arbok",
            //"Pikachu",
            //"Raichu",
            //"Sandshrew",
            //"Sandslash",
            //"Nidoran",
            //"Nidorina",
            //"Nidoqueen",
            //"Nidoran",
            //"Nidorino",
            //"Nidoking",
            //"Clefairy",
            //"Clefable",
            //"Vulpix",
            //"Ninetales",
            //"Jigglypuff",
            //"Wigglytuff",
            //"Zubat",
            //"Golbat",
            //"Oddish",
            //"Gloom",
            //"Vileplume",
            //"Paras",
            //"Parasect",
            //"Venonat",
            //"Venomoth",
            //"Diglett",
            //"Dugtrio",
            //"Meowth",
            //"Persian",
            //"Psyduck",
            //"Golduck",
            //"Mankey",
            //"Primeape",
            //"Growlithe",
            //"Arcanine",
            //"Poliwag",
            //"Poliwhirl",
            //"Poliwrath",
            //"Abra",
            //"Kadabra",
            //"Alakazam",
            //"Machop",
            //"Machoke",
            //"Machamp",
            //"Bellsprout",
            //"Weepinbell",
            //"Victreebel",
            //"Tentacool",
            //"Tentacruel",
            //"Geodude",
            //"Graveler",
            //"Golem",
            //"Ponyta",
            //"Rapidash",
            //"Slowpoke",
            //"Slowbro",
            //"Magnemite",
            //"Magneton",
            //"Farfetchd",
            //"Doduo",
            //"Dodrio",
            //"Seel",
            //"Dewgong",
            //"Grimer",
            //"Muk",
            //"Shellder",
            //"Cloyster",
            //"Gastly",
            //"Haunter",
            //"Gengar",
            //"Onix",
            //"Drowzee",
            //"Hypno",
            //"Krabby",
            //"Kingler",
            //"Voltorb",
            //"Electrode",
            //"Exeggcute",
            //"Exeggutor",
            //"Cubone",
            //"Marowak",
            //"Hitmonlee",
            //"Hitmonchan",
            //"Lickitung",
            //"Koffing",
            //"Weezing",
            //"Rhyhorn",
            //"Rhydon",
            //"Chansey",
            //"Tangela",
            //"Kangaskhan",
            //"Horsea",
            //"Seadra",
            //"Goldeen",
            //"Seaking",
            //"Staryu",
            //"Starmie",
            //"Mr.Mime",
            //"Scyther",
            //"Jynx",
            //"Electabuzz",
            //"Magmar",
            //"Pinsir",
            //"Tauros",
            //"Magikarp",
            //"Gyarados",
            //"Lapras",
            //"Ditto",
            //"Eevee",
            //"Vaporeon",
            //"Jolteon",
            //"Flareon",
            //"Porygon",
            //"Omanyte",
            //"Omastar",
            //"Kabuto",
            //"Kabutops",
            //"Aerodactyl",
            //"Snorlax",
            //"Articuno",
            //"Zapdos",
            //"Moltres",
            //"Dratini",
            //"Dragonair",
            //"Dragonite",
            //"Mewtwo",
            //"Mew"
    };
    String button_array[] = {"A","F","S","X","U","C","W","L","G"};
    CountDownTimer main_timer;
    int wrong_answers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_pokemon);
        wrong_answers = 0;
        RelativeLayout main_timer_refresh = findViewById(R.id.catch_pokemon_layout);

        //Init Timer
        main_timer = new CountDownTimer(30000,1000){
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
        //Holds which letters you want as buttons
        input_code = "";
        String pokemon_file_name = File_Util.GetFileName(1);
        File pokemon_file = new File(getApplicationContext().getFilesDir(),pokemon_file_name);
        //Get Saved Vales
        Bundle extras = getIntent().getExtras();
        int player_number = extras.getInt("key_user_id");

        ImageButton button1 = findViewById(R.id.catch_pokemon_btn1);
        ImageButton button2 = findViewById(R.id.catch_pokemon_btn2);
        ImageButton button3 = findViewById(R.id.catch_pokemon_btn3);
        ImageButton button4 = findViewById(R.id.catch_pokemon_btn4);
        ImageButton button5 = findViewById(R.id.catch_pokemon_btn5);
        ImageButton button6 = findViewById(R.id.catch_pokemon_btn6);
        ImageButton button7 = findViewById(R.id.catch_pokemon_btn7);
        ImageButton button8 = findViewById(R.id.catch_pokemon_btn8);
        ImageButton button9 = findViewById(R.id.catch_pokemon_btn9);
        ImageButton clear_button = findViewById(R.id.catch_pokemon_clear_button);
        ImageButton enter_button = findViewById(R.id.catch_pokemon_enter_button);
        TextView input1 = findViewById(R.id.catch_pokemon_input1);
        TextView input2 = findViewById(R.id.catch_pokemon_input2);
        TextView input3 = findViewById(R.id.catch_pokemon_input3);
        TextView input4 = findViewById(R.id.catch_pokemon_input4);
        TextView input5 = findViewById(R.id.catch_pokemon_input5);
        TextView wrong_answer_text = findViewById(R.id.catch_pokemon_wrong_answers);
        wrong_answer_text.setVisibility(View.INVISIBLE);
        input_count = 0;

        //Selecting Button Icons
        for(int i=0; i < 9; i++)
        {
            switch(button_array[i])
            {
                case "A":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_a);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_a);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_a);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_a);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_a);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_a);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_a);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_a);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_a);
                            break;
                    }
                    break;
                case "B":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_b);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_b);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_b);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_b);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_b);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_b);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_b);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_b);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_b);
                            break;
                    }
                    break;
                case "C":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_c);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_c);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_c);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_c);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_c);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_c);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_c);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_c);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_c);
                            break;
                    }
                    break;
                case "D":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_d);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_d);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_d);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_d);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_d);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_d);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_d);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_d);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_d);
                            break;
                    }
                    break;
                case "E":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_e);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_e);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_e);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_e);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_e);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_e);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_e);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_e);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_e);
                            break;
                    }
                    break;
                case "F":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_f);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_f);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_f);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_f);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_f);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_f);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_f);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_f);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_f);
                            break;
                    }
                    break;
                case "G":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_g);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_g);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_g);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_g);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_g);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_g);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_g);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_g);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_g);
                            break;
                    }
                    break;
                case "H":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_h);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_h);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_h);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_h);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_h);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_h);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_h);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_h);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_h);
                            break;
                    }
                    break;
                case "I":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_i);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_i);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_i);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_i);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_i);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_i);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_i);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_i);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_i);
                            break;
                    }
                    break;
                case "J":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_j);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_j);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_j);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_j);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_j);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_j);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_j);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_j);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_j);
                            break;
                    }
                    break;
                case "K":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_k);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_k);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_k);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_k);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_k);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_k);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_k);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_k);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_k);
                            break;
                    }
                    break;
                case "L":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_l);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_l);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_l);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_l);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_l);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_l);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_l);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_l);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_l);
                            break;
                    }
                    break;
                case "M":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_m);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_m);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_m);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_m);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_m);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_m);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_m);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_m);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_m);
                            break;
                    }
                    break;
                case "N":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_n);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_n);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_n);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_n);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_n);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_n);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_n);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_n);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_n);
                            break;
                    }
                    break;
                case "O":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_o);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_o);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_o);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_o);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_o);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_o);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_o);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_o);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_o);
                            break;
                    }
                    break;
                case "P":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_p);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_p);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_p);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_p);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_p);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_p);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_p);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_p);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_p);
                            break;
                    }
                    break;
                case "Q":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_q);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_q);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_q);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_q);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_q);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_q);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_q);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_q);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_q);
                            break;
                    }
                    break;
                case "R":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_r);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_r);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_r);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_r);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_r);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_r);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_r);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_r);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_r);
                            break;
                    }
                    break;
                case "S":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_s);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_s);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_s);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_s);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_s);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_s);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_s);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_s);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_s);
                            break;
                    }
                    break;
                case "T":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_t);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_t);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_t);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_t);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_t);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_t);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_t);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_t);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_t);
                            break;
                    }
                    break;
                case "U":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_u);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_u);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_u);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_u);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_u);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_u);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_u);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_u);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_u);
                            break;
                    }
                    break;
                case "V":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_v);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_v);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_v);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_v);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_v);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_v);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_v);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_v);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_v);
                            break;
                    }
                    break;
                case "W":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_w);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_w);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_w);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_w);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_w);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_w);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_w);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_w);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_w);
                            break;
                    }
                    break;
                case "X":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_x);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_x);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_x);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_x);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_x);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_x);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_x);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_x);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_x);
                            break;
                    }
                    break;
                case "Y":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_y);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_y);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_y);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_y);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_y);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_y);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_y);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_y);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_y);
                            break;
                    }
                    break;
                case "Z":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource(R.drawable.unknown_button_z);
                            break;
                        case 1:
                            button2.setImageResource(R.drawable.unknown_button_z);
                            break;
                        case 2:
                            button3.setImageResource(R.drawable.unknown_button_z);
                            break;
                        case 3:
                            button4.setImageResource(R.drawable.unknown_button_z);
                            break;
                        case 4:
                            button5.setImageResource(R.drawable.unknown_button_z);
                            break;
                        case 5:
                            button6.setImageResource(R.drawable.unknown_button_z);
                            break;
                        case 6:
                            button7.setImageResource(R.drawable.unknown_button_z);
                            break;
                        case 7:
                            button8.setImageResource(R.drawable.unknown_button_z);
                            break;
                        case 8:
                            button9.setImageResource(R.drawable.unknown_button_z);
                            break;
                    }
                    break;

            }
        }
        button1.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button1.setImageResource(0);
                button1.setImageResource(R.drawable.unknown_button_a_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                view.performClick();
                button1.setImageResource(0);
                button1.setImageResource(R.drawable.unknown_button_a);
                input_code = input_code + button_array[0];
                switch(input_count)
                {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }

                input_count++;
            }
            return false;
        });
        button2.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button2.setImageResource(0);
                button2.setImageResource(R.drawable.unknown_button_f_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                button2.setImageResource(0);
                button2.setImageResource(R.drawable.unknown_button_f);
                input_code = input_code + button_array[1];
                switch (input_count) {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }
                input_count++;
            }
            return false;
        });
        button3.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button3.setImageResource(0);
                button3.setImageResource(R.drawable.unknown_button_s_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                button3.setImageResource(0);
                button3.setImageResource(R.drawable.unknown_button_s);
                input_code = input_code + button_array[2];
                switch (input_count) {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }
                input_count++;
            }
            return false;
        });
        button4.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button4.setImageResource(0);
                button4.setImageResource(R.drawable.unknown_button_x_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                button4.setImageResource(0);
                button4.setImageResource(R.drawable.unknown_button_x);
                input_code = input_code + button_array[3];
                switch (input_count) {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }
                input_count++;
            }
            return false;
        });
        button5.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button5.setImageResource(0);
                button5.setImageResource(R.drawable.unknown_button_u_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                button5.setImageResource(0);
                button5.setImageResource(R.drawable.unknown_button_u);

                input_code = input_code + button_array[4];
                switch (input_count) {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }
                input_count++;
            }
            return false;
        });
        button6.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button6.setImageResource(0);
                button6.setImageResource(R.drawable.unknown_button_c_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                button6.setImageResource(0);
                button6.setImageResource(R.drawable.unknown_button_c);
                input_code = input_code + button_array[5];
                switch (input_count) {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }
                input_count++;
            }
            return false;
        });
        button7.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button7.setImageResource(0);
                button7.setImageResource(R.drawable.unknown_button_w_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                button7.setImageResource(0);
                button7.setImageResource(R.drawable.unknown_button_w);
                input_code = input_code + button_array[6];
                switch (input_count) {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }
                input_count++;
            }
            return false;
        });
        button8.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button8.setImageResource(0);
                button8.setImageResource(R.drawable.unknown_button_l_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                button8.setImageResource(0);
                button8.setImageResource(R.drawable.unknown_button_l);
                input_code = input_code + button_array[7];
                switch (input_count) {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }
                input_count++;
            }
            return false;
        });
        button9.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button9.setImageResource(0);
                button9.setImageResource(R.drawable.unknown_button_g_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
                button9.setImageResource(0);
                button9.setImageResource(R.drawable.unknown_button_g);
                input_code = input_code + button_array[8];
                switch (input_count) {
                    default:
                    case 0:
                        input1.setText("*");
                        break;
                    case 1:
                        input2.setText("*");
                        break;
                    case 2:
                        input3.setText("*");
                        break;
                    case 3:
                        input4.setText("*");
                        break;
                    case 4:
                        input5.setText("*");
                        break;
                }
                input_count++;
            }
            return false;
        });
        clear_button.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                clear_button.setImageResource(0);
                clear_button.setImageResource(R.drawable.clear_button_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                clear_button.setImageResource(0);
                clear_button.setImageResource(R.drawable.clear_button);
                input_count = 0;
                input1.setText("_");
                input2.setText("_");
                input3.setText("_");
                input4.setText("_");
                input5.setText("_");
                input_code = "";
                wrong_answers = 0;
                wrong_answer_text.setVisibility(View.INVISIBLE);
            }
            return false;
        });
        enter_button.setOnTouchListener((view,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                enter_button.setImageResource(0);
                enter_button.setImageResource(R.drawable.enter_button_pressed);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                enter_button.setImageResource(0);
                enter_button.setImageResource(R.drawable.enter_button);
                int pokemon_caught = 0;
                int pokemon_id = 0;
                String wrong_answer_error;
                Intent activity_pokemon = new Intent(getApplicationContext(), PokemonActivity.class);
                if (input_count != 5) {
                    return false;
                }
                //Check if its valid pokemon code
                //Wedding Pokemon is a 25 count
                for (int i = 0; i < 25; i++) {
                    //if(input_code.equals(pokemon_codes[i]))
                    if (input_code.equals(wedding_pokemon_codes[i])) {
                        pokemon_caught = 1;
                        pokemon_id = i;
                        break;
                    }
                }
                if (pokemon_caught == 1) {
                    String test = File_Util.ReadFile(pokemon_file);
                    if (File_Util.getFoundPokemon(pokemon_file, player_number + 1, pokemon_id)) {
                        pokemon_id = 100 + pokemon_id;
                    } else {
                        File_Util.setFoundPokemon(pokemon_file, player_number + 1, pokemon_id + 1, 1);
                    }
                    //Some Screen Saying you caught a pokemon
                    //Launch back to pokedex screen

                    //username
                    main_timer.cancel();
                    activity_pokemon.putExtra("key_user_name", File_Util.getUser(pokemon_file, player_number + 1));
                    activity_pokemon.putExtra("key_pokemon_id", pokemon_id);
                    startActivity(activity_pokemon);
                } else {
                    wrong_answer_text.setVisibility(View.VISIBLE);
                    wrong_answers++;
                    wrong_answer_error = "Wrong Code- " + (3 - wrong_answers) + " more attempts!";
                    wrong_answer_text.setText(wrong_answer_error);
                    //3 Wrong Answers go to main
                    if (wrong_answers == 3) {
                        main_timer.cancel();
                        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(activityMain);
                    }
                    input_count = 0;
                    input1.setText("_");
                    input2.setText("_");
                    input3.setText("_");
                    input4.setText("_");
                    input5.setText("_");
                    input_code = "";
                }
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