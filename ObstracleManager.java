package com.example.alice;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class ObstracleManager {
    private ArrayList<Obstacle> obstacles;
    private int playerGap;
    private int obstacleGap;
    private int obstracleHeight;
    private int color;

    private long startTime;
    private long initTime;

    private int score = 0;

    public ObstracleManager(int playerGap, int obstacleGap, int obstacleHeight, int color){
        this.color = color;
        this.playerGap = playerGap;
        this.playerGap = obstacleGap;
        this.obstracleHeight = obstacleHeight;

        startTime = initTime = System.currentTimeMillis();

        obstacles = new ArrayList<>();

        populateObstacles();
    }

    public boolean playerCollide(RectPlayer player){
        for(Obstacle ob : obstacles) {
            if(ob.playerCollide(player))
                return true;
        }
        return false;
    }

    private void populateObstacles() {
        int currY = -5 * Constants.SCREEN_HEIGHT/4;
        while (currY < 0){
            int xStart = (int)(Math.random() * (Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(new Obstacle(obstracleHeight, color, xStart, currY, playerGap));
            currY += obstracleHeight + obstacleGap;

        }
    }

    public void update(){
        int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = (float)(Math.sqrt((startTime - initTime)/1000.0))*Constants.SCREEN_HEIGHT/(100000.0f);
        for(Obstacle ob : obstacles){
            ob.incrementY(speed * elapsedTime);
        }
        if(obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT){
                int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
                obstacles.add(0, new Obstacle(obstracleHeight, color, xStart, obstacles.get(0).getRectangle().top - obstracleHeight - obstacleGap, playerGap));
                obstacles.remove(obstacles.size() - 1);
                score++;
        }

    }


    public void draw(Canvas canvas){
        for(Obstacle ob : obstacles)
            ob.draw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.MAGENTA);
        canvas.drawText("" + score, 50, 50 + paint.descent() - paint.ascent(), paint);
    }
}
