package com.example.helloworld;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.view.Gravity;
import android.widget.EditText;



public class EditCell extends EditText {

    public EditCell(Context context, String style) {
        super(context);
        SetStyle(style);
    }

    private void SetStyle(String style)
    {
        switch (style) {
            case "original":
            {
                setMaxLines(1);
                setEms(2);
                setBackground(null);
                setGravity(Gravity.CENTER_HORIZONTAL);
                InputFilter[] fArray = new InputFilter[1];
                fArray[0] = new InputFilter.LengthFilter(1);
                setFilters(fArray);
            }
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        getLocalVisibleRect(rect);
        canvas.drawRect(rect, paint);
    }
}
