package com.example.hp.tugas5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Sub2Activity extends AppCompatActivity {

    private Button btnregistrasi;
    private EditText txtIntent1, txtIntent2, txtIntent3, txtIntent4, txtIntent5;
    private CheckBox cbIntent1, cbIntent2, cbIntent3;
    private RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        //get id button
        btnregistrasi = (Button)findViewById(R.id.btn4_formregistrasi);

        //get id edit text
        txtIntent1 = (EditText)findViewById(R.id.et_nama_formregistrasi);
        txtIntent2 = (EditText)findViewById(R.id.et_alamat_formregistrasi);
        txtIntent3 = (EditText)findViewById(R.id.et_notlp_formregistrasi);
        txtIntent4 = (EditText)findViewById(R.id.et_email_formregistrasi);
        txtIntent5 = (EditText)findViewById(R.id.et_password_formregistrasi);

        //get id checkbox
        cbIntent1 = (CheckBox)findViewById(R.id.cb_1);
        cbIntent2 = (CheckBox)findViewById(R.id.cb_2);
        cbIntent3 = (CheckBox)findViewById(R.id.cb_3);

        //get id radiogrup
        rg1 = (RadioGroup)findViewById(R.id.rg_1);

        //intent sub2 mengirim data
       btnregistrasi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Sub2Activity.this, Sub4Activity.class);
               intent.putExtra("nama", txtIntent1.getText().toString());
               intent.putExtra("alamat", txtIntent2.getText().toString());
               intent.putExtra("no_tlp", txtIntent3.getText().toString());
               intent.putExtra("email", txtIntent4.getText().toString());
               intent.putExtra("password", txtIntent5.getText().toString());

               int id = rg1.getCheckedRadioButtonId();
               RadioButton radioButton = findViewById(id);
               intent.putExtra("jk", radioButton.getText().toString());

               String hobby = "";
               if(cbIntent1.isChecked()) {
                   hobby+="," + cbIntent1.getText().toString();
               }
               if(cbIntent2.isChecked()) {
                   hobby+=", " + cbIntent2.getText().toString();
               }
               if(cbIntent3.isChecked()) {
                   hobby+=", " + cbIntent3.getText().toString();
               }
               String hobi = hobby.replaceFirst(",", "");
               intent.putExtra("hobby", hobi);

               startActivityForResult(intent, 0);
           }
       });
    }
}
