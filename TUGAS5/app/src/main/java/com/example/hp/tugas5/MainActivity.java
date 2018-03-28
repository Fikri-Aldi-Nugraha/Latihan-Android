package com.example.hp.tugas5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //deklarasi
    private Button btn1, btn2;
    private String strIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get id button
        btn1 = (Button)findViewById(R.id.btn1_menu_utama);
        btn2 = (Button)findViewById(R.id.btn2_menu_utama);

        //intent ke sub1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
                startActivity(intent);
            }
        });

        //intent ke sub2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
                startActivity(intent);
            }
        });

    }
}
