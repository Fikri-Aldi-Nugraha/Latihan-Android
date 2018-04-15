package com.example.hp.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner sp_motor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_motor = (Spinner) findViewById(R.id.spinner);
        sp_motor.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


        public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

            String firstItem = String.valueOf(sp_motor.getSelectedItem());

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (firstItem.equals(String.valueOf(sp_motor.getSelectedItem()))) {
                    // ToDo when first item is selected
                } else {
                    Toast.makeText(parent.getContext(),
                            "Kamu memilih : " + parent.getItemAtPosition(pos).toString(),
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg) {

            }


    }
}
