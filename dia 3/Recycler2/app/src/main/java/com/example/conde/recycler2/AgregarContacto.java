package com.example.conde.recycler2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgregarContacto extends AppCompatActivity {
 EditText txtNombre;
    EditText txtTelefono;
    Button btnagregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);
        txtNombre=(EditText)findViewById(R.id.agNombre);
        txtTelefono=(EditText)findViewById(R.id.agTelefono);
        btnagregar=(Button)findViewById(R.id.button);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=txtNombre.getText().toString();
                String telefono=txtTelefono.getText().toString();
                Contacto contacto=new Contacto(nombre,telefono);
                MainActivity.datos.add(contacto);
                finish();
            }
        });

    }
}
