package co.oriable.parkir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Home extends AppCompatActivity {
    ListView listView;
    private List<Kendaraan> kendaraanitemList;
    String get_kendaraan = "http://192.168.43.219:3000/api/kendaraan/all";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView = findViewById(R.id.listView);
        requestQueue = Volley.newRequestQueue(this);
        kendaraanitemList = new ArrayList<>();
        load();
    }

    private void load() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, get_kendaraan,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray kendArray = obj.getJSONArray("result");
                            Log.e("Volley", response);
                            for (int i = 0; i < kendArray.length(); i++) {

                                JSONObject kendaraan = kendArray.getJSONObject(i);
                                String stats;
                                if (kendaraan.getString("status").equals("1")) {
                                    stats = "Masuk";
                                } else {
                                    stats = "Keluar";
                                }
                                Kendaraan kendaraanitem = new Kendaraan(
                                        "Nomer Kendaraan: " + kendaraan.getString("no_kendaraan"),
                                        "Nama Pemilik: " + kendaraan.getString("nama_pemilik"),
                                        "Jenis Kendaraan: " + kendaraan.getString("jenis_kendaraan"),
                                        "Status: " + stats
                                );

                                kendaraanitemList.add(kendaraanitem);
                            }

                            ListViewAdapter adapter = new ListViewAdapter(kendaraanitemList, getApplicationContext());

                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            // If there is an error then output this to the logs.
                            Log.e("Volley", "Invalid JSON Object.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Home.this, "Error!!", Toast.LENGTH_LONG).show();
                        Log.e("Volley", error.toString());
                    }
                });

        requestQueue.add(stringRequest);
    }

    public void input(View view) {
        Intent intent = new Intent(Home.this, Input.class);
        startActivity(intent);
    }

    public void Update(View view) {
        Intent intent = new Intent(Home.this, Update.class);
        startActivity(intent);
    }

    public void Delete(View view) {
        Intent intent = new Intent(Home.this, Delete.class);
        startActivity(intent);
    }


}
