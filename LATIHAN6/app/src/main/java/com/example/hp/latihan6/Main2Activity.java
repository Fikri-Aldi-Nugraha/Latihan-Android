package com.example.hp.latihan6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvPanjang, tvLebar, tvHasil;
    //String sgetPanjang, sgetLebar, sluaspersegipanjang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvPanjang = (TextView)findViewById(R.id.tv_panjang);
        tvLebar   = (TextView)findViewById(R.id.tv_lebar);
        tvHasil   = (TextView)findViewById(R.id.tv_hasil2);

        Intent Terima = getIntent();
        String Panjang = Terima.getStringExtra("panjang");
        String Lebar   = Terima.getStringExtra("lebar");

        int ipanjang = Integer.parseInt(Panjang);
        int ilebar = Integer.parseInt(Lebar);

        int hasil = ipanjang*ilebar;
        String output = String.valueOf(hasil);

        tvPanjang.setText("Panjang: "+Panjang);
        tvLebar.setText("Lebar: "+Lebar);
        tvHasil.setText("Hasil: "+output);


        //terima versi bapak

        //Intent terimaData = getIntent();
        //sgetPanjang       = terimaData.getExtras().getString("sendPanjang");
        //sgetLebar       = terimaData.getExtras().getString("sendLebar");

        //int iPanjang, iLebar, iluaspersegipanjang;
        //iPanjang = Integer.parseInt(sgetPanjang);
        //iLebar   = Integer.parseInt(sgetLebar);
        //iluaspersegipanjang =  iPanjang*iLebar;

        //sLuas = String.valueOf(iluaspersegipanjang);
        //tvHasil.setText(sluaspersegipanjang.toString());
    }
}

