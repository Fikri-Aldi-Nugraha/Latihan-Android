package co.oriable.quis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Sukses extends AppCompatActivity {

    TextView nm,em,no,al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sukses);
        nm = findViewById(R.id.tvnama);
        em = findViewById(R.id.tvemail);
        no = findViewById(R.id.tvnotel);
        al = findViewById(R.id.tvalamat);

        Intent TerimaData = getIntent();
        String nama = TerimaData.getStringExtra("nama");
        String email = TerimaData.getStringExtra("email");
        String notel = TerimaData.getStringExtra("notel");
        String alamat = TerimaData.getStringExtra("alamat");

        nm.setText(nama);
        em.setText(email);
        no.setText(notel);
        al.setText(alamat);

    }
    public void edit(View view){
        Intent inten1 = new Intent(Sukses.this, MainActivity.class);
        String tampilnm = nm.getText().toString();
        String tampilem = em.getText().toString();
        String tampilno = no.getText().toString();
        String tampilal = al.getText().toString();
        inten1.putExtra("nama", tampilnm);
        inten1.putExtra("email", tampilem);
        inten1.putExtra("notel", tampilno);
        inten1.putExtra("alamat", tampilal);
        startActivityForResult(inten1, 0);
    }
}
