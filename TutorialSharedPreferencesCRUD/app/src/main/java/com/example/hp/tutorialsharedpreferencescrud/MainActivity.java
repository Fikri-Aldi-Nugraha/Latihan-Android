package com.example.hp.tutorialsharedpreferencescrud;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public SharedPreferences prefdata;
TextView tvtampil;
EditText etnamamhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefdata = getSharedPreferences("datamahasiswa", MODE_PRIVATE);
    }

    public void tampildata(View view){

        tvtampil = (TextView)findViewById(R.id.tvdata);

        SharedPreferences.Editor editor = prefdata.edit();
        editor.putString("nama","Coba Shared Preferences");
        editor.commit();


        String tampil_nama = prefdata.getString("namamhs", "Data Tidak Ditemukan");
        tvtampil.setText(tampil_nama);
    }

    public void simpan(View view){
        etnamamhs = (EditText)findViewById(R.id.etnama);
        String nama = etnamamhs.getText().toString();
        SharedPreferences.Editor editor = prefdata.edit();
        editor.putString("namamhs", nama);
        editor.commit();
    }

    public void hapus(View view){

        prefdata.edit().remove("namamhs").commit();
    }
}
