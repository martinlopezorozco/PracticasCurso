package com.example.conde.personalizado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by CONDE on 07/10/2017.
 */

public class DialogCaptura extends DialogFragment {

    Interface r;
    public DialogCaptura(){
        //Constructor vacio
    }
    public static DialogCaptura guardardato(Interface r){
        DialogCaptura dialogCaptura=new DialogCaptura();
        dialogCaptura.r=r;
        return dialogCaptura;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedIntanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle("NOmbre DE perdona");
        builder.setMessage("   ");

        final EditText input=new EditText(getActivity());
        input.setHint("Escribe tu nombre");
        input.setTextSize(20);
        builder.setView(input);
        builder.setPositiveButton("GUardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String cadena=input.getText().toString();
                    r.enviadato(cadena);
            }
        })
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
return builder.show();
    }
}
