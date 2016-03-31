package com.example.dgraja.exp01.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import com.example.dgraja.exp01.R;

/**
 * Created by dgraja on 28-03-2016.
 */
public class alerts {
    private static boolean bResult;
    private static Context context;

    public static void showPrompt(Context ctx, CharSequence msg) {
        context = ctx;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(context, "Yes clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(context, "No clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setTitle("Prompt");
        builder.setMessage(msg);
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return;
    }

    public static boolean showBlockingAlert(Context ctx, CharSequence msg) {
        context = ctx;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(context, "OK clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setTitle("Blocking Alert");
        builder.setMessage(msg);
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return true;
    }

    public static void confirmPrompt(Context ctx, CharSequence msg, DialogInterface.OnClickListener yesCallback, DialogInterface.OnClickListener noCallback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("Yes", yesCallback);
        builder.setNegativeButton("No", noCallback);
        builder.setTitle("Confirm Prompt");
        builder.setMessage(msg);
        builder.setIcon(R.mipmap.ic_red_warning);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return;
    }

    public static void displayListAlert(Context ctx, CharSequence title, CharSequence []options, DialogInterface.OnClickListener selectCallback) {
        context = ctx;
        Log.e("exp01", "entering displayListAlert ...");
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.e("exp01", "Ok button clicked !!");
                Toast.makeText(context, "Done clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setTitle(title);
        builder.setItems(options, selectCallback);
        builder.setIcon(R.mipmap.ic_list_01);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return;
    }

    public static void displayMutiChoiceAlert(Context ctx,
                                              CharSequence title,
                                              CharSequence []options,
                                              boolean[] states,
                                              DialogInterface.OnMultiChoiceClickListener selectCallback,
                                              DialogInterface.OnClickListener okCallback) {
        context = ctx;
        Log.e("exp01", "entering displayMutiChoiceAlert ...");
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("Ok", okCallback);
        builder.setTitle(title);
        builder.setMultiChoiceItems(options, states, selectCallback);
        builder.setIcon(R.mipmap.ic_checked_list);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return;
    }
}
