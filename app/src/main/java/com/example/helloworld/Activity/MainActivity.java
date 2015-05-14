package com.example.helloworld.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;

import com.example.helloworld.EditCell;
import com.example.helloworld.GridCreator;
import com.example.helloworld.R;
import com.example.helloworld.Word;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalScrollView layout = (HorizontalScrollView) findViewById(R.id.horizontalView);

        TableLayout table = GridCreator.CreateGrid(this, 10, 10);

        layout.addView(table);

        List<EditCell> cells = new ArrayList<>();
        cells.add((EditCell) findViewById(12));
        cells.add((EditCell) findViewById(22));
        cells.add((EditCell) findViewById(32));
        cells.add((EditCell) findViewById(42));
        cells.add((EditCell) findViewById(52));

        Word firstWord = new Word(cells);

    }
}