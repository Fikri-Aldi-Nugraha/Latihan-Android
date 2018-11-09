package com.example.hp.sessionmanagersharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.SharedPreferences;
import android.view.View;
import android.content.Context;

public class home extends AppCompatActivity {
Button btlogout = null;
Button btclose = null;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btlogout=(Button)findViewById(R.id.btnlogout);
        btclose=(Button)findViewById(R.id.btnclose);
    }

    public  void logout(View view){
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void close(View view){
        finish();
    }
}
