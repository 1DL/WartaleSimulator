/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.helpers;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.audio.SoundClip;
import com.dl.engine.game.GameManager;
import com.dl.engine.game.objects.Player;
import com.dl.engine.gfx.ImageTile;
import controller.assets.assetsController;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Luiz
 */
public class PlayerState
{

    static final int ACTION_IDLE = 0;
    static final int ACTION_SPAWNING = 1;
    static final int ACTION_MOVING = 2;

    private int currentState;

    private float currentFrame = 0;
    private float playBackSpeed = 0.5f;
    private int tileY = 0;
    private int tileX = 0;
    private String spriteSheetDir;

    private ImageTile movementImage;
    private ImageTile activeImage;
    private Point mousePoint;
    
    protected Player player;
    
    private SoundClip sfx_spawn = new SoundClip(assetsController.SFX_EFFECT_SPAWN);
    private SoundClip sfx_spawn_end = new SoundClip(assetsController.SFX_EFFECT_SPAWN_END);
    private SoundClip sfx_footstep_grass_01 = new SoundClip(assetsController.SFX_FOOTSTEP_GRASS_01);
    private SoundClip sfx_footstep_grass_02 = new SoundClip(assetsController.SFX_FOOTSTEP_GRASS_02);
    public PlayerState(Player player)
    {
        this.player = player;
        this.currentState = ACTION_SPAWNING;
        movementImage = new ImageTile(player.getMovementSheetDir(), 32, 48);
        activeImage = movementImage;
        mousePoint = new Point();
        
    }

    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        currentFrame = currentFrame + 1f * playBackSpeed;
        switch (currentState)
        {
            case ACTION_SPAWNING:
                activeImage = movementImage;
                tileY = player.getSpriteAngle();
                switch ((int) currentFrame)
                {
                    case 2:
                        sfx_spawn.play();
                    case 900:
                        sfx_spawn_end.play();
                        currentState = ACTION_IDLE;
                        currentFrame = 0;
                    break;
                }
            break;
            case ACTION_IDLE:
                activeImage = movementImage;
                tileY = player.getSpriteAngle();
                switch ((int) currentFrame)
                {
                    case 20:
                        tileX = 1;
                    case 40:
                        tileX = 0;
                        currentFrame = 0;
                    break;
                }

                if (ge.getInput().isButtonUp(MouseEvent.BUTTON1))
                {
                    currentState = ACTION_MOVING;
                    currentFrame = 0;
                    mousePoint.x = ge.getInput().getMouseX();
                    mousePoint.y = ge.getInput().getMouseY();
                }
            break;
            case ACTION_MOVING:
                activeImage = movementImage;
                tileY = player.getSpriteAngle();
                
                mousePoint.x = ge.getInput().getMouseX();
                mousePoint.y = ge.getInput().getMouseY();
                player.move(gm, deltaTime, mousePoint);
                
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 1;
                    break;
                    case 5:
                        tileX = 2;
                    break;
                    case 10:
                        tileX = 3;
                    break;
                    case 15:
                        tileX = 2;
                    break;
                    case 20:
                        tileX = 1;
                        if (gm.getIntRandom(1, 2) == 1) {
                            sfx_footstep_grass_01.play();
                        } else {
                            sfx_footstep_grass_02.play();
                        }
                    break;
                    case 25:
                        tileX = 4;
                    break;
                    case 30:
                        tileX = 5;
                    break;
                    case 35:
                        tileX = 4;
                        
                    break;
                    case 40:
                        tileX = 1;
                        if (gm.getIntRandom(1, 2) == 1) {
                            sfx_footstep_grass_01.play();
                        } else {
                            sfx_footstep_grass_02.play();
                        }
                        currentFrame = 0;
                    break;
                }
                
                if (ge.getInput().isButtonUp(MouseEvent.BUTTON1)){
                    currentState = ACTION_IDLE;
                }
                
            break;
            
        }
    }
    
    public void render(GameEngine ge, Renderer r)
    {
        
        r.drawImageTile(activeImage, (int) player.getPosX(), (int) player.getPosY(), (int) tileX, tileY);
    }

    public int getCurrentState()
    {
        return currentState;
    }
    
    public String getCurrentStateString()
    {
        switch (currentState) {
            case ACTION_SPAWNING:
                return "Spawning";
            case ACTION_IDLE:
                return "Idle";
            case ACTION_MOVING:
                return "Moving";
            default:
                return "Unkwnown";
        }
    }

    public void setCurrentState(int currentState)
    {
        this.currentState = currentState;
    }

    public float getCurrentFrame()
    {
        return currentFrame;
    }
    
    
}
