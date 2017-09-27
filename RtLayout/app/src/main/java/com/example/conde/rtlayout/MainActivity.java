package com.example.conde.rtlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.hora)
    Spinner sphora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //arreglo que contendra el spinner
        //Toast.makeText(this, "Se mand o a Main", Toast.LENGTH_SHORT).show();
        String listahora[]={"12:00","13:00","14:00"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,listahora);
        sphora.setAdapter(adapter);
        sphora.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //quiero saber cual presione
                String seleccionada=sphora.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), seleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
