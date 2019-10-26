package com.example.alice;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class GameplayScene implements Scene{

    @Override
    public void terminate(){
        SceneManager.ACTIVE_SCENE = 0;
    }

    @Override
    public void updates() {

    }

    @Override
    public void recieveTouch(MotionEvent){

    }
    @Override
    public void draw(Canvas canvas){

    }
    @Override
    public void update(){

    }
}

