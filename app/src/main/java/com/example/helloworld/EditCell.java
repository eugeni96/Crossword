package com.example.helloworld;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;



public class EditCell extends EditText {

    private EditCell next;
    private Word word;

    public EditCell(Context context, String style) {
        super(context);
        SetStyle(style);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(word != null)
                    word.SetNextCells();
            }
        });

        setOnLongClickListener( new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(word != null)
                    word.SetNextCells();
                return false;
            }
        });

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(getText().toString().length() == 1 && next != null)
                {
                    next.requestFocus();
                    next = null;
                }
                //clearFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {
                int iLen = s.length();
                if (iLen>0 && !Character.isLetter((s.charAt(iLen-1)))){
                    s.delete(iLen-1, iLen);
                    return;
                }
                if (iLen>1){
                    s.delete(0, 1);
                }
            }
        });
    }

    private void SetStyle(String style)
    {
        switch (style) {
            case "original":
            {
                setEms(2);
                setGravity(Gravity.CENTER_HORIZONTAL);

                ShapeDrawable border = new ShapeDrawable( new RectShape());
                border.getPaint().setStyle(Paint.Style.STROKE);
                border.getPaint().setColor(Color.BLACK);
                setBackground(border);
            }
        }
    }

    public void setNext(EditCell next) {
        this.next = next;
    }

    public EditCell getNext() {
        return next;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
