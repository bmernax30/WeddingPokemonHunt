package com.example.weddingpokemonhunt;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }
    @Override public void onBackPressed()
    {
        Intent activityMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(activityMain);
        super.onBackPressed();
    }
}
