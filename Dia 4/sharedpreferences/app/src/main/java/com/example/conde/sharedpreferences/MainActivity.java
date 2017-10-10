package com.example.conde.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView nombre,telefono;
    FloatingActionButton btnir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         nombre=(TextView)findViewById(R.id.txtnom);
        telefono=(TextView)findViewById(R.id.txttel);
        btnir=(FloatingActionButton)findViewById(R.id.btnir);
        btnir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Actualiza.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onResume(){
       //traemos los datos

        SharedPreferences sp=getSharedPreferences("misdatos", Context.MODE_PRIVATE);
        nombre.setText(sp.getString("nombre","No existe"));
        telefono.setText(sp.getString("telefono","No se encontro"));
        super.onResume();
    }
}
