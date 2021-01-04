/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game.objects;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.game.GameManager;

/**
 *
 * @author Luiz
 */
public class Fade extends GameObject
{

    public static final int FADE_IN = 0;
    public static final int FADE_OUT = 1;

    private int fadeType;
    private float speed = 200;
    private int color;
    private int keepColor;
    private int newColor;

    private int maxFadeLevel;    
    private float offFadeLevel;

    public Fade(int fadeType, float speed, int color)
    {
        this.fadeType = fadeType;
        this.speed = speed;
        this.color = color;
        this.keepColor = color & 0x00ffffff;

        switch (fadeType)
        {
            case FADE_IN:
                maxFadeLevel = 0;
                offFadeLevel = 255;
                break;
            case FADE_OUT:
                maxFadeLevel = 255;
                offFadeLevel = 0;
                break;
        }
    }

    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        switch (fadeType)
        {
            case FADE_IN:
                offFadeLevel -= speed * deltaTime;
                newColor = keepColor | ((int) offFadeLevel << 24);
                if (offFadeLevel < maxFadeLevel)
                {
                    this.dead = true;
                }
                break;
            case FADE_OUT:
                offFadeLevel += speed * deltaTime; 
                newColor = keepColor | ((int) offFadeLevel << 24);
                if (offFadeLevel > maxFadeLevel)
                {
                    this.dead = true;
                }
                break;
        }
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawFillRect(0, 0, ge.getWidth(), ge.getHeight(), newColor);
    }

    @Override
    public void collision(GameObject other)
    {

    }

}
