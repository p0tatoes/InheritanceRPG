package com.example.inheritancerpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectionScreen extends AppCompatActivity implements View.OnClickListener {

    TextView statTxt;
    Button berserkerBtn, knightBtn, oracleBtn, wizardBtn, assassinBtn, thiefBtn, selectionBtn;
    int heroClass;

    // Declaration for classes
    Berserker marviticus = new Berserker("Marviticus the Savage", 1000, 45, 80); // 1
    Knight sirKent = new Knight("Sir Kent of Brado", 1350, 200, 60, 95); // 2
    Oracle yin = new Oracle("Priestess Yin", 950, 100, 50, 75); // 3
    Wizard koji = new Wizard("Ko'Ji, Master of the Dark Arts", 900, 150, 60, 90); // 4
    Assassin marcus = new Assassin("Marcus of the Sia Clan", 900, 0.25, 40, 70); // 5
    Thief ossas = new Thief("Ossas of the slums", 900, 0.3, 30, 60); // 6

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);

        // Declaration for UI elements
        statTxt = findViewById(R.id.statTxt);

        berserkerBtn = findViewById(R.id.berserkerBtn);
        berserkerBtn.setOnClickListener(this);

        knightBtn = findViewById(R.id.knightBtn);
        knightBtn.setOnClickListener(this);

        oracleBtn = findViewById(R.id.oracleBtn);
        oracleBtn.setOnClickListener(this);

        wizardBtn = findViewById(R.id.wizardBtn);
        wizardBtn.setOnClickListener(this);

        assassinBtn = findViewById(R.id.assassinBtn);
        assassinBtn.setOnClickListener(this);

        thiefBtn = findViewById(R.id.thiefBtn);
        thiefBtn.setOnClickListener(this);

        selectionBtn = findViewById(R.id.selectionBtn);
        selectionBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent battle = new Intent(this, BattleScreen.class);

        switch (v.getId()) {
            case R.id.berserkerBtn:
                heroClass = 1;
                statTxt.setText(marviticus.heavyName+ "\n"+
                        "STATS:\n"+
                        "HP: "+ marviticus.heavyTotalHP+ "\n"+
                        "DAMAGE: "+ marviticus.heavyMinDMG+ " - "+ marviticus.heavyMaxDMG+"\n\n"+
                        "A HERO THAT DEALS MORE DAMAGE WHEN WEAKENED" +
                        "\n\nSPECIAL ATTRIBUTE: DAMAGE INCREASES BY 25% PER POINT OF HEALTH LOST");
                break;
            case R.id.knightBtn:
                heroClass = 2;
                statTxt.setText(sirKent.heavyName+ "\n"+
                        "STATS:\n"+
                        "HP: "+ sirKent.heavyTotalHP+ "\n"+
                        "DAMAGE: "+ sirKent.heavyMinDMG+ " - "+ sirKent.heavyMaxDMG+ "\n\n"+
                        "A HERO THAT BOASTS SUPERIOR DURABILITY");
                break;
            case R.id.oracleBtn:
                heroClass = 3;
                statTxt.setText(yin.mageName+ "\n"+
                        "STATS:\n"+
                        "HP:"+ yin.mageTotalHP+ "\n"+
                        "DAMAGE: "+ yin.mageMinDMG+ " - "+ yin.mageMaxDmg+ "\n\n"+
                        "A HERO THAT DEALS MAGICAL DAMAGE AND BOASTS HIGHER DURABILITY" +
                        "\n\nSPECIAL ATTRIBUTE: DEALS 15% MORE DAMAGE TO UNDEAD");
                break;
            case R.id.wizardBtn:
                heroClass = 4;
                statTxt.setText(koji.mageName+ "\n"+
                        "STATS:\n"+
                        "HP:"+ koji.mageTotalHP+ "\n"+
                        "DAMAGE: "+ koji.mageMinDMG+ " - "+ koji.mageMaxDmg+ "\n\n"+
                        "A HERO THAT BOASTS SUPERIOR MAGICAL DAMAGE" +
                        "\n\nSPECIAL ATTRIBUTE: DEALS 15% MORE DAMAGE TO UNDEAD");
                break;
            case R.id.assassinBtn:
                heroClass = 5;
                statTxt.setText(marcus.lightName+ "\n"+
                        "STATS:\n"+
                        "HP:"+ marcus.lightTotalHP+ "\n"+
                        "DAMAGE: "+ marcus.lightMinDMG+ " - "+ marcus.lightMaxDMG+ "\n\n"+
                        "A HERO THAT HAS A CHANCE TO DO DOUBLE DAMAGE" +
                        "\n\nSPECIAL ATTRIBUTE: HAS 25% CHANCE TO DEAL DOUBLE DAMAGE");
                break;
            case R.id.thiefBtn:
                heroClass = 6;
                statTxt.setText(ossas.lightName+ "\n"+
                        "STATS:\n"+
                        "HP:"+ ossas.lightTotalHP+ "\n"+
                        "DAMAGE: "+ ossas.lightMinDMG+ " - "+ ossas.lightMaxDMG+ "\n\n"+
                        "A HERO THAT HAS A CHANCE TO EVADE ATTACKS" +
                        "\n\nSPECIAL ATTRIBUTE: HAS 30% CHANCE TO EVADE INCOMING DAMAGE");
                break;
            case R.id.selectionBtn:
                if (heroClass > 0) {
                    battle.putExtra("HERO_CLASS", heroClass);
                    startActivity(battle);
                }
                break;
        }

    }
}