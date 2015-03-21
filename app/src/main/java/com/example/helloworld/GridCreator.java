package com.example.helloworld;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GridCreator {

    public static TableLayout CreateGrid(Activity activity, int rows, int cols)
    {
        TableLayout table = new TableLayout(activity);

        for (int i = 0; i < rows; i++) {

            TableRow row = new TableRow(activity);

            for (int j = 0; j < cols; j++) {

                EditText cell = new EditCell(activity, "original");
                row.addView(cell);

            }
            table.addView(row);
        }

        return table;
    }

}
