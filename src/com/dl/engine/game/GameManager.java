/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.AbstractGame;
import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;

/**
 *
 * @author Luiz
 */
public class GameManager extends AbstractGame {
    
    public GameManager() {
                
    }

    @Override
    public void update(GameEngine ge, float dt) {
        
    }

    @Override
    public void render(GameEngine ge, Renderer r) {
                
    }
    
    public static void main(String args[]) {
        GameEngine ge = new GameEngine(new GameManager());
        ge.setWidth(320);
        ge.setHeight(240);
        ge.setScale(4f);
        ge.start();
    }
    
}
