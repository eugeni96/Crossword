package com.example.helloworld.DataBase;

import android.content.ContentValues;
import android.util.Log;


public class Word {
    private long ID;
    private String RusWord;
    private String EngWord;
    private String RusQuestion;
    private String EngQuestion;

    public Word(String RusWord) {
        this.RusWord = RusWord;
    }

    public Word(long id, String RusWord, String EngWord, String RusQuestion, String EngQuestion) {
        this.ID = id;
        this.RusWord = RusWord;
        this.EngWord = EngWord;
        this.RusQuestion = RusQuestion;
        this.EngQuestion = EngQuestion;
    }

    public long getID() {
        return ID;
    }

    public void setRusWord(String rusWord) {
        this.RusWord = rusWord;
    }

    public void setEngWord(String engWord) {
        this.EngWord = engWord;
    }

    public void setRusQuestion(String rusQuestion) {
        this.RusQuestion = rusQuestion;
    }

    public void setEngQuestion(String engQuestion) {
        this.EngQuestion = engQuestion;
    }

    public String getRusWord() {
        return RusWord;
    }

    public String getEngWord() {
        return EngWord;
    }

    public String getRusQuestion() {
        return RusQuestion;
    }

    public String getEngQuestion() {
        return EngQuestion;
    }

    @Override
    public String toString() {
        return RusWord;
    }

    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,ID);
        cv.put(COLUMN_RUSWORD, RusWord);
        cv.put(COLUMN_ENGWORD, EngWord);
        cv.put(COLUMN_RUSQUESTION, RusQuestion);
        cv.put(COLUMN_ENGQUESTION, EngQuestion);
        return cv;
    }

    public Word(ContentValues cv) {

        Log.d("", cv.toString());
        ID = cv.getAsLong(COLUMN_ID);
        RusWord = cv.getAsString(COLUMN_RUSWORD);
        EngWord = cv.getAsString(COLUMN_ENGWORD);
        RusQuestion = cv.getAsString(COLUMN_RUSQUESTION);
        EngQuestion = cv.getAsString(COLUMN_ENGQUESTION);

    }
}
