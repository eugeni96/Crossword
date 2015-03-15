package com.example.helloworld;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout1);

        HorizontalScrollView layout = (HorizontalScrollView) findViewById(R.id.horizontalView);

        TableLayout table = new TableLayout(this);

        for (int i = 0; i < 20; i++) {

            TableRow row = new TableRow(this);

            for (int j = 0; j < 20; j++) {

                EditText cell = new EditText(this) {
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
                };
                cell.setMaxLines(1);
                cell.setEms(2);
                InputFilter[] fArray = new InputFilter[1];
                fArray[0] = new InputFilter.LengthFilter(1);
                cell.setFilters(fArray);
                cell.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }
                );
                row.addView(cell);

            }

            table.addView(row);
        }

        layout.addView(table);

    }
}