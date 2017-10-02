package com.example.conde.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {


    //elementos
    EditText edDireccion;
    TextView txtResultado;
    TextView txtStatus;
    ImageButton boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // relaccionamos los elementos con el xml
        edDireccion=(EditText)findViewById(R.id.edDireccion);
        txtResultado=(TextView)findViewById(R.id.txtResultado);
        txtStatus=(TextView)findViewById(R.id.txtStatus);
        boton=(ImageButton)findViewById(R.id.btnDescarga);

        //metodo onclick
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //Inicia la descarga
                DescargaAsincrona clase=new DescargaAsincrona();
                clase.execute(edDireccion.getText().toString());
            }
        });
    }//fon Oncreate

        //creamos la clase de AsynTasck para la descarga
    class DescargaAsincrona extends AsyncTask<String,Integer,String>{

            //antes de la ejecucion
            @Override
            protected void onPreExecute(){
                txtStatus.setText("Iniciando la descarga..........");
                txtResultado.setText("Esperando Resultado......");
                super.onPreExecute();
            }
            //en ejecucion
            @Override
            protected String doInBackground(String... params) {
                Integer contador=0;
                try{
                    URL url=null;
                    url=new URL(params[0]);
                    URLConnection con=url.openConnection();
                    BufferedReader lector=new BufferedReader
                            (new InputStreamReader(con.getInputStream()));
                    //declaramos las variables internas las cuales obtendran los valores
                    String line="";
                    String resultado="";
                    //Ejecutamos el hilo
                    while  ((line=lector.readLine())!=null){
                        resultado+=line;
                        contador++;
                        publishProgress(contador);
                        Thread.sleep(200);
                    }
                    return resultado;
                }catch(Exception e){
                    Log.e("Error","Durante la ejecucion"+e.toString());
                }

                return "";
            }
            //Procesamdo la ejecucion o recargando el hilo
            @Override
            protected void  onProgressUpdate(Integer... values){
                txtStatus.setText("Lineas Leidas"+values[0]);
                super.onProgressUpdate(values);
            }
            //al finaliza la ejecucion
            @Override
            protected void  onPostExecute(String s){
                txtResultado.setText(s);
                super.onPostExecute(s);
            }
        }


}
