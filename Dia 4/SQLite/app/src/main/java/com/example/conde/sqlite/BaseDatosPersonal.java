package com.example.conde.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CONDE on 07/10/2017.
 */

public class BaseDatosPersonal {

    private  static final List<Persona> persona=new ArrayList<>();

    //metodo agregar persona
    public static void addPersonal(Persona p, Context context){
        EstructuraHelper dbHelper=new EstructuraHelper(context);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues args=new ContentValues();
        args.put("nombre",p.getNombre());
        args.put("telefono",p.getTelefono());
        db.insert("persona",null,args);
        Log.e("Estado DB","Se guardo correctamente");
        persona.add(p);


    }//
    public static List<Persona>    getLista(Context context) {

        EstructuraHelper dbHelper = new EstructuraHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Persona> datos = new ArrayList<>();

        //columnas las cuales quiero obtener
        String columns[] = {"nombre", "telefono"};
        Cursor c = db.query(
                "persona",   //nombre de la tabla
                columns,   //columnas que quiero traer
                null,  //  sentencia where
                null,  //valores para el where en caso de necesitarlos
                null,  //1sentencia GroupBy
                null, // flitros que se aplican
                "nombre ASC"  //ordenamiento
        );
        //recorrer y almacenar en la lista el resultado de la consulta
        if (c.moveToFirst()) {
            do {
                String nombre = c.getString(0);
                String telefono = c.getString(1);
                datos.add(new Persona(nombre, telefono));
            } while (c.moveToNext());
        }


        return datos;
    }
}
