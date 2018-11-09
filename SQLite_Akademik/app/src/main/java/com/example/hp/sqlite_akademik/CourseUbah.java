package com.example.hp.sqlite_akademik;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CourseUbah extends AppCompatActivity {

    protected Cursor cursor;
    EditText et1, et2;
    DataHelper dbHelper;
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_ubah);

        dbHelper = new DataHelper(this);
        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM course WHERE name = '" +
                getIntent().getStringExtra("name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            et1.setText(cursor.getString(0).toString());
            et2.setText(cursor.getString(1).toString());
        }
        button = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update course set name='"+
                        et2.getText().toString() + "' where courseid='" +
                        et1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Course.cs.RefreshList();
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
