package com.example.inheritancerpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    TextView endTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        endTxt = findViewById(R.id.endTxt);

        boolean victory = getIntent().getBooleanExtra("VICTORY", true);

        if (victory) {
            endTxt.setText("Salutations, hero! You have vanquished your foes.");
        }
        else {
            endTxt.setText("You have been vanquished");
        }
    }
}