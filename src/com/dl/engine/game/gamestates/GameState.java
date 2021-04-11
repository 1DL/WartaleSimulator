/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game.gamestates;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.game.GameManager;
import com.dl.engine.game.objects.GameObject;
import java.util.ArrayList;

/**
 *
 * @author Luiz
 */
public abstract class GameState 
{
    public static final int STATUS_NOT_INIT = 0;
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_PAUSED = 2;
    public static final int STATUS_DEAD = 3;
    
    protected String tag;
    protected int status;
    
    protected ArrayList<GameObject> objects = new ArrayList<GameObject>();
    
    public abstract void update(GameEngine ge, GameManager gm, float deltaTime);
    public abstract void render(GameEngine ge, Renderer r);
    
    public void addObject(GameObject obj)
    {
        objects.add(obj);
    }
    
    public void removeObject(String tag)
    {
        for (int i = 0; i < objects.size(); i++)
        {
            if (objects.get(i).getTag().equalsIgnoreCase(tag))
            {
                objects.remove(i);
            }
        }
    }
    
    public GameObject findObject(String tag)
    {
        for (int i = 0; i < objects.size(); i++)
        {
            if (objects.get(i).getTag().equalsIgnoreCase(tag))
            {
                return objects.get(i);
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

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
    
    
}
