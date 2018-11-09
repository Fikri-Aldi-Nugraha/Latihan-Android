package com.example.hp.sharedreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences prefdata;
    EditText etnama,etemail,etnotelp,etalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = (EditText)findViewById(R.id.etnama);
        etemail = (EditText)findViewById(R.id.etemail);
        etnotelp = (EditText)findViewById(R.id.etnotelp);
        etalamat = (EditText)findViewById(R.id.etalamat);
        prefdata = getSharedPreferences("data", MODE_PRIVATE);

        Intent TerimaData = getIntent();
        String nama = TerimaData.getStringExtra("nama");
        String email = TerimaData.getStringExtra("email");
        String notelp = TerimaData.getStringExtra("notelp");
        String alamat = TerimaData.getStringExtra("alamat");

        etnama.setText(nama);
        etemail.setText(email);
        etnotelp.setText(notelp);
        etalamat.setText(alamat);
    }

    public void tampildata(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        String tampilnm = prefdata.getString("nama","kosong");
        String tampileml = prefdata.getString("email","kosong");
        String tampilno = prefdata.getString("notelp","kosong");
        String tampilal = prefdata.getString("alamat","kosong");

        intent.putExtra("nama", tampilnm);
        intent.putExtra("email", tampileml);
        intent.putExtra("notelp", tampilno);
        intent.putExtra("alamat", tampilal);
        startActivityForResult(intent,0);
    }

    public void simpan(View view){
        SharedPreferences.Editor editor = prefdata.edit();

        String isi = etnama.getText().toString();
        String isi2 = etemail.getText().toString();
        String isi3 = etnotelp.getText().toString();
        String isi4 = etalamat.getText().toString();

        editor.putString("nama",isi);
        editor.putString("email",isi2);
        editor.putString("notelp",isi3);
        editor.putString("alamat",isi4);
        editor.commit();

    }
}