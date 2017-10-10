package com.example.conde.confirmacion;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by CONDE on 07/10/2017.
 */

public class DialogoConfirmar extends DialogFragment {

    //declaraamos interface
    Interface r;
    public DialogoConfirmar(){
        //contructor vacio
    }

    //metodo el cual realizara el trabajo
    public static DialogoConfirmar motododiualogo(Interface r){
        DialogoConfirmar dialogoConfirmar=new DialogoConfirmar();
        dialogoConfirmar.r=r;
        return dialogoConfirmar;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage("¿Confirma la ccion seleccionada?")
                .setTitle("Confirmacion")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("Dilogo","COnfirmacion Aceptada");
                        r.returnValue(true);
                        dialog.cancel();
                    }
                })
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("Dialogo","Confirmacion Cancelada");
                        r.returnValue(false);
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
