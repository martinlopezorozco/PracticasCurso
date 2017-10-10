package com.example.conde.chek;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by CONDE on 07/10/2017.
 */

public class DialogoCheck extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final String[] items={"JEtta", "Camaro","Rio"};
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setTitle("Seleccion")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Log.e("Dialogo","opcion elegida"+items[which]);
                        Log.e("Estado",String.valueOf(isChecked));
                    }

                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("Dialogos","Confirmacion Acptada");
                        dialog.cancel();

                    }
                });
        return builder.create();
    }

}
