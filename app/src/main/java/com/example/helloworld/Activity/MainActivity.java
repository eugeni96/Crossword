package com.example.helloworld.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.helloworld.DBHelper;
import com.example.helloworld.EditCell;
import com.example.helloworld.Grid;
import com.example.helloworld.R;
import com.example.helloworld.Word;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    TextView questionView;
    ListView questionsView;
    ArrayAdapter<String> adapter;
    List<String> questionsList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Grid.grid = (HorizontalScrollView) findViewById(R.id.horizontalView);

        Bundle extras = getIntent().getExtras();
        String templateName = "";
        if (extras != null) {
            templateName = extras.getString("templateName");
        }

        List<Word> words =  Grid.LoadTemplate(this, templateName);
        for(Word word: words)
        {
            word.letterList.get(0);
        }

        questionsView = (ListView) findViewById(R.id.listView);

        for (Word word : words)
        {
            questionsList.add(word.getHint() + ". " + word.getQuestion());
        }

        adapter = new ArrayAdapter<>(this, R.layout.simplerow, questionsList);
        questionsView.setAdapter(adapter);


    }
}