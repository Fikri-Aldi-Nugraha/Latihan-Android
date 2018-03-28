package com.example.hp.tugas5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sub4Activity extends AppCompatActivity {

    //deklarasi
    private TextView tvdata1, tvdata2, tvdata3, tvdata4, tvdata5, tvdata6, tvdata7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4);

        //menerima data
       tvdata1 = (TextView)findViewById(R.id.tv_data1);
       tvdata2 = (TextView)findViewById(R.id.tv_data2);
       tvdata3 = (TextView)findViewById(R.id.tv_data3);
       tvdata4 = (TextView)findViewById(R.id.tv_data4);
       tvdata5 = (TextView)findViewById(R.id.tv_data5);
       tvdata6 = (TextView)findViewById(R.id.tv_data6);
       tvdata7 = (TextView)findViewById(R.id.tv_data7);

        Intent i = getIntent();
        tvdata1.setText(i.getStringExtra("nama"));
        tvdata2.setText(i.getStringExtra("alamat"));
        tvdata3.setText(i.getStringExtra("no_tlp"));
        tvdata4.setText(i.getStringExtra("email"));
        tvdata5.setText(i.getStringExtra("password"));
        tvdata6.setText(i.getStringExtra("jk"));
        tvdata7.setText(i.getStringExtra("hobby"));
    }
}
