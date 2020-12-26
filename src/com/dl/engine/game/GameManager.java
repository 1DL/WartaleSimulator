/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.AbstractGame;
import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.audio.SoundClip;
import com.dl.engine.gfx.Image;
import com.dl.engine.gfx.ImageTile;
import com.dl.engine.gfx.Light;
import controller.assets.assetsController;
import java.awt.event.KeyEvent;

/**
 *
 * @author Luiz
 */
public class GameManager extends AbstractGame {
    
    private Image image;
    private ImageTile image2;
    private Light light;
    
    public GameManager() {
        
        image = new Image (assetsController.GAME_DIR + "wood.png");
        image.setLightBlock(Light.FULL);
        image.setAlpha(true);
        image2 = new ImageTile(assetsController.GAME_DIR + "bluesquares.png", 16, 16);
        image2.setAlpha(true);
        light = new Light(100, 0xff00ffff);
        
    }

    @Override
    public void update(GameEngine ge, float dt) {
        
    }

    @Override
    public void render(GameEngine ge, Renderer r) {
        
        
        r.setzDepth(0);
        r.drawImage(image2, 0, 0);
        r.drawImage(image, 100, 100);
        
        
        r.drawLight(light, ge.getInput().getMouseX(), ge.getInput().getMouseY());
        
    }
    
    public static void main(String args[]) {
        GameEngine ge = new GameEngine(new GameManager());
        ge.setWidth(320);
        ge.setHeight(240);
        ge.setScale(4f);
        ge.start();
    }
    
}
