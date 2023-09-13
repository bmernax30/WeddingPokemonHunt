package com.example.weddingpokemonhunt;

import androidx.annotation.RequiresPermission;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_Util {
    static int NUMBER_OF_POKEMON = 150;
    private File_Util() {
    }

    public static void setFoundPokemon(java.io.File file, int player_number, int pokemon_number, int found)
    {
        String current_string = getPokemonString(file,player_number);
        String new_string = getPokemonString(file,player_number);
        String file_string = ReadFile(file);
        new_string = "#"+player_number+"#"+getUser(file,player_number) + "#" + current_string.substring(0,(pokemon_number-1)) + found + current_string.substring((pokemon_number-1)+1);
        current_string = "#"+player_number+"#"+getUser(file,player_number) + "#" + current_string;
        WriteFile(file,file_string.replace(current_string,new_string),false);
    }
    public static int getPokemonCount(java.io.File file, int player_number)
    {
        String pokemon_string = getPokemonString(file,player_number);
        byte[] pokemon_bytes = pokemon_string.getBytes();
        int pokemon_count = 0;

        for(int i = 0; i < pokemon_string.length(); i++)
        {
            if(pokemon_bytes[i] == 49)
            {
                pokemon_count++;
            }
        }

        return pokemon_count;
    }
    public static String getPokemonString(java.io.File file, int player_number)
    {
        String user_data = ReadFile(file);
        String pokemon_string;
        int start_pound_sign = (player_number-1)*3 + 5;
        int end_pound_sign = start_pound_sign + 1;
        int start_index = 1; //Will return mulverna if no name exists
        int end_index = 8;
        int pound_sign_count = 0;

        byte[] user_data_bytes = user_data.getBytes();
        for(int i=0; i<user_data_bytes.length; i++)
        {
            //Pound Sign
            if(user_data_bytes[i] == 35)
            {
                pound_sign_count++;
                if(pound_sign_count == start_pound_sign)
                {
                    start_index = i+1;
                }
                if(pound_sign_count == end_pound_sign)
                {
                    end_index = i;
                    break;
                }
            }
        }
        pokemon_string = user_data.substring(start_index,end_index);
        return pokemon_string;
    }
    public static String getUser(java.io.File file, int player_number)
    {
        String user_data = ReadFile(file);
        String user_name;
        int start_pound_sign = (player_number-1)*3 + 4;
        int end_pound_sign = start_pound_sign + 1;
        int start_index = 1; //Will return mulverna if no name exists
        int end_index = 8;
        int pound_sign_count = 0;

        byte[] user_data_bytes = user_data.getBytes();
        for(int i=0; i<user_data_bytes.length; i++)
        {
            //Pound Sign
            if(user_data_bytes[i] == 35)
            {
                pound_sign_count++;
                if(pound_sign_count == start_pound_sign)
                {
                    start_index = i+1;
                }
                if(pound_sign_count == end_pound_sign)
                {
                    end_index = i;
                    break;
                }
            }
        }
        user_name = user_data.substring(start_index,end_index);
        return user_name;
    }
    public static void addUser(java.io.File file, String user_name)
    {
        int user_number = getTotalPlayers(file) + 1;
        StringBuilder text = new StringBuilder(user_number + "#" + user_name + "#");
        for(int i=0; i < NUMBER_OF_POKEMON; i++)
        {
            text.append("0");
        }
        text.append("#");
        WriteFile(file, text.toString(), true);
        updatePlayerTotal(file);
    }
    public static void updatePlayerTotal(java.io.File file)
    {
        String text = ReadFile(file);
        String num_players_string;
        String old_players_string;

        int current_total_players = getTotalPlayers(file);
        int new_total_players = current_total_players + 1;

        if(current_total_players < 10)
        {
            old_players_string = "00" + current_total_players;
        }
        else if(current_total_players < 100)
        {
            old_players_string = "0" + current_total_players;
        }
        else
        {
            old_players_string = Integer.toString(current_total_players);
        }
        old_players_string = "T"+old_players_string;

        if(new_total_players < 10)
        {
            num_players_string = "00" + new_total_players;
        }
        else if(new_total_players < 100)
        {
            num_players_string = "0" + new_total_players;
        }
        else
        {
            num_players_string = Integer.toString(new_total_players);
        }
        num_players_string = "T"+ num_players_string;

        text = text.replace(old_players_string,num_players_string);
        WriteFile(file,text,false);
    }
    public static int getTotalPlayers(java.io.File file)
    {
        //23,24,25,26
        String text = ReadFile(file);
        int value = 0;
        char test24 = text.charAt(24);
        char test25 = text.charAt(25);
        char test26 = text.charAt(26);
        if(Integer.parseInt(String.valueOf(text.charAt(24))) != 0)
        {
            value = Integer.parseInt(String.valueOf(text.charAt(24))) * 100;
        }
        if(Integer.parseInt(String.valueOf(text.charAt(25))) != 0)
        {
            value = Integer.parseInt(String.valueOf(text.charAt(25))) * 10;
        }
        if(Integer.parseInt(String.valueOf(text.charAt(26))) != 0)
        {
            value = Integer.parseInt(String.valueOf(text.charAt(26)));
        }

        return value;
    }

    public static void initFile(java.io.File file)
    {
        String text = "#MULVERNA POKEMON GAME#T000#";
        WriteFile(file,text.toString(), false);
    }
    public static String insertString(String originalString, String stringToBeInserted, int index)
    {

        // Create a new string
        originalString = originalString.substring(0, index + 1)
                + stringToBeInserted
                + originalString.substring(index + 1);

        // return the modified String
        return originalString;
    }
    public static void WriteFile(java.io.File file, String text, boolean append)
    {
        //Initialize Stream
        FileOutputStream stream = null;

        //Set Stream to Desired File
        //True makes it append the file
        try
        {
            stream = new FileOutputStream(file,append);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        //Write Data to Stream
        try
        {
            stream.write(text.getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Close Stream
        try
        {
            stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String ReadFile(java.io.File file)
    {
        //Initialize Variables and Stream
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        FileInputStream stream_in = null;

        //Check if file is empty
        if(length == 0)
        {
            return "error";
        }

        //Open the Read Stream
        try
        {
            stream_in = new FileInputStream(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        //Read All the Bytes
        try
        {
            stream_in.read(bytes);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Close Stream
        try
        {
            stream_in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String contents = new String(bytes);
        return contents;
    }
    public static void ClearFile(java.io.File file)
    {
        WriteFile(file,"",false);
    }
    public static String GetFileName(int file)
    {
        String file_name;
        switch(file)
        {
            case 1:
                file_name = "pokemon.txt";
                break;
            default:
                file_name = "File Does Not Exist";
                break;
        }
        return file_name;
    }
}

