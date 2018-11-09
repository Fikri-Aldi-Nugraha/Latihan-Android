package com.example.hp.sqlite_akademik;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MajorBuat extends AppCompatActivity {

    protected Cursor cursor;
    EditText et1, et2;
    DataHelper dbHelper;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_buat);

        dbHelper = new DataHelper(this);
        et1 = findViewById(R.id.editText2);
        et2 = findViewById(R.id.editText3);
        button = findViewById(R.id.btnSubmitMajor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into major(majorid, name) values('" +
                        et1.getText().toString() + "','" +
                        et2.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Major.mj.RefreshList();
                finish();
            }
        });
    }
}
