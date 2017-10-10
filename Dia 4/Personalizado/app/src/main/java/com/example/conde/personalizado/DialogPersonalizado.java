package com.example.conde.personalizado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Created by CONDE on 07/10/2017.
 */

public class DialogPersonalizado extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedIntanceState){

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_persona,null))
                .setTitle("Informacion")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();

    }
}
