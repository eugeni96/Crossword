package com.example.helloworld;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout1);

        HorizontalScrollView layout = (HorizontalScrollView) findViewById(R.id.horizontalView);

        TableLayout table = new TableLayout(this);

        for (int i = 0; i < 100; i++) {

            TableRow row = new TableRow(this);

            for (int j = 0; j < 100; j++) {

                TextView cell = new TextView(this) {
                    @Override
                    protected void onDraw(Canvas canvas) {
                        super.onDraw(canvas);
                        Rect rect = new Rect();
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.STROKE);
                        paint.setColor(Color.WHITE);
                        paint.setStrokeWidth(2);
                        getLocalVisibleRect(rect);
                        canvas.drawRect(rect, paint);
                    }

                };
                cell.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                       public void onClick(View v) {
                           Toast.makeText(getApplicationContext(), ((TextView) v).getText() + "!!!", Toast.LENGTH_SHORT).show();
                           ((TextView)v).setText("0");
                           }
                       }
                    );
                cell.setText(i + ", " + j);
                cell.setPadding(6, 4, 6, 4);
                row.addView(cell);

            }

            table.addView(row);
        }

        layout.addView(table);

    }
}