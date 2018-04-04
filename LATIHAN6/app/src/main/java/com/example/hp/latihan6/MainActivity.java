package com.example.hp.latihan6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextPanjang, editTextLebar;
    //TextView textViewHasil;
    Button   buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPanjang = (EditText)findViewById(R.id.et_panjang);
        editTextLebar   = (EditText)findViewById(R.id.et_lebar);
        //textViewHasil   = (TextView)findViewById(R.id.tv_hasil);

        buttonHitung    = (Button)findViewById(R.id.btn_hitung);


        //buttonHitung.setOnClickListener(new View.OnClickListener() {
        // @Override
        //public void onClick(View view) {
        //String sPanjang, sLebar, sLuas;

        //sPanjang = editTextPanjang.getText().toString();
        //sLebar   = editTextLebar.getText().toString();

        //int iPanjang, iLebar, iluaspersegipanjang;
        //iPanjang = Integer.parseInt(sPanjang);
        //iLebar   = Integer.parseInt(sLebar);
        //iluaspersegipanjang =  iPanjang*iLebar;

        //sLuas = String.valueOf(iluaspersegipanjang);
        //textViewHasil.setText(sLuas.toString());
        //}
        //});


        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextPanjang.length()==0 && editTextLebar.length()==0) {
                    Toast.makeText(getApplicationContext(), "Panjang dan Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (editTextPanjang.length()==0){
                    Toast.makeText(getApplicationContext(), "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (editTextLebar.length()==0) {
                    Toast.makeText(getApplicationContext(), "Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("panjang", editTextPanjang.getText().toString());
                    intent.putExtra("lebar", editTextLebar.getText().toString());
                    startActivityForResult(intent, 0);
                }
            }
        });


        //intent versi bapak

        //buttonHitung.setOnClickListener(new View.OnClickListener() {
        // @Override
        //public void onClick(View view) {
        //String sPanjang, sLebar, sLuas;

        //sPanjang = editTextPanjang.getText().toString();
        //sLebar   = editTextLebar.getText().toString();

        //Intent kirimData = new Intent(MainActivity.this, Main2Activity.class);
        //kirimData.putExtra("sendPanjang", sPanjang);
        //kirimData.putExtra("sendLebar", sLebar);
        //startActivity(kirimData);
        //}
        //});


    }
}
