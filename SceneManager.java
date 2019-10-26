package com.example.alice;

import java.util.ArrayList;
import android.graphics.Canvas;
import android.view.MotionEvent;

import static com.example.alice.MainThread.canvas;

public class SceneManager {
    private ArrayList<Scene> scenes = new ArrayList<>();
    private static int ACTIVE_SCENE;

    public SceneManager() {
        ACTIVE_SCENE = 0;
        scenes.add(new GameplayScene());


    }

    public void reciveTouch(MotionEvent event){

    }

    public void update(){
        scenes.get(ACTIVE_SCENE).update();
    }

    public void setScenes(int activeScene){
        scenes.get(ACTIVE_SCENE).draw(canvas);

    }
}
