package com.example.hp.sqlite_akademik;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentCourseBuat extends AppCompatActivity {

    protected Cursor cursor;
    EditText et1, et2, et3, et4;
    DataHelper dbHelper;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_course_buat);

        dbHelper = new DataHelper(this);
        et1 = findViewById(R.id.editText7);
        et2 = findViewById(R.id.editText8);
        et3 = findViewById(R.id.editText9);
        et4 = findViewById(R.id.editText10);
        button = findViewById(R.id.btnSubmitStudentCourse);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into student_course(runningid, studentid, courseid, grade) values('" +
                        et1.getText().toString() + "','" +
                        et2.getText().toString() + "','" +
                        et3.getText().toString() + "','" +
                        et4.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                StudentCourse.sc.RefreshList();
                finish();
            }
        });
    }
}
