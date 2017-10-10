package com.example.conde.personalizado;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Interface {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.txt);
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                DialogPersonalizado dialogo=new DialogPersonalizado();
                dialogo.show(fragmentManager,"tag");
            }
        });

    //boton de capturar
        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
              DialogCaptura dialogo=DialogCaptura.guardardato(MainActivity.this);
                dialogo.show(fragmentManager,"tag");
            }
        });

    }

    @Override
    public void enviadato(String texto) {
        txt.setText(texto);
    }
}
