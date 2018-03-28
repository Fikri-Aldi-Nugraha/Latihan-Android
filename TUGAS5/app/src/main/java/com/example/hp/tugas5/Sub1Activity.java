package com.example.hp.tugas5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sub1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        final EditText username = findViewById(R.id.et_username_formlogin);
        final EditText password = findViewById(R.id.et_password_formlogin);

        Button btnlogin = findViewById(R.id.btn3_formlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un = username.getText().toString();
                String pw = password.getText().toString();
                if(un.equals("admin")&& pw.equals("123")){
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Sub1Activity.this, Sub3Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
