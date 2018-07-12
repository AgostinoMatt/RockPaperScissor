package com.matt.rockpaperscissor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.matt.rockpapersciccor.R;

public class FightSceneSimple extends AppCompatActivity implements View.OnClickListener {
    //boolean running = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_scene_simple);

        TextView playerOne = findViewById(R.id.player1);
        TextView playerTwo = findViewById(R.id.player2);
        //TextView timer = findViewById(R.id.Timer);
        Button show = findViewById(R.id.showButton);
        show.setOnClickListener(this);
        TextView winner = findViewById(R.id.winner);



        Bundle playerTwoBundle = getIntent().getBundleExtra("PLAYERTWO");
        int playerTwoMove = playerTwoBundle.getInt("p2Move", 0);
        int playerOneMove = playerTwoBundle.getInt("p1Move", 0);
        Toast.makeText(getApplicationContext(),"Moves" + playerOneMove + playerTwoMove, Toast.LENGTH_LONG).show();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showButton:
                show();
                break;
            default:
                break;
        }
    }

    public void show() {

    }

}
