package com.newbie.appacademic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentUpdate extends AppCompatActivity {

    protected Cursor cursor;
    EditText et1, et2, et3;
    DataHelper dbHelper;
    Button button, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_update);

        dbHelper = new DataHelper(this);
        et1 = findViewById(R.id.editText4);
        et2 = findViewById(R.id.editText5);
        et3 = findViewById(R.id.editText6);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM student WHERE name = '" +
                getIntent().getStringExtra("name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            et1.setText(cursor.getString(0).toString());
            et2.setText(cursor.getString(1).toString());
            et3.setText(cursor.getString(2).toString());
        }
        button = (Button) findViewById(R.id.btnupdatesc);
        button2 = (Button) findViewById(R.id.btnbacksc);
        // daftarkan even onClick pada btnSimpan
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update student set name='"+
                        et2.getText().toString() + "', majorid='" +
                        et3.getText().toString() + "' where studentid='" +
                        et1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Student.ma.RefreshList();
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
