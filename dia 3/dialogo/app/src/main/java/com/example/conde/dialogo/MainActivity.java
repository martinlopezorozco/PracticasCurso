package com.example.conde.dialogo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textoBusquedaEsto = (TextView) findViewById(R.id.txtBuscarEsto);
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("titulo");
        alert.setMessage("Por favor introdusca una dirección.");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Guardamos el valor digitado en una variable o lo mostramos en
                // un TextViews no se lo que se nos ocurra o lo que necesitemos
                // hacer.

                String cadenaBuscar = input.getText().toString();
                //textoBusquedaEsto.setText(cadenaBuscar);
                Toast.makeText(MainActivity.this, cadenaBuscar, Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.

                    }
                });



        Button btnBusca1 = (Button) findViewById(R.id.btnlanzar);
        btnBusca1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                alert.show();
            }
        });


    }

    public void otro(){
        final TextView textoBusquedaEsto = (TextView) findViewById(R.id.txtBuscarEsto);
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("titulo");
        alert.setMessage("Por favor introdusca una dirección.");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Guardamos el valor digitado en una variable o lo mostramos en
                // un TextViews no se lo que se nos ocurra o lo que necesitemos
                // hacer.

                 String cadenaBuscar = input.getText().toString();
                //textoBusquedaEsto.setText(cadenaBuscar);
                Toast.makeText(MainActivity.this, cadenaBuscar, Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.

                    }
                });

        alert.show();

        Button btnBuscar = (Button) findViewById(R.id.btnPedirDireccion);
        btnBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                alert.show();
            }
        });
    }
}
