/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game.objects;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.game.GameManager;
import com.dl.engine.game.components.AABBComponent;

/**
 *
 * @author Luiz
 */
public class Platform extends GameObject
{
    private int color = (int)(Math.random() * Integer.MAX_VALUE);
    public Platform()
    {
        this.tag = "platform";
        this.width = 32;
        this.height = 16;
        this.padding = 0;
        this.paddingTop = 0;
        this.posX = 176;
        this.posY = 160;
        
        this.addComponent(new AABBComponent(this));
    }
    
    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        this.updateComponents(ge, gm, deltaTime);
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawFillRect((int)posX, (int)posY, width, height, color);
        this.renderComponents(ge, r);
    }

    @Override
    public void collision(GameObject other)
    {
        color = (int) (Math.random() * Integer.MAX_VALUE);
    }
    
}
