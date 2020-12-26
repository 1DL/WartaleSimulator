/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.AbstractGame;
import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import java.util.ArrayList;

/**
 *
 * @author Luiz
 */
public class GameManager extends AbstractGame {
    
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    
    public GameManager() {
                
    }

    @Override
    public void update(GameEngine ge, float deltaTime) {
        for(int i = 0; i < objects.size(); i++)
        {
            objects.get(i).update(ge, deltaTime);
            if(objects.get(i).isDead())
            {
                objects.remove(i);
                i--;
            }
        }
    }

    @Override
    public void render(GameEngine ge, Renderer r) {
        for(GameObject obj : objects)
        {
            obj.render(ge, r);
        }
    }
    
    public static void main(String args[]) {
        GameEngine ge = new GameEngine(new GameManager());
        ge.setWidth(320);
        ge.setHeight(240);
        ge.setScale(4f);
        ge.start();
    }
    
}
