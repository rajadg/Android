package org.thinkers.matrixone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import org.thinker.matrixone.helpers.Helper;

public class slider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
    }

    public void OnClickTile(View view) {
        ImageButton button = (ImageButton)view;
        CharSequence seq = (CharSequence)button.getTag();
        button.setImageResource(R.drawable.tile01);
    }
}
