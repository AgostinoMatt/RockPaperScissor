package com.matt.rockpaperscissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.matt.rockpapersciccor.R;

public class PlayerTwoSelect extends AppCompatActivity implements View.OnClickListener {
        int p1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_two_select);

        Button rock = findViewById(R.id.Rock);
        rock.setOnClickListener(this);

        Button paper = findViewById(R.id.Paper);
        paper.setOnClickListener(this);

        Button scissors = findViewById(R.id.Scissors);
        scissors.setOnClickListener(this);

        Bundle playerOne = getIntent().getBundleExtra("PLAYERONE");
        int playerOneMove = playerOne.getInt("p1Move", 0);
        p1 = playerOneMove;
    }


    @Override
    public void onClick(View v) {

        Bundle playerTwoBundle = new Bundle();
        switch (v.getId()) {
            case R.id.Rock:
                Intent i = new Intent(this, FightSceneSimple.class);
                playerTwoBundle.putInt("p2Move", 1);
                playerTwoBundle.putInt("p1Move", p1);
                i.putExtra("PLAYERTWO", playerTwoBundle);
                startActivity(i);
            case R.id.Paper:
                Intent j = new Intent(this, FightSceneSimple.class);
                playerTwoBundle.putInt("p2Move", 2);
                playerTwoBundle.putInt("p1Move", p1);
                j.putExtra("PLAYERTWO", playerTwoBundle);
                startActivity(j);
            case R.id.Scissors:
                Intent k = new Intent(this, FightSceneSimple.class);
                playerTwoBundle.putInt("p2Move", 3);
                playerTwoBundle.putInt("p1Move", p1);
                k.putExtra("PLAYERTWO", playerTwoBundle);
                startActivity(k);
            default:
                break;
        }
    }
}
