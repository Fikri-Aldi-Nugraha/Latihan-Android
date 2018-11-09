package com.example.hp.sqlite_akademik;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentCourseUbah extends AppCompatActivity {

    protected Cursor cursor;
    EditText et1, et2, et3, et4;
    DataHelper dbHelper;
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_course_ubah);

        dbHelper = new DataHelper(this);
        et1 = findViewById(R.id.editText7);
        et2 = findViewById(R.id.editText8);
        et3 = findViewById(R.id.editText9);
        et4 = findViewById(R.id.editText10);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM student_course WHERE studentid = '" +
                getIntent().getStringExtra("name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            et1.setText(cursor.getString(0).toString());
            et2.setText(cursor.getString(1).toString());
            et3.setText(cursor.getString(2).toString());
            et4.setText(cursor.getString(3).toString());
        }
        button = (Button) findViewById(R.id.btnupdatecs);
        button2 = (Button) findViewById(R.id.btnbackcs);
        // daftarkan even onClick pada btnSimpan
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update student_course set studentid='"+
                        et2.getText().toString() + "', courseid='" +
                        et3.getText().toString() + "', grade='" +
                        et4.getText().toString() + "' where runningid='" +
                        et1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                StudentCourse.sc.RefreshList();
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
