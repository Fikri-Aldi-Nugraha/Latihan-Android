package co.oriable.parkir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Update extends AppCompatActivity {
    TextView tv;
    Spinner spinner;
    String get_kendaraan = "http://192.168.43.219:3000/api/status/";
    String get_statuscari = "http://192.168.43.219:3000/api/status/cari/?noken=";
    String put_status = "http://192.168.43.219:3000/api/status/";
    ArrayList<String> no_kendaraan;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        no_kendaraan = new ArrayList<>();
        tv = findViewById(R.id.status);
        spinner = findViewById(R.id.Noken);
        requestQueue = Volley.newRequestQueue(this);
        ambilnoken();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String noken = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                getStatusCari(noken);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // DO Nothing here
            }
        });

    }

    private void ambilnoken() {
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
                                no_kendaraan.add(kendaraan.getString("no_kendaraan"));
                            }
                            spinner.setAdapter(new ArrayAdapter<String>(Update.this, android.R.layout.simple_selectable_list_item, no_kendaraan));
                        } catch (JSONException e) {
                            // If there is an error then output this to the logs.
                            Log.e("Volley", "Invalid JSON Object.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Update.this, "Error!!", Toast.LENGTH_SHORT).show();
                        Log.e("Volley", error.toString());
                    }
                });

        requestQueue.add(stringRequest);
    }

    public void getStatusCari(String noken) {
        tv.setText("");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, get_statuscari + noken,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray kendArray = obj.getJSONArray("result");
                            for (int i = 0; i < kendArray.length(); i++) {
                                JSONObject kendaraan = kendArray.getJSONObject(i);
                                String status = kendaraan.getString("status");
                                Log.e("Status", status);
                                if (status.equals("1")) {
                                    tv.append("Status: Masuk");
                                } else {
                                    tv.append("Status: Keluar");
                                }
                            }
                        } catch (JSONException e) {
                            // If there is an error then output this to the logs.
                            Log.e("Volley", "Invalid JSON Object.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Update.this, "Error!!!", Toast.LENGTH_SHORT).show();
                        Log.e("Volley", error.toString());
                    }
                });
        requestQueue.add(stringRequest);
    }

    public void Masuk(View view) {
        PutStatus("1");
    }

    public void Keluar(View view) {
        PutStatus("0");
    }


    public void PutStatus(String Status) {
        final String noken = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
        final String status = Status;
        StringRequest putRequest = new StringRequest(Request.Method.PUT, put_status,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            Log.e("Volley",jsonObj.toString());
                            String codes = jsonObj.getString("code");
                            Log.e("Code",codes);
                            if(codes.equals("200")){
                                Toast.makeText(Update.this, "Sukses Merubah", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Update.this, Home.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e){
                            // If there is an error then output this to the logs.
                            Log.e("Volley", "Invalid JSON Object.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Update.this, "Error while calling REST API", Toast.LENGTH_SHORT).show();
                        Log.e("Volley", error.toString());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()  {
                HashMap<String, String> params = new HashMap<>();
                params.put("noken", noken);
                params.put("status", status);
                return params;
            }

        };

        requestQueue.add(putRequest);
    }
}
