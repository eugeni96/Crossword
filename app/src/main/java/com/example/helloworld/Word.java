package com.example.helloworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word {

    List<EditCell>  letterList;
    String          word;
    int             startRow;
    int             startCol;
    int             length;

    Word()
    {
        letterList = new ArrayList<>();
        word = "";
    }

    Word(EditCell... cells)
    {
        Collections.addAll(letterList, cells);
        length = letterList.size();
        startRow = letterList.get(1).getRow();
        startCol = letterList.get(1).getCol();
    }

    Word(int startRow, int startCol, int length) {
        this.startCol = startCol;
        this.startRow = startRow;
        this.length = length;
    }
}
