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
import controller.assets.assetsController;
import java.awt.event.KeyEvent;

/**
 *
 * @author Luiz
 */
public class GameManager extends AbstractGame {
    
    private ImageTile image;
    private SoundClip clip;
    private SoundClip clip2;
    private SoundClip clipBGM;
    
    public GameManager() {
        image = new ImageTile(assetsController.GAME_DIR + "wood.png", 16, 16);
        clip = new SoundClip(assetsController.SKILLSFX_DIR + "Knight/Grand Cross1.wav");
        clip.setVolume(-5.5f);
        
        clip2 = new SoundClip(assetsController.SKILLSFX_DIR + "Knight/Grand Cross2.wav");
        clip2.setVolume(-5.5f);
        
        clipBGM = new SoundClip(assetsController.BGM_WAV_DIR + "Hunter X Hunter - Kaze No Uta Instrumental - ORIGINAL SONG.wav");
    }

    @Override
    public void update(GameEngine ge, float dt) {
        if (!clipBGM.isRunning()) {
            clipBGM.play();
        }
        if(ge.getInput().isKeyDown(KeyEvent.VK_A)) {
            clip.play();
            System.out.println("Tecla A pressionada");
        }
        
        if(ge.getInput().isKeyDown(KeyEvent.VK_S)) {
            clip2.play();
            System.out.println("Tecla S pressionada");
        }
        temp += dt * 30;
        
        if (temp > 3) {
            temp = 0;
        }
    }

    float temp = 0;
    @Override
    public void render(GameEngine ge, Renderer r) {
        r.drawImageTile(image, ge.getInput().getMouseX() - 8, ge.getInput().getMouseY() - 16, (int)temp, 0);
    }
    
    public static void main(String args[]) {
        GameEngine ge = new GameEngine(new GameManager());
        ge.start();
    }
    
}
