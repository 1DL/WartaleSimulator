/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game.objects;

import com.dl.engine.game.components.Component;
import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.game.GameManager;
import java.util.ArrayList;

/**
 *
 * @author Luiz
 */
public abstract class GameObject
{
    protected String tag;
    protected float posX, posY;
    protected int width, height;
    protected int padding, paddingTop;
    protected boolean dead = false;
    
    protected ArrayList<Component> components = new ArrayList<Component>();
    
    public abstract void update(GameEngine ge, GameManager gm, float deltaTime);
    public abstract void render(GameEngine ge, Renderer r);
    public abstract void collision(GameObject other);
    
    public void updateComponents(GameEngine ge, GameManager gm, float deltaTime)
    {
        for(Component c : components)
        {
            c.update(ge, gm, deltaTime);
        }
    }
    
    public void renderComponents(GameEngine ge, Renderer r)
    {
        for(Component c : components)
        {
            c.render(ge, r);
        }
    }
    
    public void addComponent(Component c)
    {
        components.add(c);
    }
    
    public void removeComponent(String tag)
    {
        for (int i = 0; i < components.size(); i++)
        {
            if (components.get(i).getTag().equalsIgnoreCase(tag))
            {
                components.remove(i);
            }
        }
    }
    
    public Component findComponent(String tag)
    {
        for (int i = 0; i < components.size(); i++)
        {
            if (components.get(i).getTag().equalsIgnoreCase(tag))
            {
                return components.get(i);
            }
        }
        
        return null;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public float getPosX()
    {
        return posX;
    }

    public void setPosX(float posX)
    {
        this.posX = posX;
    }

    public float getPosY()
    {
        return posY;
    }

    public void setPosY(float posY)
    {
        this.posY = posY;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public boolean isDead()
    {
        return dead;
    }

    public void setDead(boolean dead)
    {
        this.dead = dead;
    }

    public int getPadding()
    {
        return padding;
    }

    public void setPadding(int padding)
    {
        this.padding = padding;
    }

    public int getPaddingTop()
    {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop)
    {
        this.paddingTop = paddingTop;
    }
    
    
}
