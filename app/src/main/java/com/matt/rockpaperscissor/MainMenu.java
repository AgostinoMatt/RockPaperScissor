package com.matt.rockpaperscissor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.matt.rockpapersciccor.R;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    boolean singlePlayer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        ToggleButton mode = findViewById(R.id.toggleButton);
        mode.setChecked(true);
        mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    singlePlayer = true;
                } else {
                    singlePlayer = false;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!singlePlayer) {
            switch (v.getId()) {
                case R.id.startButton:
                    Intent i = new Intent(this, PlayerOneSelect.class);
                    startActivity(i);
                    break;
                default:
                    break;
            }
        }

        if (singlePlayer) {
            switch (v.getId()) {
                case R.id.startButton:
                    Intent i = new Intent(this, SinglePlayer.class);
                    startActivity(i);
                    break;
                default:
                    break;
            }


        }
    }
}
