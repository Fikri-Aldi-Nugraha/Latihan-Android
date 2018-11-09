package com.example.hp.sharedreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView nm, eml, no, almt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nm = (TextView)findViewById(R.id.tvnama);
        eml = (TextView)findViewById(R.id.tvemail);
        no = (TextView)findViewById(R.id.tvnotelp);
        almt = (TextView)findViewById(R.id.tvalamat);

        Intent TerimaData = getIntent();
        String nama = TerimaData.getStringExtra("nama");
        String email = TerimaData.getStringExtra("email");
        String notelp = TerimaData.getStringExtra("notelp");
        String alamat = TerimaData.getStringExtra("alamat");

        nm.setText(nama);
        eml.setText(email);
        no.setText(notelp);
        almt.setText(alamat);
    }

    public void edit(View view){
        Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
        String tampilnm = nm.getText().toString();
        String tampileml = eml.getText().toString();
        String tampilno = no.getText().toString();
        String tampilal = almt.getText().toString();
        intent1.putExtra("nama", tampilnm);
        intent1.putExtra("email", tampileml);
        intent1.putExtra("notelp", tampilno);
        intent1.putExtra("alamat", tampilal);
        startActivityForResult(intent1, 0);
    }
}
