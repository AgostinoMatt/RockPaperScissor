package com.matt.rockpaperscissor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.matt.rockpapersciccor.R;

public class FightSceneSimple extends AppCompatActivity implements View.OnClickListener {
    //boolean running = true;
    Player p1;
    Player p2;
    TextView playerOne;
    TextView playerTwo;
    TextView winner;
    Button show;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_scene_simple);

        playerOne = findViewById(R.id.player1);
        playerTwo = findViewById(R.id.player2);
        //TextView timer = findViewById(R.id.Timer);
        show = findViewById(R.id.showButton);
        show.setOnClickListener(this);
        winner = findViewById(R.id.winner);


        Bundle playerOneBundle = getIntent().getBundleExtra("PLAYERONE");
        Bundle playerTwoBundle = getIntent().getBundleExtra("PLAYERTWO");
        int playerTwoMove = playerTwoBundle.getInt("p2Move", 0);
        int playerOneMove = playerOneBundle.getInt("p1Move", 0);
        p1 = new Player("Player 1", playerOneMove);
        p2 = new Player("Player 2", playerTwoMove);
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
        switch(p1.moveNum){
            case 1:
                playerOne.setText("Rock");
                break;
            case 2:
                playerOne.setText("Paper");
                break;
            case 3:
                playerOne.setText("Scissors");
                break;
            default:
                break;
        }
        switch(p2.moveNum){
            case 1:
                playerTwo.setText("Rock");
                break;
            case 2:
                playerTwo.setText("Paper");
                break;
            case 3:
                playerTwo.setText("Scissors");
                break;
            default:
                break;
        }
        checkWinner();
    }

    public void checkWinner() {

        switch(p1.moveNum){
            case 1:
                switch(p2.moveNum) {
                    case 1:
                        winner.setText("Draw!");
                        final Intent redo = new Intent(this, PlayerOneSelect.class);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(redo);
                            }
                        }, 5000);
                        break;
                    case 2:
                        winner.setText("Player Two Wins!");
                        gameOver();
                    case 3:
                        winner.setText("Player One Wins!");
                        gameOver();
                    default:
                        break;
                }
            break;
            case 2:
                switch(p2.moveNum) {
                    case 1:
                        winner.setText("Player One Wins!");
                        gameOver();
                        break;
                    case 2:
                        winner.setText("Draw!");
                        final Intent redo = new Intent(this, PlayerOneSelect.class);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(redo);
                            }
                        }, 5000);
                    case 3:
                        winner.setText("Player Two Wins!");
                        gameOver();
                    default:
                        break;
                }
            break;
            case 3:
                switch(p2.moveNum) {
                    case 1:
                        winner.setText("Player Two Wins!");
                        gameOver();
                        break;
                    case 2:
                        winner.setText("Player One Wins!");
                        gameOver();
                    case 3:
                        winner.setText("Draw!");
                        final Intent redo = new Intent(this, PlayerOneSelect.class);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(redo);
                            }
                        }, 5000);
                    default:
                        break;
                }
            break;
        }

    }

    public void gameOver(){
        final Intent reset = new Intent(this, MainMenu.class);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(reset);
            }
        }, 5000);
        }
}
