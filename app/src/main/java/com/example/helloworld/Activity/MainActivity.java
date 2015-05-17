package com.example.helloworld.Activity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.helloworld.DBHelper;
import com.example.helloworld.EditCell;
import com.example.helloworld.GridCreator;
import com.example.helloworld.R;
import com.example.helloworld.Word;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    TextView questionView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalScrollView layout = (HorizontalScrollView) findViewById(R.id.horizontalView);


        TableLayout table = GridCreator.CreateGrid(this, 9, 7);

        layout.addView(table);

        List<EditCell> cells1 = new ArrayList<>();
        for (int i=0; i<9; i++) {
            cells1.add((EditCell) findViewById(2+i*7));
        }
        Word Word1 = new Word(cells1);

        List<EditCell> cells2 = new ArrayList<>();
        for (int i=0; i<5;i++) {
            cells2.add((EditCell) findViewById(4+i*7));
        }
        Word Word2 = new Word(cells2);

        List<EditCell> cells3 = new ArrayList<>();
        for (int i=0; i<7;i++) {
            cells3.add((EditCell) findViewById(14+i));
        }
        Word Word3 = new Word(cells3);

        List<EditCell> cells4 = new ArrayList<>();
        for (int i=0; i<5;i++) {
            cells4.add((EditCell) findViewById(29+i));
        }
        Word Word4 = new Word(cells4);


        DBHelper helper = new DBHelper(this);
        Cursor c = helper.getWords();

        String text = null;
        if (c.moveToFirst()) {
            text = c.getString(2);
        }
        c.close();

        questionView = (TextView) findViewById(R.id.question_view);
        questionView.setText(text);



    }
}