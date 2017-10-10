package com.example.conde.alert_dialog;

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
               // FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentManager fragmentManager=getFragmentManager();
                DialogoAlerta dialogo=new DialogoAlerta();
                dialogo.show(fragmentManager,"etiqueta");
            }
        });
    }
}
