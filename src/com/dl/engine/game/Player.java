/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import java.awt.event.KeyEvent;

/**
 *
 * @author Luiz
 */
public class Player extends GameObject
{
    private int tileX;
    private int tileY;
    private float offX;
    private float offY;
    
    private float speed = 100;
    private float fallSpeed = 10;
    private float jump = -4;
    private boolean ground = false;
    
    private float fallDistance = 0;
    
    public Player(int posX, int posY)
    {
        this.tag = "player";
        this.tileX = posX;
        this.tileY = posY;
        this.offX = 0;
        this.offY = 0;
        this.posX = posX * GameManager.TILE_SIZE;
        this.posY = posY * GameManager.TILE_SIZE;
        this.width = GameManager.TILE_SIZE;
        this.height = GameManager.TILE_SIZE;
    }

    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        //Andar para esquerda e direita
        if(ge.getInput().isKey(KeyEvent.VK_D))
        {
            if (gm.getCollision(tileX +1, tileY))
            {
                if (offX < 0)
                {
                    offX += deltaTime * speed;
                    if (offX > 0)
                    {
                        offX = 0;
                    }
                }
                else {
                    offX = 0;
                }
            }
            else {
                offX += deltaTime * speed;
            }
        }
        
        if(ge.getInput().isKey(KeyEvent.VK_A))
        {
            if (gm.getCollision(tileX -1, tileY))
            {
                if (offX > 0)
                {
                    offX -= deltaTime * speed;
                    if (offX < 0)
                    {
                        offX = 0;
                    }
                }
                else {
                    offX = 0;
                }
            }
            else {
                offX -= deltaTime * speed;
            }
        }
        
        //Fim do movimento lateral
        
        //Começo do pulo e gravidade
        fallDistance += deltaTime * fallSpeed;
        
        if(ge.getInput().isKeyDown(KeyEvent.VK_W) && ground)
        {
            fallDistance = jump;
            ground = false;
        }
        
        offY += fallDistance;
        
        if(gm.getCollision(tileX, tileY + 1) && offY >= 0)
        {
            fallDistance = 0;
            offY = 0;
            ground = true;
        }
        //Fim do pulo e gravidade
        
        
        //Posição Final
        if(offY > GameManager.TILE_SIZE / 2)
        {
            tileY++;
            offY -= GameManager.TILE_SIZE;
        }
        
        if(offY < -GameManager.TILE_SIZE / 2)
        {
            tileY--;
            offY += GameManager.TILE_SIZE;
        }
        
        if(offX > GameManager.TILE_SIZE / 2)
        {
            tileX++;
            offX -= GameManager.TILE_SIZE;
        }
        
        if(offX < -GameManager.TILE_SIZE / 2)
        {
            tileX--;
            offX += GameManager.TILE_SIZE;
        }
        
        posX = tileX * GameManager.TILE_SIZE + offX;
        posY = tileY * GameManager.TILE_SIZE + offY;
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawFillRect((int)posX, (int)posY, width, height, 0xff00ff00);
    }
    
}
