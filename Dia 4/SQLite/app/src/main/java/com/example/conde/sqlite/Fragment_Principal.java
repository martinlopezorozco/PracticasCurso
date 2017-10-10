package com.example.conde.sqlite;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by CONDE on 07/10/2017.
 */

public class Fragment_Principal extends Fragment{


    public Fragment_Principal(){
        //constructor vacion
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saverInstanceState){

        //inflar la vista del fragmento principal
        return inflater.inflate(R.layout.fragment_principal,container,false);
    }
}
