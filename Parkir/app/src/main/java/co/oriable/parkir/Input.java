package co.oriable.parkir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Input extends AppCompatActivity {
    EditText no_ken,name;
    Spinner jns_ken;
    String post_kendaraan = "http://192.168.43.219:3000/api/kendaraan";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        no_ken = findViewById(R.id.no_kendaraan);
        name = findViewById(R.id.name);
        jns_ken = findViewById(R.id.jenis);
        requestQueue = Volley.newRequestQueue(this);

    }

    public void Postkendaraan(View view){
        final String noken = no_ken.getText().toString();
        final String nama = name.getText().toString();
        final String jenis = jns_ken.getSelectedItem().toString();
        StringRequest jsonObjReq = new StringRequest(Request.Method.POST, post_kendaraan,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            Log.e("Volley",jsonObj.toString());
                            String codes = jsonObj.getString("code");
                            Log.e("Code",codes);
                            if(codes.equals("200")){
                                JSONObject status = jsonObj.getJSONObject("status");
                                Toast.makeText(Input.this, "Sukses Input", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Input.this, Home.class);
                                startActivity(intent);
                            }else if(codes.equals("400")){
                                JSONObject error = jsonObj.getJSONObject("failed");
                                String msg = error.getString("sqlMessage");
                                Log.e("Error",msg);
                                Toast.makeText(Input.this, msg, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(Input.this, "Error while calling REST API", Toast.LENGTH_SHORT).show();
                        Log.e("Volley", error.toString());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()  {
                HashMap<String, String> params = new HashMap<>();
                params.put("noken", noken);
                params.put("nama", nama);
                params.put("jenis", jenis);
                return params;
            }

        };

        requestQueue.add(jsonObjReq);
    }

}
