package com.example.conde.imagen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String nom = getString(R.string.saludo);
        Toast.makeText(this, nom, Toast.LENGTH_LONG).show();
    }
}
