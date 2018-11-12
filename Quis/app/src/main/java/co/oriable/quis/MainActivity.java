package co.oriable.quis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences prefdata;
    EditText edtnama,edtemail,edtno,edtalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnama = findViewById(R.id.edtnama);
        edtemail = findViewById(R.id.edtemail);
        edtno = findViewById(R.id.edtnotel);
        edtalamat = findViewById(R.id.edtalamat);
        prefdata = getSharedPreferences("data", MODE_PRIVATE);

        Intent TerimaData = getIntent();
        String nama = TerimaData.getStringExtra("nama");
        String email = TerimaData.getStringExtra("email");
        String notel = TerimaData.getStringExtra("notel");
        String alamat = TerimaData.getStringExtra("alamat");

        edtnama.setText(nama);
        edtemail.setText(email);
        edtno.setText(notel);
        edtalamat.setText(alamat);

    }

    public void tampil(View view){
        Intent intent = new Intent(MainActivity.this,Sukses.class);
        String tampilnm = prefdata.getString("nama", "kosong");
        String tampilem = prefdata.getString("email", "kosong");
        String tampilno = prefdata.getString("notel", "kosong");
        String tampilal = prefdata.getString("alamat", "kosong");
        intent.putExtra("nama", tampilnm);
        intent.putExtra("email", tampilem);
        intent.putExtra("notel", tampilno);
        intent.putExtra("alamat", tampilal);
        startActivityForResult(intent, 0);

    }
    public void  simpan(View v) {
        SharedPreferences.Editor editordata = prefdata.edit();
        String isi = edtnama.getText().toString();
        String isi1 = edtemail.getText().toString();
        String isi2 = edtno.getText().toString();
        String isi3 = edtalamat.getText().toString();

        editordata.putString("nama", isi);
        editordata.putString("email", isi1);
        editordata.putString("notel", isi2);
        editordata.putString("alamat", isi3);
        editordata.commit();
    }
}
