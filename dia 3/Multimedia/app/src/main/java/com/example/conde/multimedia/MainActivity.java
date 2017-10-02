package com.example.conde.multimedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
ImageButton btngo,btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngo=(ImageButton)findViewById(R.id.btngo);
        btnstop=(ImageButton)findViewById(R.id.btnstop);

    btngo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //poner Iniciar
            Intent i=new Intent(MainActivity.this,ReproductorService.class);
            Log.e("Bandera","aqui paso1");
            startService(i);
        }

    });
    btnstop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //terminar
            Intent i=new Intent(MainActivity.this,ReproductorService.class);
            stopService(i);
        }
    });



    }
}
