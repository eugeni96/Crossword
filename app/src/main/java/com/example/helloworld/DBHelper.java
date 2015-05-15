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
            String WORD = "word";
            String MASK = "mask";
        }

        public interface WordColumns {
            String COLUMN_WORD = "word";
            String COLUMN_QUESTION = "question";
            String COLUMN_ENGWORD = "engWord";


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
            SQLiteDatabase db = getReadableDatabase();
            SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
            qb.setTables(TABLES.WORD);
            Cursor c = qb.query(db, null, null, null, null, null, null);
            return c;
        }
    }
