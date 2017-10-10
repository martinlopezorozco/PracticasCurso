package com.example.conde.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CONDE on 07/10/2017.
 */

public class AdaptadorRecycler extends
        RecyclerView.Adapter<AdaptadorRecycler.ViewPersona>
        implements  View.OnClickListener {

private List<Persona>lista;
    private View.OnClickListener listener;
    //contexto que trae los datos de la base de datos

    public AdaptadorRecycler (Context context){
        this.lista=BaseDatosPersonal.getLista((context));
    }


    public ViewPersona onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.persona_view,parent,false);
        v.setOnClickListener(this);
        ViewPersona viewPersona=new ViewPersona(v);

        return viewPersona;
    }

    @Override
    public void onBindViewHolder(ViewPersona holder, int position) {
        Persona persona=lista.get(position);
        holder.nombre.setText(persona.getNombre());
        holder.telefono.setText(persona.getTelefono());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
if (listener!=null){
    listener.onClick(v);
}
    }

    public class  ViewPersona extends RecyclerView.ViewHolder{
    TextView nombre, telefono;

        public ViewPersona(View itemView) {

            super(itemView);
        nombre=(TextView)itemView.findViewById(R.id.txtnombre);
            telefono=(TextView)itemView.findViewById(R.id.txttelefono);
        }
    }
}
