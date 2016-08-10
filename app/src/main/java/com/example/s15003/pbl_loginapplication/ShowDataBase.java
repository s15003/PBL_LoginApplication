package com.example.s15003.pbl_loginapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShowDataBase extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_database);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        MyOpenHelper helper = new MyOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query("person", new String[] { "Id", "Pass" }, null,
                        null, null, null, null);

        boolean mov = c.moveToFirst();
        while (mov) {
            TextView textView = new TextView(this);
            textView.setText(String.format("ID:%s  Pass:%d", c.getString(0),
                    c.getInt(0)));
            mov = c.moveToNext();
            layout.addView(textView);
        }
        c.close();
        db.close();
    }

}
