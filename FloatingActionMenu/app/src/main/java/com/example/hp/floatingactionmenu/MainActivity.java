package com.example.hp.floatingactionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton menu1,menu2,menu3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu1 = findViewById(R.id.subFloatingMenu1);
        menu2 = findViewById(R.id.subFloatingMenu2);
        menu3 = findViewById(R.id.subFloatingMenu3);

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Alarm Icon Clicked ", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Backup Icon Clicked ", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Settings Icon Clicked ", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
