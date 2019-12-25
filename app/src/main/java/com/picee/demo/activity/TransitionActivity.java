package com.picee.demo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.AutoTransition;
import androidx.transition.Scene;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;

import com.picee.demo.R;

public class TransitionActivity extends AppCompatActivity {
    private FrameLayout sceneRoot;
    private boolean isTarget = false;

    private Scene sceneOrigin;
    private Scene sceneTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        sceneRoot = findViewById(R.id.scene_root);

        sceneOrigin = Scene.getSceneForLayout(sceneRoot, R.layout.scene_origin, this);
        sceneTarget = Scene.getSceneForLayout(sceneRoot, R.layout.scene_target, this);
    }

    public void switchAnim(View view) {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(500);
        autoTransition.setInterpolator(new BounceInterpolator());
        if (!isTarget) {
            TransitionManager.go(sceneTarget);
        } else {
            TransitionManager.go(sceneOrigin);
        }
        isTarget = !isTarget;
    }
}
