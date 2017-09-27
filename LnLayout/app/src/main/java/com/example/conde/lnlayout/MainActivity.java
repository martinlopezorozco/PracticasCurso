package com.example.conde.lnlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn)
    Button boton;
    @BindView(R.id.lada)
    EditText lada;
    @BindView(R.id.numero)
    EditText numero;
    @BindView(R.id.desc)
    EditText desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void nombremetodo(){
        Log.e("Boton OK","Usando butterknife");
        String var1= lada.getText().toString();
         String var2=numero.getText().toString();
         var1 += "-" + var2 + "";
        Log.e("resultado",var1);
        desc.setText(var1);
    }
}
