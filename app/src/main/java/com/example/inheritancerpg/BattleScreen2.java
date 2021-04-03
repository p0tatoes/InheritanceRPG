package com.example.inheritancerpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.SplittableRandom;

public class BattleScreen2 extends AppCompatActivity implements View.OnClickListener{

    TextView heroNameTxt, monsterNameTxt, heroHealthTxt, monsterHealthTxt, messageTxt;
    Button attackBtn;

    int heroClass, heroCurHealth, monsterCurHealth, lostHealth, heroDMG, heroMinDMG, heroMaxDMG, monsterDMG, monsterMinDMG, monsterMaxDMG;
    int turn = 1;
    boolean victory;

    ImageView berserker;
    ImageView knight;
    ImageView oracle;
    ImageView wizard;
    ImageView assassin;
    ImageView thief;

    // Declaration for heroes
    Berserker marviticus = new Berserker("Marviticus the Savage", 1000, 45, 80); // 1
    Knight sirKent = new Knight("Sir Kent of Brado", 1350, 200, 60, 95); // 2
    Oracle yin = new Oracle("Priestess Yin", 950, 100, 50, 75); // 3
    Wizard koji = new Wizard("Ko'Ji, Master of the Dark Arts", 900, 150, 60, 90); // 4
    Assassin marcus = new Assassin("Marcus of the Sia Clan", 900, 0.25, 40, 70); // 5
    Thief ossas = new Thief("Ossas of the slums", 900, 0.3, 30, 60); // 6

