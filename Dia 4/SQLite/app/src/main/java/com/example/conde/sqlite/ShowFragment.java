package com.example.conde.sqlite;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by CONDE on 07/10/2017.
 */

public class ShowFragment extends Fragment {

    RecyclerView rv;
    public  ShowFragment(){

    }




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saverInstanceState) {

        //inflar la vista del fragmento principal
        //return inflater.inflate(R.layout.fragment_add,container,false);

       View vista = inflater.inflate(R.layout.fragment_show, container, false);



        rv=(RecyclerView)vista.findViewById(R.id.listapersonal);
        AdaptadorRecycler arc=new AdaptadorRecycler(vista.getContext());
        rv.setAdapter(arc);
        rv.hasFixedSize();
        LinearLayoutManager lim=new LinearLayoutManager(vista.getContext());
        rv.setLayoutManager(lim);


return vista;
    }
}




