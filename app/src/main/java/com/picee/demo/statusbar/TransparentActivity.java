package com.picee.demo.statusbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.picee.demo.R;

public class TransparentActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
