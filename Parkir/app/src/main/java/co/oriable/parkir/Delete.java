package co.oriable.parkir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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

public class Delete extends AppCompatActivity {
    Spinner spinner;
    String get_kendaraan = "http://192.168.43.219:3000/api/status/";
    String del_kendaraan = "http://192.168.43.219:3000/api/kendaraan/?noken=";
    ArrayList<String> no_kendaraan;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        no_kendaraan = new ArrayList<>();
        spinner = findViewById(R.id.Noken);
        requestQueue = Volley.newRequestQueue(this);
        ambilnoken();

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
                            spinner.setAdapter(new ArrayAdapter<String>(Delete.this, android.R.layout.simple_selectable_list_item, no_kendaraan));
                        } catch (JSONException e) {
                            // If there is an error then output this to the logs.
                            Log.e("Volley", "Invalid JSON Object.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Delete.this, "Error!!", Toast.LENGTH_SHORT).show();
                        Log.e("Volley", error.toString());
                    }
                });

        requestQueue.add(stringRequest);
    }

    public void DeleteKendaraan(View view){
        String noken = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();

        StringRequest DeleteRequest = new StringRequest(Request.Method.DELETE, del_kendaraan+noken,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            Log.e("Volley",jsonObj.toString());
                            String codes = jsonObj.getString("code");
                            Log.e("Code",codes);
                            if(codes.equals("200")){
                                Toast.makeText(Delete.this, "Sukses Delete", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Delete.this, Home.class);
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
                        Toast.makeText(Delete.this, "Error while calling REST API", Toast.LENGTH_SHORT).show();
                        Log.e("Volley", error.toString());
                    }
                });

        requestQueue.add(DeleteRequest);
    }
}
