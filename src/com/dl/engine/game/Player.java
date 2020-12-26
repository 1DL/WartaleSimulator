/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;

/**
 *
 * @author Luiz
 */
public class Player extends GameObject
{
    public Player(int posX, int posY)
    {
        this.tag = "player";
        this.posX = posX * 16;
        this.posY = posY * 16;
    }

    @Override
    public void update(GameEngine ge, float deltaTime)
    {
        
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        
    }
    
}
