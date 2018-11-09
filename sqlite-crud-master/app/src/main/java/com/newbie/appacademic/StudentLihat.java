package com.newbie.appacademic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentLihat extends AppCompatActivity {
    protected Cursor cursor;
    TextView tx1, tx2, tx3;
    Button button;
    DataHelper dataHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_lihat);
        dataHelper = new DataHelper(this);
        tx1 = findViewById(R.id.textView4);
        tx2 = findViewById(R.id.textView5);
        tx3 = findViewById(R.id.textView6);
        SQLiteDatabase db = dataHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM student WHERE name = '" +
                getIntent().getStringExtra("Data2") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            tx1.setText(cursor.getString(0).toString());
            tx2.setText(cursor.getString(1).toString());
            tx3.setText(cursor.getString(2).toString());

        }
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
