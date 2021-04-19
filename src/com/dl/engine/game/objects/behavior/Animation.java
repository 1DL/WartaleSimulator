/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game.objects.behavior;

import com.dl.engine.GameEngine;
import com.dl.engine.game.GameManager;

/**
 *
 * @author Luiz
 */
public abstract class Animation
{

    static final int RUNNING = 1;
    static final int PAUSED = 2;
    static final int ENDED = 3;
    static final int DELAY = 4;

    private int totalFrames = 0;
    private float currentFrame = 0;
    private int totalDelay = 0;
    private float currentDelay = 0;
    private int status;
    private boolean loop = true;
    private float playBackSpeed = 1f;
    private float delaySpeed = 1f;
    
    private String tag = "idle";

    public Animation()
    {
    }

    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        switch (status)
        {
            case RUNNING:
                if (currentFrame >= totalFrames)
                {
                    if (loop)
                    {
                        currentFrame = 0;
                    } else
                    {
                        status = ENDED;
                    }
                } else {
                    currentFrame += 1 * playBackSpeed;
                }
                break;
            case PAUSED:
                break;
            case ENDED:
                break;
            case DELAY:
                if (currentDelay >= totalDelay)
                {
                    status = RUNNING;
                } else {
                    currentDelay += 1 * delaySpeed; 
                }
                break;
        }
    }

    public void render()
    {

    }

    public int getTotalFrames()
    {
        return totalFrames;
    }

    public void setTotalFrames(int totalFrames)
    {
        this.totalFrames = totalFrames;
    }

    public float getCurrentFrame()
    {
        return currentFrame;
    }

    public void setCurrentFrame(float currentFrame)
    {
        this.currentFrame = currentFrame;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public boolean isLoop()
    {
        return loop;
    }

    public void setLoop(boolean loop)
    {
        this.loop = loop;
    }

    public float getPlayBackSpeed()
    {
        return playBackSpeed;
    }

    public void setPlayBackSpeed(float playBackSpeed)
    {
        this.playBackSpeed = playBackSpeed;
    }

}
