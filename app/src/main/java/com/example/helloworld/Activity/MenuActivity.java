package com.example.helloworld.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.DBHelper;
import com.example.helloworld.R;

import static android.view.View.*;

public class MenuActivity extends Activity {

    Button newGame;
    Button loadGame;
    Button saveGame;
    Button exit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        newGame = (Button) findViewById(R.id.newGameButton);

        newGame.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuActivity.this, NewGameActivity.class);
                startActivity(myIntent);
            }
        });
    }


}