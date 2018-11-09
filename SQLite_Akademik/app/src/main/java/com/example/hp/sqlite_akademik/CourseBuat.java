package com.example.hp.sqlite_akademik;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CourseBuat extends AppCompatActivity {

    protected Cursor cursor;
    EditText et1, et2;
    DataHelper dbHelper;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_buat);

        dbHelper = new DataHelper(this);
        et1 = findViewById(R.id.etID);
        et2 = findViewById(R.id.etNama);
        button = findViewById(R.id.btnSubmitCourse);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into course(courseid, name) values('" +
                        et1.getText().toString() + "','" +
                        et2.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Course.cs.RefreshList();
                finish();
            }
        });
    }
}
