package com.example.hp.sqlite_akademik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton FAB1, FAB2, FAB3, FAB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FAB1 = findViewById(R.id.Course);
        FAB2 = findViewById(R.id.Major);
        FAB3 = findViewById(R.id.Student);
        FAB4 = findViewById(R.id.StuCour);

        FAB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Course.class);
                startActivity(i);
            }
        });

        FAB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Major.class);
                startActivity(i);
            }
        });

        FAB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Student.class);
                startActivity(i);
            }
        });

        FAB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), StudentCourse.class);
                startActivity(i);
            }
        });
    }
}
