package com.example.dgraja.exp01.category;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.dgraja.exp01.R;
import com.example.dgraja.exp01.utils.alerts;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class prompts extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
//            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
//                    | View.SYSTEM_UI_FLAG_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                //delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_prompts);

        mVisible = true;
        //mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
//        mContentView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//        );
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    public void showPrompt(View view) {
        // Show a plain alert
        alerts.showPrompt(this, "Are you sure ?");
    }

    public void showBlockingAlert(View view) {
        // Show a plain alert
        alerts.showBlockingAlert(this, "Click ok to continue ...");
    }

    public void yesClick(DialogInterface dialog, int which) {
        Toast.makeText(this, "Going back", Toast.LENGTH_SHORT).show();
        //dialog.dismiss();
        //this.finish();
    }

    public void noClick(DialogInterface dialog, int which) {
        //dialog.cancel();
        Toast.makeText(prompts.this, "do not close", Toast.LENGTH_SHORT).show();
    }

    public void confirmExit(View view) {
        alerts.confirmPrompt(this, "Are you sure you want to go back ?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(prompts.this, "Going back", Toast.LENGTH_SHORT).show();
                prompts.this.finish();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(prompts.this, "do not close", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public CharSequence []simpleList;
    public void alertSimpleList(View view) {
        simpleList = new CharSequence[] { "lion", "tiger", "wolf", "hyena", "leopard", "rhino", "elephant", "hippo", "wild beast", "bison", "Oryx", "deer", "cheetah", "Ostrich" };
        alerts.displayListAlert(this, "Select an animal :", simpleList, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(prompts.this, "Item selected: " + simpleList[which], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public CharSequence []multiList;
    public boolean []multiChoice;
    public void alertMultiChoiceList(View view) {
        multiList = new CharSequence[] { "lion", "tiger", "wolf", "hyena", "leopard", "rhino", "elephant", "hippo", "wild beast", "bison", "Oryx", "deer", "cheetah", "Ostrich" };
        multiChoice = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        DialogInterface.OnClickListener okCallback = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.e("exp01", "Multi select alert completed...");
                String selected = "";
                for (int i=0; i<multiChoice.length; i++) {
                    if (multiChoice[i] == true) {
                        selected = selected + ", " + multiList[i];
                    }
                }
                Log.e("exp01", "Multi select result: " + selected);
                Toast.makeText(prompts.this, "selections: " + selected, Toast.LENGTH_SHORT).show();
            }
        };
        DialogInterface.OnMultiChoiceClickListener selectCallback = new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                multiChoice[which] = isChecked;
                Log.w("exp01", "Item selected: " + multiList[which]);
                //Toast.makeText(prompts.this, "Item selected: " + multiList[which], Toast.LENGTH_SHORT).show();
            }
        };
        alerts.displayMutiChoiceAlert(this, "Select some animals:", multiList, multiChoice, selectCallback, okCallback);
    }

}
