package com.example.helloworld.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CrosswordDB";
    public static final String WORDS_TABLE_NAME = "words";
    public static final String MASK_TABLE_NAME = "mask";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Cursor getAllCursors() {
        return getReadableDatabase().rawQuery(
                "SELECT * FROM " + DBHelper.WORDS_TABLE_NAME
                        + " ORDER BY " + .COLUMN_ID + "*60 + " + WORDS.COLUMN_MINUTES + " ASC ", null);

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
