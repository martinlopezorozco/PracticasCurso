package com.example.conde.chek;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by CONDE on 07/10/2017.
 */

public class DialogSeleccion extends DialogFragment {




    @Override
    public  Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] items = {"OPCION1", "OPCION2", "OPCION3"};
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("Seleccion")

                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("Dialogos","OPCSELCT;  "+ items[which]);
                    }
                });
        return builder.create();
    }
}
