package com.newbie.appacademic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MajorUpdate extends AppCompatActivity {

    protected Cursor cursor;
    EditText et1, et2;
    DataHelper dbHelper;
    Button button, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_update);

        dbHelper = new DataHelper(this);
        et1 = findViewById(R.id.editText2);
        et2 = findViewById(R.id.editText3);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM major WHERE name = '" +
                getIntent().getStringExtra("name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            et1.setText(cursor.getString(0).toString());
            et2.setText(cursor.getString(1).toString());
        }
        button = (Button) findViewById(R.id.btnupdatemajor);
        button2 = (Button) findViewById(R.id.btnbackmajor);
        // daftarkan even onClick pada btnSimpan
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update major set name='"+
                        et2.getText().toString() + "' where majorid='" +
                        et1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Major.ma.RefreshList();
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
