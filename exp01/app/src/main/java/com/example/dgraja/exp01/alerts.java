package com.example.dgraja.exp01;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by dgraja on 28-03-2016.
 */
public class alerts {
    public static boolean showAlert(Context ctx, CharSequence msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                return;
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                return;
            }
        });
        builder.setTitle(msg);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return true;
    }
}
