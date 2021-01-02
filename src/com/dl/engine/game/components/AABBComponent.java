/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game.components;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.game.GameManager;
import com.dl.engine.game.Physics;
import com.dl.engine.game.objects.GameObject;

/**
 *
 * @author Luiz
 */
//AABB = Axis Aligned Bounding Box
public class AABBComponent extends Component
{
    private GameObject parent;
    private int centerX, centerY;
    private int halfWidth,  halfHeight;
    private int lastCenterX, lastCenterY;
    
    public AABBComponent(GameObject parent)
    {
        this.parent = parent;
        this.tag = "aabb";
    }

    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        lastCenterX = centerX;
        lastCenterY = centerY;
        
        centerX = (int) (parent.getPosX() + (parent.getWidth()  / 2));
        centerY = (int) (parent.getPosY() + (parent.getHeight() / 2) + (parent.getPaddingTop() / 2));
        halfWidth =     (parent.getWidth()  / 2) -  parent.getPadding();
        halfHeight =    (parent.getHeight() / 2) - (parent.getPaddingTop() / 2);
        
        Physics.addAABBComponent(this);
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawRect(centerX - halfWidth, centerY - halfHeight, halfWidth * 2, halfHeight * 2, 0xff000000);
    }

    public int getCenterX()
    {
        return centerX;
    }

    public void setCenterX(int centerX)
    {
        this.centerX = centerX;
    }

    public int getCenterY()
    {
        return centerY;
    }

    public void setCenterY(int centerY)
    {
        this.centerY = centerY;
    }

    public int getHalfWidth()
    {
        return halfWidth;
    }

    public void setHalfWidth(int halfWidth)
    {
        this.halfWidth = halfWidth;
    }

    public int getHalfHeight()
    {
        return halfHeight;
    }

    public void setHalfHeight(int halfHeight)
    {
        this.halfHeight = halfHeight;
    }

    public GameObject getParent()
    {
        return parent;
    }

    public void setParent(GameObject parent)
    {
        this.parent = parent;
    }

    public int getLastCenterX()
    {
        return lastCenterX;
    }

    public void setLastCenterX(int lastCenterX)
    {
        this.lastCenterX = lastCenterX;
    }

    public int getLastCenterY()
    {
        return lastCenterY;
    }

    public void setLastCenterY(int lastCenterY)
    {
        this.lastCenterY = lastCenterY;
    }
    
    
}
