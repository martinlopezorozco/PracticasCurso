package com.example.conde.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Actualiza extends AppCompatActivity {
                 EditText ednombre,edtelefono;
             FloatingActionButton btnguardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualiza);

        ednombre=(EditText)findViewById(R.id.Ednombre);
        edtelefono=(EditText)findViewById(R.id.Edtelefono);
        btnguardar=(FloatingActionButton)findViewById(R.id.btnguardar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //crear   Sharesdprefereces

                SharedPreferences SP= getSharedPreferences("misdatos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=SP.edit();
                editor.putString("nombre",ednombre.getText().toString());
                editor.putString("telefono",edtelefono.getText().toString());
                editor.commit();
                finish();

            }
        });

    }
}
