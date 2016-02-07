package com.twh5257_jdm5908_bw.ist402.paintscene;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    ViewGroup paintingContainer;
    Transition transition;
    Scene activeScene;
    Scene passiveScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintingContainer = (ViewGroup) findViewById(R.id.painting_container);
        transition = TransitionInflater.from(this).inflateTransition(R.anim.transition);
        activeScene = Scene.getSceneForLayout(paintingContainer, R.layout.scene01, this);
        passiveScene = Scene.getSceneForLayout(paintingContainer, R.layout.scene02, this);
        activeScene.enter();
    }

    public void changeScenes(View view){
        Scene temp = passiveScene;
        passiveScene = activeScene;
        activeScene = temp;

        TransitionManager.go(activeScene, transition);
    }
}
