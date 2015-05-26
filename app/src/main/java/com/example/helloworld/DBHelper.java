package com.example.helloworld;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.UserDictionary;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteAssetHelper {

/*        public static final String TABLE_WORDS = "words";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_WORD = "russWord";
        public static final String COLUMN_QUESTION = "question"; */

    private static final String TAG = SQLiteAssetHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "crossword.sqlite";
    private static final int DATABASE_VERSION = 1;

    public interface TABLES {
        String WORD = "WORD";
        String MASK = "MASK";
        String TEMPLATE = "TEMPLATE";
    }

    public interface WordColumns {
        String COLUMN_ID = "_id";
        String COLUMN_WORD = "word";
        String COLUMN_QUESTION = "question";
        String COLUMN_ENG_WORD = "engWord";


    }

    public interface TemplateColumns {
        String COLUMN_ID = "_id";
        String COLUMN_X_Y = "x_y";
        String COLUMN_LENGTH = "length";
        String COLUMN_HORIZONTAL = "horizontal";
    }

    public interface MaskColumns {
        String COLUMN_ID = "_id";
        String COLUMN_X_Y = "x_y";
        String COLUMN_WORD = "word";
        String COLUMN_HORIZONTAL = "horizontal";
    }


    // Database creation sql statement
        /*private static final String DATABASE_CREATE = "create table "
                + TABLE_WORDS + "(" + COLUMN_ID
                + " integer primary key autoincrement, "
                + COLUMN_WORD
                + " text not null"
                + COLUMN_QUESTION + "text not null);"; */

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public Cursor getWords() {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(TABLES.WORD);
        Cursor c = qb.query(db, null, null, null, null, null, null);

        return c;
    }

    public Cursor getSizeRaw(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String queryString =
                "SELECT max(length) FROM TEMPLATE " +
                        "WHERE horizontal = 1";

//        qb.setTables(TABLES.TEMPLATE);
//        Cursor c = qb.query(db,{TemplateColumns.COLUMN_LENGTH}, TemplateColumns.COLUMN_HORIZONTAL+"=0", "SELECT max("+TemplateColumns.COLUMN_LENGTH+")",null,null,null );
        return db.rawQuery(queryString,null);
    }

    public Cursor getSizeColumn(){
        SQLiteDatabase db = getReadableDatabase();
        String queryString =
                "SELECT max(length) FROM TEMPLATE " +
                        "WHERE horizontal = 0";
        return db.rawQuery(queryString,null);
    }
    public int[] getTemplateSize(String templateName)
    {
        SQLiteDatabase db = getReadableDatabase();
        String queryString = "SELECT x, y FROM TEMPLATE WHERE name = \"" + templateName + "\"";
        Cursor c = db.rawQuery(queryString, null);
        int[] size = new int[2];
        if(c != null)
        {
            c.moveToFirst();
            size[0] = c.getInt(c.getColumnIndex("x"));
            size[1] = c.getInt(c.getColumnIndex("y"));
            c.close();
        }
        return size;
    }

    public int getTemplateIdByName(String templateName)
    {
        SQLiteDatabase db = getReadableDatabase();
        String queryString = "SELECT _id FROM TEMPLATE WHERE name = \"" + templateName + "\"";
        Cursor c = db.rawQuery(queryString, null);
        int result = 0;
        if (c != null)
        {
            c.moveToFirst();
            result = c.getInt(c.getColumnIndex("_id"));
            c.close();
        }
        return result;
    }

    public String getWordValueById(int id)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String queryString = "SELECT engWord FROM WORD WHERE _id = " + id;
        Cursor c = db.rawQuery(queryString, null);
        String result = "";
        if (c != null)
        {
            c.moveToFirst();
            result = c.getString(c.getColumnIndex("engWord"));
            c.close();
        }

        return result;
    }

    public List<Word> getWordsByTemplateName(String templateName)
    {
        int templateId = getTemplateIdByName(templateName);

        SQLiteDatabase db = getReadableDatabase();

        String queryString = "SELECT word_id, x, y, horizontal FROM TEMPLATE_WORD " +
                " WHERE template_id = " + templateId;
        Cursor c = db.rawQuery(queryString, null);

        List<Word> result = new ArrayList<>();

        while(c.moveToNext())
        {
            Word word = new Word();
            word.x = c.getInt(c.getColumnIndex("x"));
            word.y = c.getInt(c.getColumnIndex("y"));
            int wordId = c.getInt(c.getColumnIndex("word_id"));
            word.word = getWordValueById(wordId);
            word.length = word.word.length();
            word.horizontal = (c.getInt(c.getColumnIndex("horizontal")) == 1);
            result.add(word);
        }
        c.close();
        return result;
    }

    public List<String> getTemplateNames()
    {
        SQLiteDatabase db = getReadableDatabase();
        String queryString = "SELECT name FROM TEMPLATE ";
        Cursor c = db.rawQuery(queryString, null);

        List<String> result = new ArrayList<>();

        while (c.moveToNext())
        {
            String name = c.getString(c.getColumnIndex("name"));
            result.add(name);
        }
        return result;
    }

}