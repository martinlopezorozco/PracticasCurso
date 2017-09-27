package com.example.conde.tlayout;

/**
 * Created by CONDE on 23/09/2017.
 */

public class Materia {
    String nombre;
    float calificaciones;

    public Materia(String nombre, float calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(float calificaciones) {
        this.calificaciones = calificaciones;
    }
}
