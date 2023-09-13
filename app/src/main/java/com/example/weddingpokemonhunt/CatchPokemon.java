package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class CatchPokemon extends AppCompatActivity{
    int input_count = 0;
    String button_array[] = {"A","B","C","D","E","F","G","H","I"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_pokemon);

        //Holds which letters you want as buttons

        String input_code[] = {"A","A","A","A","A"};

        String pokemon_file_name = File_Util.GetFileName(1);
        File pokemon_file = new File(getApplicationContext().getFilesDir(),pokemon_file_name);

        ImageView button1 = findViewById(R.id.catch_pokemon_btn1);
        ImageView button2 = findViewById(R.id.catch_pokemon_btn2);
        ImageView button3 = findViewById(R.id.catch_pokemon_btn3);
        ImageView button4 = findViewById(R.id.catch_pokemon_btn4);
        ImageView button5 = findViewById(R.id.catch_pokemon_btn5);
        ImageView button6 = findViewById(R.id.catch_pokemon_btn6);
        ImageView button7 = findViewById(R.id.catch_pokemon_btn7);
        ImageView button8 = findViewById(R.id.catch_pokemon_btn8);
        ImageView button9 = findViewById(R.id.catch_pokemon_btn9);

        TextView input1 = findViewById(R.id.catch_pokemon_input1);
        TextView input2 = findViewById(R.id.catch_pokemon_input2);
        TextView input3 = findViewById(R.id.catch_pokemon_input3);
        TextView input4 = findViewById(R.id.catch_pokemon_input4);
        TextView input5 = findViewById(R.id.catch_pokemon_input5);
        input_count = 0;

        for(int i=0; i < 4; i++)
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
                            button2.setImageResource((R.drawable.unknown_button_a));
                            break;
                        case 2:
                            button3.setImageResource((R.drawable.unknown_button_a));
                            break;
                        case 3:
                            button4.setImageResource((R.drawable.unknown_button_a));
                            break;
                        case 4:
                            button5.setImageResource((R.drawable.unknown_button_a));
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
                            button2.setImageResource((R.drawable.unknown_button_b));
                            break;
                        case 2:
                            button3.setImageResource((R.drawable.unknown_button_b));
                            break;
                        case 3:
                            button4.setImageResource((R.drawable.unknown_button_b));
                            break;
                        case 4:
                            button5.setImageResource((R.drawable.unknown_button_b));
                            break;
                    }
                    break;
                case "C":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource((R.drawable.unknown_button_c));
                            break;
                        case 1:
                            button2.setImageResource((R.drawable.unknown_button_c));
                            break;
                        case 2:
                            button3.setImageResource((R.drawable.unknown_button_c));
                            break;
                        case 3:
                            button4.setImageResource((R.drawable.unknown_button_c));
                            break;
                        case 4:
                            button5.setImageResource((R.drawable.unknown_button_c));
                            break;
                    }
                    break;
                case "D":
                    switch(i)
                    {
                        case 0:
                            button1.setImageResource((R.drawable.unknown_button_d));
                            break;
                        case 1:
                            button2.setImageResource((R.drawable.unknown_button_d));
                            break;
                        case 2:
                            button3.setImageResource((R.drawable.unknown_button_d));
                            break;
                        case 3:
                            button4.setImageResource((R.drawable.unknown_button_d));
                            break;
                        case 4:
                            button5.setImageResource((R.drawable.unknown_button_d));
                            break;
                    }
                    break;
                case "E":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_e));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_e));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_e));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_e));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_e));
                            break;
                    }
                    break;
                case "F":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_f));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_f));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_f));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_f));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_f));
                            break;
                    }
                    break;
                case "G":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_g));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_g));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_g));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_g));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_g));
                            break;
                    }
                    break;
                case "H":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_h));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_h));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_h));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_h));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_h));
                            break;
                    }
                    break;
                case "I":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_i));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_i));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_i));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_i));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_i));
                            break;
                    }
                    break;
                case "J":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_j));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_j));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_j));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_j));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_j));
                            break;
                    }
                    break;
                case "K":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_k));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_k));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_k));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_k));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_k));
                            break;
                    }
                    break;
                case "L":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_l));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_l));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_l));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_l));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_l));
                            break;
                    }
                    break;
                case "M":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_m));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_m));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_m));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_m));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_m));
                            break;
                    }
                    break;
                case "N":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_n));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_n));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_n));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_n));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_n));
                            break;
                    }
                    break;
                case "O":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_o));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_o));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_o));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_o));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_o));
                            break;
                    }
                    break;
                case "P":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_p));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_p));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_p));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_p));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_p));
                            break;
                    }
                    break;
                case "Q":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_q));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_q));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_q));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_q));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_q));
                            break;
                    }
                    break;
                case "R":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_r));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_r));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_r));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_r));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_r));
                            break;
                    }
                    break;
                case "S":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_s));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_s));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_s));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_s));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_s));
                            break;
                    }
                    break;
                case "T":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_t));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_t));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_t));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_t));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_t));
                            break;
                    }
                    break;
                case "U":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_u));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_u));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_u));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_u));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_u));
                            break;
                    }
                    break;
                case "V":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_v));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_v));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_v));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_v));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_v));
                            break;
                    }
                    break;
                case "W":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_w));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_w));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_w));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_w));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_w));
                            break;
                    }
                    break;
                case "X":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_x));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_x));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_x));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_x));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_x));
                            break;
                    }
                    break;
                case "Y":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_y));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_y));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_y));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_y));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_y));
                            break;
                    }
                    break;
                case "Z":
                    switch(i)
                    {
                        case 0:
                            button1.setBackgroundResource((R.drawable.unknown_button_z));
                            break;
                        case 1:
                            button2.setBackgroundResource((R.drawable.unknown_button_z));
                            break;
                        case 2:
                            button3.setBackgroundResource((R.drawable.unknown_button_z));
                            break;
                        case 3:
                            button4.setBackgroundResource((R.drawable.unknown_button_z));
                            break;
                        case 4:
                            button5.setBackgroundResource((R.drawable.unknown_button_z));
                            break;
                    }
                    break;

            }
        }
        button1.setOnClickListener(view -> {
            input_code[input_count] = button_array[0];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
        button2.setOnClickListener(view -> {
            input_code[input_count] = button_array[1];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
        button3.setOnClickListener(view -> {
            input_code[input_count] = button_array[2];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
        button4.setOnClickListener(view -> {
            input_code[input_count] = button_array[3];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
        button5.setOnClickListener(view -> {
            input_code[input_count] = button_array[4];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
        button6.setOnClickListener(view -> {
            input_code[input_count] = button_array[5];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
        button7.setOnClickListener(view -> {
            input_code[input_count] = button_array[6];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
        button8.setOnClickListener(view -> {
            input_code[input_count] = button_array[7];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
        button9.setOnClickListener(view -> {
            input_code[input_count] = button_array[8];
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
            if(input_count == 5)
            {
                input_count = 0;
            }
        });
    }
}