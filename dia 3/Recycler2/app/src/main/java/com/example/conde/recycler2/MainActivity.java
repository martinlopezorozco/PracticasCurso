package com.example.conde.recycler2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rv;
    FloatingActionButton btnir;
    public static List<Contacto> datos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        btnir=(FloatingActionButton)findViewById(R.id.agregarBoton);
        //boton ir otra Actividad
        btnir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AgregarContacto.class);
                startActivity(i);
            }
        });//fin boton
//agregamos un valor a la llsta
       // datos= Arrays.asList(new Contacto("lola","1234565"));
        actualizaRecycler();
    }


    public void actualizaRecycler() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        AdaptorRecycler ar = new AdaptorRecycler(datos);
        //programamos el evento
            ar.setListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.e("Clic en;","posicion"+rv.getChildAdapterPosition(v));
        View v1=rv.getChildAt(rv.getChildAdapterPosition(v));
        TextView tte= (TextView)v1.findViewById(R.id.cTelefono);
        Log.e("NUmero  marcar",tte.getText().toString());
        /// Intención para mandar llamar al numero que se tiene
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tte.getText().toString()));
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE},225);
            return;
        }
        try {
            startActivity(i);
        }catch(Exception e){
            Snackbar.make(rv,"Imposible hacer la llamada", Snackbar.LENGTH_LONG).show();
        }
    }
});
        rv.setAdapter(ar);
        rv.hasFixedSize();

    }
    @Override
    protected void onResume(){
        super.onResume();
        actualizaRecycler();
    }



}