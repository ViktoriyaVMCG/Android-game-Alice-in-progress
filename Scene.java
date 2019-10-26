package com.example.alice;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Scene {
    public void updates();

    void recieveTouch(MotionEvent);

    public void draw(Canvas canvas);
    public void terminate();

    void update();
}
