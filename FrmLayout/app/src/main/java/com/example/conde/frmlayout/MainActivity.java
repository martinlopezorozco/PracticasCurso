package com.example.conde.frmlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=(Button)findViewById(R.id.btn);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //crear TextView
                TextView tv1=new TextView(getApplicationContext());
                tv1.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                //enviamos el texto
                tv1.setText("Sin Gravedad");
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,23);
                tv1.setBackgroundColor(Color.rgb(0,136,0));

                TextView tv2= new TextView(getApplicationContext());
                tv2.setLayoutParams(new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        Gravity.RIGHT));
                tv2.setText("right");

                tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP,23);
                tv2.setBackgroundColor(Color.rgb(0,136,0));

                FrameLayout f1=new FrameLayout(getApplicationContext());
                f1.addView(tv1);
                f1.addView(tv2);
                setContentView(f1);

            }
        });
    }
}
