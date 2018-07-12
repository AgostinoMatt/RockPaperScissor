package com.matt.rockpaperscissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.matt.rockpapersciccor.R;

public class PlayerOneSelect extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_one_select);

        Button rock = findViewById(R.id.Rock);
        rock.setOnClickListener(this);

        Button paper = findViewById(R.id.Paper);
        paper.setOnClickListener(this);

        Button scissors = findViewById(R.id.Scissors);
        scissors.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Bundle playerOneBundle = new Bundle();
        switch (v.getId()) {
            case R.id.Rock:
                Intent i = new Intent(this, PlayerTwoSelect.class);
                playerOneBundle.putInt("p1Move", 1);
                i.putExtra("PLAYERONE", playerOneBundle);
                startActivity(i);
                break;
            case R.id.Paper:
                Intent j = new Intent(this, PlayerTwoSelect.class);
                playerOneBundle.putInt("p1Move", 2);
                j.putExtra("PLAYERONE", playerOneBundle);
                startActivity(j);
                break;
            case R.id.Scissors:
                Intent k = new Intent(this, PlayerTwoSelect.class);
                playerOneBundle.putInt("p1Move", 3);
                k.putExtra("PLAYERONE", playerOneBundle);
                startActivity(k);
                break;
            default:
                break;
        }
    }
}
