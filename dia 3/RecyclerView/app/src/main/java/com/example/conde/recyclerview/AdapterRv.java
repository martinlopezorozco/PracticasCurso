package com.example.conde.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by CONDE on 30/09/2017.
 */

public class AdapterRv  extends RecyclerView.Adapter<AdapterRv.ProductoViewHolder>
                        {

    private List<Producto> listaproductos;
                            Context ctx;
//constructor de la lista funcion : permite enviar y recibir los parametros de la clase Producto
    public AdapterRv(List<Producto> listaproductos,MainActivity ctx) {
        this.listaproductos = listaproductos;
        this.ctx=ctx;
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.activity_main,parent,false);

        ProductoViewHolder ph=new ProductoViewHolder(vista,ctx,listaproductos);
        return ph;
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {
                Producto pro= listaproductos.get(position);
        holder.Txttitulo.setText(pro.getNombre());
        holder.TxtDescripcion.setText(pro.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaproductos.size();
    }


    public static class ProductoViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Txttitulo;
        TextView TxtDescripcion;
        List<Producto> listaproductos;
        Context ctx;


        public ProductoViewHolder(View itemView,  Context ctx,List<Producto> listaproducto){
            super(itemView);

            this.listaproductos=listaproducto;
            this.ctx=ctx;
            itemView.setOnClickListener(this);

            Txttitulo=(TextView) itemView.findViewById(R.id.txtTitulo);
            TxtDescripcion=(TextView)itemView.findViewById(R.id.txtdescripcion);

        }


        @Override
        public void onClick(View v) {
            int posicion=getAdapterPosition();
            Producto pro=this.listaproductos.get(posicion);
            Toast.makeText(ctx, pro.getNombre(), Toast.LENGTH_SHORT).show();
        }
    }
    
    
    
}
