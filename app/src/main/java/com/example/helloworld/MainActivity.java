package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
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

        HorizontalScrollView layout = (HorizontalScrollView) findViewById(R.id.horizontalView);

        TableLayout table = new TableLayout(this);

        for (int i = 0; i < 20; i++) {

            TableRow row = new TableRow(this);

            for (int j = 0; j < 20; j++) {

                EditText cell = new EditCell(this, "original");
                row.addView(cell);

            }

            table.addView(row);
        }

        layout.addView(table);

    }
}