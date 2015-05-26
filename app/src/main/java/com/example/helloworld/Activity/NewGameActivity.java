package com.example.helloworld.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helloworld.DBHelper;
import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class NewGameActivity extends Activity {

    Button start;
    ListView listTemplates;
    ArrayAdapter<String> adapter;
    List<String> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        listTemplates = (ListView) findViewById(R.id.listView);

        DBHelper helper = new DBHelper(this);
        List<String> listViewValues = helper.getTemplateNames();

        adapter = new ArrayAdapter<>(this, R.layout.simplerow, listViewValues);
        listTemplates.setAdapter(adapter);

        listTemplates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String templateName = (String) (listTemplates.getItemAtPosition(position));
                Intent myIntent = new Intent(NewGameActivity.this, MainActivity.class);
                myIntent.putExtra("templateName",templateName);
                startActivity(myIntent);
            }
        });

        start = (Button) findViewById(R.id.startGameButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NewGameActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_game, menu);
        return true;
    }

}