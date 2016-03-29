package com.example.dgraja.exp01;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by dgraja on 28-03-2016.
 */
public class alerts {
    private static boolean bResult;

    public static void showPrompt(Context ctx, CharSequence msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.setTitle(msg);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return;
    }

    public static boolean showBlockingAlert(Context ctx, CharSequence msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                return;
            }
        });
        builder.setTitle(msg);
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return true;
    }

    public static void confirmPrompt(Context ctx, CharSequence msg, DialogInterface.OnClickListener yesCallback, DialogInterface.OnClickListener noCallback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("Yes", yesCallback);
        builder.setNegativeButton("No", noCallback);
        builder.setTitle(msg);
        builder.setIcon(R.mipmap.ic_red_warning);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return;
    }
}
