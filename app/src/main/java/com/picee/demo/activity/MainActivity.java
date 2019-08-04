package com.picee.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.picee.demo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startConstraintLayout(View view) {
        startActivity(new Intent(this, ConstraintLayoutActivity.class));
    }

    public void startAutoSizeLayout(View view) {
        startActivity(new Intent(this, AutoSizeActivity.class));
    }
}
