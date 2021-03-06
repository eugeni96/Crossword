package com.example.helloworld;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word {

    List<EditCell>  letterList;
    String          word;
    int             length;
    boolean         horizontal;

    Word()
    {
        letterList = new ArrayList<>();
        word = "";
    }

    public Word(EditCell... cells)
    {
        this();
        Collections.addAll(letterList, cells);
        length = letterList.size();
    }

    public Word(List<EditCell> cells)
    {
        this();
        letterList = cells;
        length = letterList.size();
        letterList.get(0).setWord(this);
    }

    public Word(Activity activity, int firstCellId, int length, boolean horizontal) {
        this();
        this.length = length;
        this.horizontal = horizontal;
        EditCell firstCell = (EditCell) activity.findViewById(firstCellId);
        letterList.add(firstCell);
    }

    public void SetNextCells()
    {
        for (int i = 0; i < length - 1; i++) {
            letterList.get(i).setNext(letterList.get(i+1));
        }
    }
}
