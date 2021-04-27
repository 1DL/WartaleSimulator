/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.game.objects.GameObject;
import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;

/**
 *
 * @author Luiz
 */
public class Camera
{
    private float offX;
    private float offY;
    
    private String targetTag;
    private GameObject target = null;
    
    public Camera(String tag)
    {
        this.targetTag = tag;
    }
    
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        if(target == null)
        {
            target = gm.getObject(targetTag);
        }
        
        if(target == null)
        {
            return;
        }
        
        float targetX = (target.getPosX() + target.getWidth() / 2) - ge.getWidth() / 2;
        float targetY = (target.getPosY() + target.getHeight() / 2) - ge.getHeight() / 2;
//        System.out.println("CAM TARGET X: " + targetX);
//        System.out.println("CAM TARGET Y: " + targetY);

        //Check if Smooth mode is active
        if (gm.isCameraSmooth()) {
            offX -= deltaTime * (int)(offX - targetX) * 5;
            offY -= deltaTime * (int)(offY - targetY) * 5;
        } else {
            
            offX = targetX;
            offY = targetY;
        }
        
        if(offX < 0) offX = 0;
        if(offY < 0) offY = 0;
        if(offX + ge.getWidth() > gm.getLevelW() * GameManager.TILE_SIZE)
        {
            offX = gm.getLevelW() * GameManager.TILE_SIZE - ge.getWidth();
        } 
        if(offY + ge.getHeight() > gm.getLevelH() * GameManager.TILE_SIZE)
        {
            offY = gm.getLevelH() * GameManager.TILE_SIZE - ge.getHeight();
        }        
        
    }
    
    public void render(Renderer r)
    {
        r.setCamX((int) offX);
        r.setCamY((int) offY);
    }

    public float getOffX()
    {
        return offX;
    }

    public void setOffX(float offX)
    {
        this.offX = offX;
    }

    public float getOffY()
    {
        return offY;
    }

    public void setOffY(float offY)
    {
        this.offY = offY;
    }

    public String getTargetTag()
    {
        return targetTag;
    }

    public void setTargetTag(String targetTag)
    {
        this.targetTag = targetTag;
    }

    public GameObject getTarget()
    {
        return target;
    }

    public void setTarget(GameObject target)
    {
        this.target = target;
    }
    
    
}
