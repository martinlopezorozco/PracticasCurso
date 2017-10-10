package com.example.conde.confirmacion;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Interface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intanciar dialogo
                FragmentManager fragmentManager=getFragmentManager();
                DialogoConfirmar dialogo=DialogoConfirmar.motododiualogo(MainActivity.this);
                dialogo.show(fragmentManager,"tag");
            }
        });
    }
    @Override
    public void returnValue(boolean res) {
        Log.e("Regreso",String.valueOf(res));
    if (res==true){
        finish();
    }
    }
}
