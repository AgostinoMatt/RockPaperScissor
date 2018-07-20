package com.matt.rockpaperscissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.matt.rockpapersciccor.R;

import java.util.Random;


public class SinglePlayer extends AppCompatActivity implements View.OnClickListener {
        int p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_select);

        Button rock = findViewById(R.id.Rock);
        rock.setOnClickListener(this);

        Button paper = findViewById(R.id.Paper);
        paper.setOnClickListener(this);

        Button scissors = findViewById(R.id.Scissors);
        scissors.setOnClickListener(this);

        Random num = new Random();
        int moveNum = num.nextInt(3) + 1;
        p2 = moveNum;
    }

    @Override
    public void onClick(View v) {
        Bundle playerOneBundle = new Bundle();
        Bundle playerTwoBundle = new Bundle();
        switch (v.getId()) {
            case R.id.Rock:
                Intent i = new Intent(this, FightSceneSingle.class);
                playerTwoBundle.putInt("p2Move", p2);
                playerOneBundle.putInt("p1Move", 1);
                i.putExtra("PLAYERONE", playerOneBundle);
                i.putExtra("PLAYERTWO", playerTwoBundle);
                startActivity(i);
                break;
            case R.id.Paper:
                Intent j = new Intent(this, FightSceneSingle.class);
                playerTwoBundle.putInt("p2Move", p2);
                playerOneBundle.putInt("p1Move", 2);
                j.putExtra("PLAYERONE", playerOneBundle);
                j.putExtra("PLAYERTWO", playerTwoBundle);
                startActivity(j);
                break;
            case R.id.Scissors:
                Intent k = new Intent(this, FightSceneSingle.class);
                playerTwoBundle.putInt("p2Move", p2);
                playerOneBundle.putInt("p1Move", 3);
                k.putExtra("PLAYERONE", playerOneBundle);
                k.putExtra("PLAYERTWO", playerTwoBundle);
                startActivity(k);
                break;
            default:
                break;
        }
    }

}


