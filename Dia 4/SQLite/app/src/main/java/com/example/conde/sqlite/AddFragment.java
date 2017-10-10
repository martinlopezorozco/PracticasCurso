package com.example.conde.sqlite;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by CONDE on 07/10/2017.
 */

public class AddFragment extends Fragment {
    View vista;
    EditText nombre,telefono;

public AddFragment(){
    //contructor vacio
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saverInstanceState){

        //inflar la vista del fragmento principal
        //return inflater.inflate(R.layout.fragment_add,container,false);

        vista = inflater.inflate(R.layout.fragment_add, container, false);
        nombre=(EditText) vista.findViewById(R.id.ednombre);
        telefono=(EditText)vista.findViewById(R.id.edtelefono);
        FloatingActionButton btn=(FloatingActionButton)vista.findViewById(R.id.btnsaved);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Persona per=new Persona(nombre.getText().toString(),telefono.getText().toString());
                BaseDatosPersonal.addPersonal(per,vista.getContext());
                Snackbar.make(vista,"Se guardo correcto",Snackbar.LENGTH_LONG).show();
            }
        });
        return vista;
    }

}
