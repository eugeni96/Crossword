package com.example.helloworld;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.InputFilter;
import android.view.Gravity;
import android.widget.EditText;



public class EditCell extends EditText {

    private int row;
    private int col;

    public EditCell(Context context, String style, int row, int col) {
        super(context);
        SetStyle(style);
        setRow(row);
        setCol(col);
    }

    private void SetStyle(String style)
    {
        switch (style) {
            case "original":
            {
                setMaxLines(1);
                setEms(2);
                setGravity(Gravity.CENTER_HORIZONTAL);
                InputFilter[] fArray = new InputFilter[1];
                fArray[0] = new InputFilter.LengthFilter(1);
                setFilters(fArray);

                ShapeDrawable border = new ShapeDrawable( new RectShape());
                border.getPaint().setStyle(Paint.Style.STROKE);
                border.getPaint().setColor(Color.BLACK);
                setBackground(border);
            }
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
