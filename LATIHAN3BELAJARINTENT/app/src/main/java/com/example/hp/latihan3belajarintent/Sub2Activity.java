package com.example.hp.latihan3belajarintent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Sub2Activity extends Activity {

    //deklarasi
    public static String KEY_DATA = "data";
    private String receivedData = "null";
    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        //menerima data
        txtData = (TextView)findViewById(R.id.txt_data);
        receivedData = getIntent().getStringExtra(KEY_DATA);
        txtData.setText(receivedData);
    }
}
