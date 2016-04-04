package org.thinker.matrixone.helpers;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dgraja on 20-03-2016.
 */
public class Helper {
    private static Helper ourInstance = new Helper();

    public static Helper getInstance() {
        return ourInstance;
    }

    private Helper() {
    }

    public void alert(AppCompatActivity activity, CharSequence message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setMessage(message);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return;
    }

}
