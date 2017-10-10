package com.example.conde.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //importamsos la clase de notificacion
    NotificationCompat.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creamos la notificacion
        mBuilder= new NotificationCompat.Builder(MainActivity.this);

        mBuilder.setSmallIcon(android.R.drawable.alert_dark_frame);
        mBuilder.setLargeIcon((((BitmapDrawable)getResources()
                .getDrawable(R.mipmap.ic_launcher)).getBitmap()));
        mBuilder.setContentTitle("Titulo Alerta");
        mBuilder.setContentText("Contenido que vera el usuario");
        mBuilder.setTicker("Alerta");
        mBuilder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
        mBuilder.setSound(Uri.parse("uri://jamendo_licencia"));
        mBuilder.setContentInfo("REV");
        mBuilder.setLights(Color.RED, 3000, 3000);
        mBuilder.setAutoCancel(true);
//activar la funcionalidad

        Intent notIntent=new Intent(MainActivity.this,MainActivity.class);
        notIntent.putExtra("nombre","Esta es un aprueba de notificacion");
        notIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|
                Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent contentIntent=PendingIntent.getActivity
                (MainActivity.this,0,notIntent,0);


                mBuilder.setContentIntent(contentIntent);


    }
    //metodo onClick del boton
        public void mandaNotificacion(View view){
            NotificationManager mnNotificationManager=
                    (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            mnNotificationManager.notify(1234,mBuilder.build());
        }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        Log.e("Notificacion","Codigo"+requestCode);
        super.onActivityResult(requestCode,resultCode,data);
    }

    //funcion de la notificacion
    @Override
    protected void  onNewIntent(Intent intent){
        Bundle extras=intent.getExtras();
        if (extras!=null){
            if (extras.containsKey("nombre")){
                String msg=extras.getString("nombre");
                Log.e("Nombre1: ",msg);
            }
        }
    }



}
