package com.example.inheritancerpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity implements View.OnClickListener {

    TextView endTxt;
    Button retryBtn;
    boolean victory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        // Declaration for UI elements
        retryBtn = findViewById(R.id.retryBtn);
        retryBtn.setOnClickListener(this);
        endTxt = findViewById(R.id.endTxt);

        // Gets victory value from previous activities
        victory = getIntent().getBooleanExtra("VICTORY", true);

        if (victory) {
            endTxt.setText("Salutations, hero! You have vanquished your foes.");
        }
        else {
            endTxt.setText("You have been vanquished");
        }
    }

    @Override
    public void onClick (View v) {

        Intent start = new Intent(this, SelectionScreen.class);

        switch (v.getId()) {
            case R.id.retryBtn:
                startActivity(start);
            break;
        }
    }
}