    // Declaration for enemy unit
    Marauder bruticus = new Marauder("Bruticus the Marauder", 2500, 50, 70);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_screen2);

        // Declaration for UI elements
        heroNameTxt = findViewById(R.id.heroNameTxt_2);
        monsterNameTxt = findViewById(R.id.monsterNameTxt_2);
        heroHealthTxt = findViewById(R.id.heroHealthTxt_2);
        monsterHealthTxt = findViewById(R.id.monsterHealthTxt_2);
        messageTxt = findViewById(R.id.messageTxt_2);

        //Declaration for hero sprites
        berserker = findViewById(R.id.berserkerC);
        knight = findViewById(R.id.knightC);
        oracle = findViewById(R.id.oracleC);
        wizard = findViewById(R.id.wizardC);
        assassin = findViewById(R.id.assassinC);
        thief = findViewById(R.id.thiefC);

        attackBtn = findViewById(R.id.attackBtn_2);
        attackBtn.setOnClickListener(this);

        // Sets hero based on selection from previous activity
        heroClass = getIntent().getIntExtra("HERO_CLASS", 0);
        if (heroClass == 1) {
            heroNameTxt.setText(marviticus.heavyName);
            heroCurHealth = marviticus.heavyTotalHP;
            heroHealthTxt.setText("HP: "+ heroCurHealth);
            heroMinDMG = marviticus.heavyMinDMG;
            heroMaxDMG = marviticus.heavyMaxDMG;

            berserker.setVisibility(View.VISIBLE);
            knight.setVisibility(View.INVISIBLE);
            oracle.setVisibility(View.INVISIBLE);
            wizard.setVisibility(View.INVISIBLE);
            assassin.setVisibility(View.INVISIBLE);
            thief.setVisibility(View.INVISIBLE);
        }
        else if (heroClass == 2) {
            heroNameTxt.setText(sirKent.heavyName);
            heroCurHealth = sirKent.heavyTotalHP;
            heroHealthTxt.setText("HP: "+heroCurHealth);
            heroMinDMG = sirKent.heavyMinDMG;
            heroMaxDMG = sirKent.heavyMaxDMG;

            berserker.setVisibility(View.INVISIBLE);
            knight.setVisibility(View.VISIBLE);
            oracle.setVisibility(View.INVISIBLE);
            wizard.setVisibility(View.INVISIBLE);
            assassin.setVisibility(View.INVISIBLE);
            thief.setVisibility(View.INVISIBLE);
        }
        else if (heroClass == 3) {
            heroNameTxt.setText(yin.mageName);
            heroCurHealth = yin.mageTotalHP;
            heroHealthTxt.setText("HP: "+heroCurHealth);
            heroMinDMG = yin.mageMinDMG;
            heroMaxDMG = yin.mageMaxDmg;

            berserker.setVisibility(View.INVISIBLE);
            knight.setVisibility(View.INVISIBLE);
            oracle.setVisibility(View.VISIBLE);
            wizard.setVisibility(View.INVISIBLE);
            assassin.setVisibility(View.INVISIBLE);
            thief.setVisibility(View.INVISIBLE);
        }
        else if (heroClass == 4) {
            heroNameTxt.setText(koji.mageName);
            heroCurHealth = koji.mageTotalHP;
            heroHealthTxt.setText("HP: "+heroCurHealth);
            heroMinDMG = koji.mageMinDMG;
            heroMaxDMG = koji.mageMaxDmg;

            berserker.setVisibility(View.INVISIBLE);
            knight.setVisibility(View.INVISIBLE);
            oracle.setVisibility(View.INVISIBLE);
            wizard.setVisibility(View.VISIBLE);
            assassin.setVisibility(View.INVISIBLE);
            thief.setVisibility(View.INVISIBLE);
        }
        else if (heroClass == 5) {
            heroNameTxt.setText(marcus.lightName);
            heroCurHealth = marcus.lightTotalHP;
            heroHealthTxt.setText("HP: "+heroCurHealth);
            heroMinDMG = marcus.lightMinDMG;
            heroMaxDMG = marcus.lightMaxDMG;

            berserker.setVisibility(View.INVISIBLE);
            knight.setVisibility(View.INVISIBLE);
            oracle.setVisibility(View.INVISIBLE);
            wizard.setVisibility(View.INVISIBLE);
            assassin.setVisibility(View.VISIBLE);
            thief.setVisibility(View.INVISIBLE);
        }
        else if (heroClass == 6) {
            heroNameTxt.setText(ossas.lightName);
            heroCurHealth = ossas.lightTotalHP;
            heroHealthTxt.setText("HP: "+heroCurHealth);
            heroMinDMG = ossas.lightMinDMG;
            heroMaxDMG = ossas.lightMaxDMG;

            berserker.setVisibility(View.INVISIBLE);
            knight.setVisibility(View.INVISIBLE);
            oracle.setVisibility(View.INVISIBLE);
            wizard.setVisibility(View.INVISIBLE);
            assassin.setVisibility(View.INVISIBLE);
            thief.setVisibility(View.VISIBLE);
        }

        //Sets enemy info in the UI
        monsterNameTxt.setText(bruticus.monsterName);
        monsterCurHealth = bruticus.monsterTotalHP;
        monsterHealthTxt.setText("HP: "+monsterCurHealth);
        monsterMinDMG = bruticus.monsterMinDMG;
        monsterMaxDMG = bruticus.monsterMaxDMG;

    }

    @Override
    public void onClick (View v) {

        Intent end = new Intent(this, EndScreen.class);

        SplittableRandom rand = new SplittableRandom();

        if (heroClass == 1) { // Damage scaling for Berserker
            heroDMG = rand.nextInt(heroMaxDMG - heroMinDMG) + heroMinDMG;
            lostHealth = marviticus.heavyTotalHP - heroCurHealth;
            heroDMG += Math.round(lostHealth * 0.25);
        }
        else { // Default damage calculation
            heroDMG = rand.nextInt(heroMaxDMG - heroMinDMG) + heroMinDMG;
        }

        monsterDMG = rand.nextInt(monsterMaxDMG - monsterMinDMG) + monsterMinDMG; // Damage calculation for the enemy

        switch (v.getId()) {
            case R.id.attackBtn_2:
                if (turn % 2 == 1) { // Hero's turn
                    turn++;
                    if (heroClass == 5 && rand.nextDouble(0, 1) < marcus.evasion) { // Assassin passive
                        heroDMG *= 2;
                        monsterCurHealth = Math.max(0, monsterCurHealth - heroDMG);
                        monsterHealthTxt.setText("HP: "+ monsterCurHealth);
                        messageTxt.setText("You dealt "+ heroDMG+ ". It was a critical hit!");
                        messageTxt.setTextColor(Color.parseColor("#eb582f"));
                        if (monsterCurHealth == 0) {
                            victory = true;
                            end.putExtra("VICTORY", victory);
                            startActivity(end);
                        }
                    }
                    else if (heroClass == 3 || heroClass == 4) { // Mage reduced damage to marauder
                        heroDMG -= Math.round(0.3 * heroDMG);
                        monsterCurHealth = Math.max(0, monsterCurHealth - heroDMG);
                        monsterHealthTxt.setText("HP: "+ monsterCurHealth);
                        messageTxt.setText("You dealt "+ heroDMG);
                        messageTxt.setTextColor(Color.parseColor("#39d4cc"));
                        if (monsterCurHealth == 0) {
                            victory = true;
                            end.putExtra("VICTORY", victory);
                            startActivity(end);
                        }
                    }
                    else {
                        monsterCurHealth = Math.max(0, monsterCurHealth - heroDMG);
                        monsterHealthTxt.setText("HP: "+ monsterCurHealth);
                        messageTxt.setText("You dealt "+ heroDMG);
                        messageTxt.setTextColor(Color.parseColor("#c7c150"));
                        if (monsterCurHealth == 0) {
                            victory = true;
                            end.putExtra("VICTORY", victory);
                            startActivity(end);
                        }
                    }
                }
                else if (turn % 2 != 1) { // Enemy's turn
                    turn++;
                    if (heroClass == 6 && rand.nextDouble(0, 1) < ossas.evasion) { // Thief passive
                        heroHealthTxt.setText("HP: "+ heroCurHealth);
                        messageTxt.setText("Enemy dealt 0 damage. Attack has been evaded.");
                        messageTxt.setTextColor(Color.parseColor("#FFFFF"));
                    }
                    else {
                        heroCurHealth = Math.max(0, heroCurHealth - monsterDMG);
                        heroHealthTxt.setText("HP: "+ heroCurHealth);
                        messageTxt.setText("Enemy dealt "+ monsterDMG);
                        messageTxt.setTextColor(Color.parseColor("#c93208"));
                        if (heroCurHealth == 0) {
                            victory = false;
                            end.putExtra("VICTORY", victory);
                            startActivity(end);
                        }
                    }
                }
                break;
        }
    }
}