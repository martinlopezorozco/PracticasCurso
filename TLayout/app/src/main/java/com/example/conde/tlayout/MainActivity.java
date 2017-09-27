package com.example.conde.tlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabla)
    TableLayout tableLayout;
    List<Materia> boleta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        boleta=new ArrayList<>();
        boleta.add(new Materia("MATEMATICAS",100));
        boleta.add(new Materia("FISICA",85));
        boleta.add(new Materia("ESPAÑOL",90));
        boleta.add(new Materia("CIENCIAS",70));
        boleta.add(new Materia("LEYES",88));
        boleta.add(new Materia("POO",100));
        boleta.add(new Materia("OTRA",100));
        boleta.add(new Materia("MATEMATICAS 1",100));
        boleta.add(new Materia("MATEMATICAS 2",100));
        boleta.add(new Materia("MATEMATICAS 3",100));
        boleta.add(new Materia("MATEMATICAS 4",100));
        boleta.add(new Materia("MATEMATICAS",100));
        boleta.add(new Materia("FISICA",85));
        boleta.add(new Materia("ESPAÑOL",90));
        boleta.add(new Materia("CIENCIAS",70));
        boleta.add(new Materia("LEYES",88));
        boleta.add(new Materia("POO",100));
        boleta.add(new Materia("OTRA",100));
        boleta.add(new Materia("MATEMATICAS 1",100));
        boleta.add(new Materia("MATEMATICAS 2",100));
        boleta.add(new Materia("MATEMATICAS 3",100));
        boleta.add(new Materia("MATEMATICAS 4",100));
        boleta.add(new Materia("MATEMATICAS",100));
        boleta.add(new Materia("FISICA",85));
        boleta.add(new Materia("ESPAÑOL",90));
        boleta.add(new Materia("CIENCIAS",70));
        boleta.add(new Materia("LEYES",88));
        boleta.add(new Materia("POO",100));
        boleta.add(new Materia("OTRA",100));
        boleta.add(new Materia("MATEMATICAS 1",100));
        boleta.add(new Materia("MATEMATICAS 2",100));
        boleta.add(new Materia("MATEMATICAS 3",100));
        boleta.add(new Materia("MATEMATICAS 4",100));

        actualizatable(boleta);
    }


    public void actualizatable(List<Materia> boleta){
        //cargamos en la vista la boleta
        tableLayout.removeAllViews();
        //creamos el emcabezado de la tabla
        TableRow renglon= new TableRow(this);
        renglon.setBackgroundColor( getResources().getColor(R.color.encabezado));

        //COLUMNA 1
        TextView tv= new TextView(this);
        tv.setLayoutParams(new TableRow.LayoutParams(0));
        tv.setPadding(5,5,5,5);
        tv.setText("MATERIA");
        tv.setTextColor(Color.WHITE);
        renglon.addView(tv);

        // columna 2
        tv = new TextView(this);
        tv.setLayoutParams(new TableRow.LayoutParams(2)); // propiedad layout_column
        tv.setPadding(5,5,5,5);
        tv.setText("calificacion");
        tv.setTextColor(Color.WHITE);
        renglon.addView(tv);
        tableLayout.addView(renglon);



        // llenamos la tabla con las materias de la lista
        //declaramos la suma
        float suma=0;

        for (Materia materia: boleta){
            suma+=(float)materia.getCalificaciones();
            //agregar otro renglon
            renglon=new TableRow(this);
            //Agregamos nombre de las materias
            tv=new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(0)); // propiedad layout_column
            tv.setPadding(5,5,5,5);
            tv.setText(materia.getNombre());
            tv.setTextColor(Color.BLACK);
            renglon.addView(tv);
            //agregamos calificaciones
            tv=new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(2)); // propiedad layout_column
            tv.setPadding(5,5,5,5);
            tv.setText(String.valueOf(materia.getCalificaciones()));
            tv.setTextColor(Color.BLACK);
            renglon.addView(tv);
            tableLayout.addView(renglon);

        }//fin de for
        //mostramos el promedio

        float promedio= suma!=0? suma/boleta.size():0.0f;
        //linea que divide
        renglon = new TableRow(this);
        renglon.setLayoutParams(
                new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,5));
        renglon.setBackgroundColor(getResources().getColor(R.color.lineseparar));

        tv=new TextView(this);
        tv.setHeight(5);
        renglon.addView(tv);
        tableLayout.addView(renglon);
        //renglon final
        renglon=new TableRow(this);
        //columna promedio
        tv=new TextView(this);
        tv.setPadding(5,5,5,5);
        tv.setText("Promedio");
        tv.setTextColor(getResources().getColor(R.color.encabezado));
        tv.setLayoutParams(new TableRow.LayoutParams(1));
        renglon.addView(tv);
        //columna de cantidad de promedio
        tv= new TextView(this);
        tv.setPadding(5,5,5,5);
        tv.setText(String.format("%.1f",promedio));
        tv.setTextColor(getResources().getColor(R.color.encabezado));
        tv.setLayoutParams(new TableRow.LayoutParams(1));
        renglon.addView(tv);
        tableLayout.addView(renglon);

    }//fin metodo actualiza
}
