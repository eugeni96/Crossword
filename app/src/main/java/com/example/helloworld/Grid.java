package com.example.helloworld;

import android.app.Activity;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.List;

public class Grid {

    public static HorizontalScrollView grid;
    public static int cols;
    public static int rows;

    public static TableLayout CreateGrid(Activity activity, int cols, int rows)
    {
        TableLayout table = new TableLayout(activity);

        for (int i = 0; i < rows; i++) {
            TableRow row = new TableRow(activity);
            for (int j = 0; j < cols; j++) {
                EditText cell = new EditCell(activity, "block");
                cell.setId(i*cols+j);
                row.addView(cell);
            }
            table.addView(row);
        }
        grid.addView(table);
        return table;
    }

    public static List<Word> LoadTemplate(Activity activity, String templateName)
    {
        DBHelper helper = new DBHelper(activity);
        int[] size = helper.getTemplateSize("Easy breezy");
        rows = size[0];
        cols = size[1];

        Grid.CreateGrid(activity, cols, rows);

        List<Word> words = helper.getWordsByTemplateName(templateName);
        for (Word word: words)
        {
            word.connectCells(activity, cols, rows);
        }
        return words;
    }
}
