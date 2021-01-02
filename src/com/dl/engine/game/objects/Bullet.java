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
public class Bullet extends GameObject
{
    public static final int UP_DIRECTION = 0;
    public static final int RIGHT_DIRECTION = 1;
    public static final int DOWN_DIRECTION = 2;
    public static final int LEFT_DIRECTION = 3;
    
    private int tileX, tileY;
    private float offX, offY;
    
    private int direction;
    private float speed = 200;
    
    public Bullet(int tileX, int tileY, float offX, float offY, int direction)
    {
        this.direction = direction;
        this.tileX = tileX;
        this.tileY = tileY;
        this.offX = offX;
        this.offY = offY;
        this.padding = 0;
        this.paddingTop = 0;
        this.width = 4;
        this.height = 4;
        
        posX = tileX * GameManager.TILE_SIZE + offX;
        posY = tileY * GameManager.TILE_SIZE + offY;
    }

    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        switch(direction)
        {
            case UP_DIRECTION:      offY -= speed * deltaTime; break;
            case RIGHT_DIRECTION:   offX += speed * deltaTime; break;
            case DOWN_DIRECTION:    offY += speed * deltaTime; break;
            case LEFT_DIRECTION:    offX -= speed * deltaTime; break;
        }
        
        if(offY > GameManager.TILE_SIZE)
        {
            tileY++;
            offY -= GameManager.TILE_SIZE;
        }
        
        if(offY < 0)
        {
            tileY--;
            offY += GameManager.TILE_SIZE;
        }
        
        if(offX > GameManager.TILE_SIZE)
        {
            tileX++;
            offX -= GameManager.TILE_SIZE;
        }
        
        if(offX < 0)
        {
            tileX--;
            offX += GameManager.TILE_SIZE;
        }
        
        if(gm.getCollision(tileX, tileY))
        {
            this.dead = true;
        }
        
        posX = tileX * GameManager.TILE_SIZE + offX;
        posY = tileY * GameManager.TILE_SIZE + offY;
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawFillRect((int)posX, (int)posY, width, height, 0xffff0000);
    }

    @Override
    public void collision(GameObject other)
    {
        
    }
    
}
