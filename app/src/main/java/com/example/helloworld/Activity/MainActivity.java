package com.example.helloworld.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;

import com.example.helloworld.DataBase.DBHelper;
import com.example.helloworld.EditCell;
import com.example.helloworld.GridCreator;
import com.example.helloworld.R;
import com.example.helloworld.Word;

import android.content.ContentValues;
import android.content.Context;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener {

    final String LOG_TAG = "myLogs";

    EditText etWord, etMask;

    DBHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalScrollView layout = (HorizontalScrollView) findViewById(R.id.horizontalView);

        TableLayout table = GridCreator.CreateGrid(this, 10, 10);

        layout.addView(table);

        List<EditCell> cells = new ArrayList<>();
        cells.add((EditCell) layout.findViewById(12));
        cells.add((EditCell) layout.findViewById(22));
        cells.add((EditCell) layout.findViewById(32));
        cells.add((EditCell)findViewById(42));
        cells.add((EditCell)findViewById(52));

        Word firstWord = new Word(cells);

        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);

    }

    @Override
    public void onClick(View v){
        ContentValues cv = new ContentValues();

        // получаем данные из полей ввода
        String word = etWord.getText().toString();
        String mask = etMask.getText().toString();

        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "Word", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            Log.d(LOG_TAG,  "--- onCreate database ---");
            //Создаем таблицу с полями
            db.execSQL("create table Word  ("
                + "id integer primary key autoincrement,"
                + "word,"
                + "question" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        }
    }
}