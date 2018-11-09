package com.newbie.appacademic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MajorLihat extends AppCompatActivity {

    protected Cursor cursor;
    TextView tx1, tx2;
    Button button;
    DataHelper dataHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_lihat);
        dataHelper = new DataHelper(this);
        tx1 = findViewById(R.id.textView2);
        tx2 = findViewById(R.id.textView3);
        SQLiteDatabase db = dataHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM major WHERE name = '" +
                getIntent().getStringExtra("name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            tx1.setText(cursor.getString(0).toString());
            tx2.setText(cursor.getString(1).toString());

        }
        button = findViewById(R.id.btnlihatmajopr);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
