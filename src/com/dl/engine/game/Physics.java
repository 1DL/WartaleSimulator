/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.game.components.AABBComponent;
import java.util.ArrayList;

/**
 *
 * @author Luiz
 */
public class Physics
{
    private static ArrayList<AABBComponent> aabbList = new ArrayList<AABBComponent>();
    
    public static void addAABBComponent(AABBComponent aabb)
    {
        aabbList.add(aabb);
    }
    
    public static void update()
    {
        for(int i = 0; i < aabbList.size(); i++)
        {
            for(int j = i + 1; j < aabbList.size(); j++)
            {
                AABBComponent c0 = aabbList.get(i);
                AABBComponent c1 = aabbList.get(j);
                
                if(Math.abs(c0.getCenterX() - c1.getCenterX()) < c0.getHalfWidth() + c1.getHalfWidth())
                {
                    if(Math.abs(c0.getCenterY() - c1.getCenterY()) < c0.getHalfHeight()+ c1.getHalfHeight())
                    {
                        c0.getParent().collision(c1.getParent());
                        c1.getParent().collision(c0.getParent());
                    }
                }
            }
        }
        
        aabbList.clear();
    }
}
