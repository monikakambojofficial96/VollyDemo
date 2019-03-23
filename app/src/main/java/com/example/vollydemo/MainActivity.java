package com.example.vollydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    String server_url="https://api.androidhive.info/volley/person_object.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        button = findViewById ( R.id.button );
        textView=findViewById ( R.id.textView );

        button.setOnClickListener ( new View.OnClickListener (){

            @Override
            public void onClick(View v) {

                final RequestQueue requestQueue= Volley.newRequestQueue ( MainActivity.this );

                StringRequest stringRequest=new StringRequest ( Request.Method.POST , server_url ,


                        new Response.Listener <String> () {
                            @Override
                            public void onResponse(String response) {

                                textView.setText ( response );
                                requestQueue.stop ();

                            }
                        } , new Response.ErrorListener () {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        textView.setText ( "there is something wrong" );

                        error.printStackTrace ();

                        requestQueue.stop ();

                    }
                } );

                requestQueue.add ( stringRequest );
            }
        });

    }
}
