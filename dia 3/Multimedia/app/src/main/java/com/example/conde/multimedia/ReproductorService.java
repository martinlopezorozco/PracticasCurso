package com.example.conde.multimedia;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by CONDE on 30/09/2017.
 */

public class ReproductorService extends Service {

    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate(){
        //identificamos el elemento a rfeproducir
        player=MediaPlayer.create(this,R.raw.jamendo_licencia);
        player.setLooping(false);
        super.onCreate();
    }
    @Override
    public void onStart(Intent intent,int startId){
        //inicia la freproduccion
        player.start();
        Log.e("Bandera","aqui paso");
        super.onStart(intent,startId);
    }
    @Override
    public void onDestroy(){
        //fin hilo de ejecucion
        player.stop();
        super.onDestroy();
    }
}
