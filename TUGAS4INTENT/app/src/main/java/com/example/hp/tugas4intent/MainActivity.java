package com.example.hp.tugas4intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //deklarasi
    private Button btnSub1, btnSub2, btnSub3, btnContacts, btnDial;
    private String strIntent;
    private EditText txtIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get id button
        btnSub1 = (Button)findViewById(R.id.btn_activity_sub_1);
        btnSub2 = (Button)findViewById(R.id.btn_activity_sub_2);
        btnSub3 = (Button)findViewById(R.id.btn_activity_sub_3);
        btnContacts= (Button)findViewById(R.id.btn_activity_contacts);
        btnDial= (Button)findViewById(R.id.btn_activity_dial);

        //get id edit text
        txtIntent = (EditText)findViewById(R.id.txt_intent);

        //intent ke sub1
        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
                startActivity(intent);
            }
        });

        //intent sub2 mengirim data
        btnSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strIntent = txtIntent.getText().toString();
                Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
                intent.putExtra(Sub2Activity.KEY_DATA, strIntent);
                startActivityForResult(intent, 0);
            }
        });

        //intent ke sub3
        btnSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub3Activity.class);
                startActivity(intent);
            }
        });


        //intent contacts
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });


        //intent dial
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:081223787729"));
                startActivity(intent);
            }
        });

    }
}
