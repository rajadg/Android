package com.example.dgraja.exp01.category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dgraja.exp01.R;

public class wizard_finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard_finish);
    }

    public void navFinish(View view) {
        Toast.makeText(wizard_finish.this, "Going back", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
