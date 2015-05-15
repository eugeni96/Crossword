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

        TableLayout table = GridCreator.CreateGrid(this, 10, 10);

        layout.addView(table);

        List<EditCell> cells1 = new ArrayList<>();
        cells1.add((EditCell) findViewById(12));
        cells1.add((EditCell) findViewById(22));
        cells1.add((EditCell) findViewById(32));
        cells1.add((EditCell) findViewById(42));
        cells1.add((EditCell) findViewById(52));

        Word firstWord = new Word(cells1);

        List<EditCell> cells2 = new ArrayList<>();
        cells2.add((EditCell) findViewById(13));
        cells2.add((EditCell) findViewById(23));
        cells2.add((EditCell) findViewById(33));
        cells2.add((EditCell) findViewById(43));
        cells2.add((EditCell) findViewById(53));

        Word firstWord1 = new Word(cells2);


        DBHelper helper = new DBHelper(this);
        Cursor c = helper.getWords();
        String text = null;
        if (c.moveToFirst()) {
            text = c.getString(0);
        }
        c.close();

        questionView = (TextView) findViewById(R.id.question_view);
        questionView.setText(text);



    }
}