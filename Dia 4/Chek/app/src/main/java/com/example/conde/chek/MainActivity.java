package com.example.conde.chek;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getFragmentManager();
                DialogoCheck dialogo=new DialogoCheck();
                dialogo.setCancelable(false);
                dialogo.show(fragmentManager,"tag");
            }
        });
        //dialog Varios opciones
        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getFragmentManager();
                VariasOPciones dialogo=new VariasOPciones();
                dialogo.setCancelable(false);
                dialogo.show(fragmentManager,"tag");
            }
        });

        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getFragmentManager();
               DialogSeleccion dialogo=new DialogSeleccion();
                dialogo.setCancelable(false);
                dialogo.show(fragmentManager,"tag");
            }
        });

    }
}
