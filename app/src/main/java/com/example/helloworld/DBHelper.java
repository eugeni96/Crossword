package com.example.helloworld;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHelper extends SQLiteAssetHelper {

        /*public static final String TABLE_WORDS = "words";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_WORD = "russWord";
        public static final String COLUMN_QUESTION = "question"; */

    private static final String TAG = SQLiteAssetHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "crossword.sqlite";
    private static final int DATABASE_VERSION = 1;

    public interface TABLES{
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

      /*  @Override
        public void onCreate(SQLiteDatabase database) {
            database.execSQL(DATABASE_CREATE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(DBHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to "
                            + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS ");
            onCreate(db);
        } */

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
        Cursor c = db.rawQuery(queryString,null);
        return c;
    }

    public Cursor getSizeColumn(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String queryString =
                "SELECT max(length) FROM TEMPLATE " +
                        "WHERE horizontal = 0";
        Cursor c = db.rawQuery(queryString,null);
        return c;
    }
    public int[] getTemplateSize()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String queryString = "SELECT x, y FROM TEMPLATE WHERE name = \"Easy breezy\" ";

        Cursor c = db.rawQuery(queryString,null);

        int[] size = new int[2];

        if(c != null)
        {
            c.moveToFirst();
            size[0] = c.getInt(c.getColumnIndex("x"));
            size[1] = c.getInt(c.getColumnIndex("y"));
        }

        return size;
    }

}