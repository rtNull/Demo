package com.picee.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.picee.demo.R;

public class ConstraintAnimActivity extends AppCompatActivity {

    private ConstraintLayout mConstraintLayout;
    private boolean isTarget = false;
    private ConstraintSet constraintSetOrigin = null;
    private ConstraintSet constraintSetTarget = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_origin);
        mConstraintLayout = findViewById(R.id.constraintOrigin);

        constraintSetOrigin = new ConstraintSet();
        constraintSetTarget = new ConstraintSet();

        constraintSetOrigin.clone(mConstraintLayout);
        constraintSetTarget.clone(this, R.layout.activity_constraint_target);
    }

    public void switchAnim(View view) {
//        TransitionManager.beginDelayedTransition(mConstraintLayout);
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(500);
        autoTransition.setInterpolator(new BounceInterpolator());
        TransitionManager.beginDelayedTransition(mConstraintLayout, autoTransition);
        if (!isTarget) {
            constraintSetTarget.applyTo(mConstraintLayout);
        } else {
            constraintSetOrigin.applyTo(mConstraintLayout);
        }
        isTarget = !isTarget;
    }
}
