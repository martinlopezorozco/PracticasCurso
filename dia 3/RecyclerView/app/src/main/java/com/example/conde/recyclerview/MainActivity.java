package com.example.conde.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
 List<Producto> listaproductos;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        // ligamos los  elementos recycler view
         rv=(RecyclerView)findViewById(R.id.rv);
        // lernamos la lista
        listaproductos= Arrays.asList(new Producto("Coca-cola","Refresco de lata"),
        new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
                new Producto("Otro","Refresco de lata"),
        new Producto("Otro mas","Refresco de lata"));
        LinearLayoutManager lim=new LinearLayoutManager(this);
        rv.setLayoutManager(lim);
        AdapterRv adaptador= new AdapterRv(listaproductos,this);



        rv.setAdapter(adaptador);




        /*
         ar.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Dando un clic", "P: " +
                        rv.getChildAdapterPosition(view));
                View v1 = rv.getChildAt(rv.getChildAdapterPosition(view));
                TextView tte = (TextView) v1.findViewById(R.id.cTelefono);
                Log.e("NUMERO AL QUE LLAMARA", tte.getText().toString());
                /// Intención para mandar llamar al numero que se tiene
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tte.getText().toString()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},225);
                    return;
                }
                try {
                    startActivity(i);
                }catch(Exception e){
                    Snackbar.make(rv,"Imposible hacer la llamada", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        rv.setAdapter(ar);
        rv.hasFixedSize();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
         */

    }
}
