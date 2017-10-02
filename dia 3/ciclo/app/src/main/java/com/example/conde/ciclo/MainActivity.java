package com.example.conde.ciclo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MEtodo","Oncreate");
    }//fin ONcreate



            @Override
    protected void onRestart(){
                super.onRestart();
                Log.e("MEtodo","OnRestart");
            }
            @Override
    protected void onPause(){
                super.onPause();
                Log.e("MEtodo","Onpause");

            }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MEtodo","OnResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MEtodo","Ostart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MEtodo","Onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MEtodo","OnDistroy");
    }
}
