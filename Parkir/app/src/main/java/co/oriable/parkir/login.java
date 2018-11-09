package co.oriable.parkir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class login extends AppCompatActivity {
    EditText email, pass;
    RequestQueue requestQueue;
    String cek_login = "http://192.168.43.219:3000/api/user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        requestQueue = Volley.newRequestQueue(this);
    }

    private void result(String code, String status) {
        if (code.equals("200")) {
            Toast.makeText(login.this, status, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(login.this, Home.class);
            startActivity(intent);
        } else if (code.equals("203")) {
            Toast.makeText(login.this, status, Toast.LENGTH_SHORT).show();
        } else if (code.equals("204")) {
            Toast.makeText(login.this, status, Toast.LENGTH_SHORT).show();
        }
    }

    public void CekLogin(View view) {
        final String mail = email.getText().toString();
        final String pas = pass.getText().toString();
        StringRequest jsonObjReq = new StringRequest(Request.Method.POST, cek_login,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            Log.e("Volley", jsonObj.toString());
                            String codes = jsonObj.getString("code");
                            Log.e("Code", codes);
                            String status = jsonObj.getString("status");
                            Log.e("Status", status);
                            result(codes, status);
                        } catch (JSONException e) {
                            // If there is an error then output this to the logs.
                            Log.e("Volley", "Invalid JSON Object.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login.this, "Error!!", Toast.LENGTH_SHORT).show();
                        Log.e("Volley", error.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("email", mail);
                params.put("pass", pas);
                return params;
            }

        };

        requestQueue.add(jsonObjReq);
    }


}
